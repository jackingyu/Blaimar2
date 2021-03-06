package com.third.facade.testdata.builder;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang3.RandomUtils;

import com.third.core.constants.CoreConstants;
import com.third.dao.customer.CustomerDao;
import com.third.dao.location.CityDao;
import com.third.model.CityModel;
import com.third.model.CustomerModel;
import com.third.model.ReservationModel;
import com.third.model.StoreModel;
import com.third.service.customer.CustomerService;
import com.third.service.customer.ReservationService;
import com.third.service.store.StoreService;

public class ReservationDataBuilder implements DataBuilder {
	@Resource(name = "reservationService")
	private ReservationService reservationService;

	@Resource(name = "cityDao")
	private CityDao cityDao;

	@Resource(name = "storeService")
	private StoreService storeService;

	@Resource(name = "customerService")
	private CustomerService customerService;
	@Resource(name = "customerDao")
	private CustomerDao customerDao;

	@Override
	public void buildData()
	{
		CustomerModel customer = customerDao.list().get(RandomUtils.nextInt(0,5));
		StoreModel store = storeService.getStoreForCode("1");
		CityModel city = cityDao.get("cn12");

		for (int i = 0; i < 20; i++)
		{
			ReservationModel reservation = new ReservationModel();
			reservation.setChannel(CoreConstants.ReservationChannel.Web);
			reservation.setCity(city);
			reservation.setCustomer(customer);
			reservation.setName("tt");
			reservation.setCellphone(customer.getCellphone());
			reservation.setReservationDate(new Date());
			reservation.setStatus(0);
			reservation.setStore(store);
			reservationService.createrReservation(reservation);
		}

		for (int i = 0; i < 20; i++)
		{
			ReservationModel reservation = new ReservationModel();
			reservation.setChannel(CoreConstants.ReservationChannel.Weixin);
			reservation.setCity(city);
			reservation.setCustomer(customer);
			reservation.setName("tt");
			reservation.setCellphone(customer.getCellphone());
			reservation.setReservationDate(new Date());
			reservation.setStatus(0);
			reservation.setStore(store);
			reservationService.createrReservation(reservation);
		}

	}

}
