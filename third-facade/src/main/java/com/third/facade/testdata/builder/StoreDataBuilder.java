package com.third.facade.testdata.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.RandomUtils;

import com.third.dao.user.UserDao;
import com.third.model.AddressModel;
import com.third.model.CityModel;
import com.third.model.CoreConstants;
import com.third.model.CustomerModel;
import com.third.model.RegionModel;
import com.third.model.SourceModel;
import com.third.model.StoreModel;
import com.third.model.UserModel;
import com.third.service.customer.CustomerService;
import com.third.service.customer.SourceService;
import com.third.service.location.I18NService;
import com.third.service.store.StoreService;
import com.third.service.user.UserService;

public class StoreDataBuilder implements DataBuilder {
	private I18NService i18NService;
	private CustomerService customerService;
	private StoreService storeService;
	@Resource(name = "sourceService")
	private SourceService sourceService;
	@Resource(name = "userDao")
	private UserDao userDao;

	private List<SourceModel> sourceModels = new ArrayList<SourceModel>();;

	@Override
	public void buildData()
	{
		for (int i = 0; i < 30; i++)
		{
			SourceModel source = new SourceModel();
			if(RandomUtils.nextBoolean())
			{
				source.setName("合作伙伴" + RandomUtils.nextInt());
				source.setType(CoreConstants.SourceType.NORMAL);
			}
			else
			{
				source.setName("展会" + RandomUtils.nextInt());
				source.setType(CoreConstants.SourceType.EXHIBITION);
			}
			sourceService.createSource(source);
		
			sourceModels.add(source);
		}

		RegionModel region = buildRegion("cn11", "上海市");
		CityModel city = buildCity("cn12", "上海市", region);
		RegionModel region1 = buildRegion("CN13", "江苏省");
		CityModel city1 = buildCity("CN14", "泰州市", region);
		AddressModel address = buildAddress(region, city, "闵行区古龙路XX弄");
		AddressModel address1 = buildAddress(region1, city1, "泰兴市江平路22号");
		StoreModel store = buildStore("s-1", "南方一店", address);
		StoreModel store1 = buildStore("a-1", "王者荣耀店", address);

		for (int i = 2; i < 30; i++)
		{
			String storeName = "默认店名";

			if (i <= 10)
			{
				storeName = "南方" + i + "店";
				buildStore("s-" + i, storeName, address);
				continue;
			}

			if (i > 10 && i <= 20)
			{

				storeName = "北方" + i + "店";
				buildStore("s-" + i, storeName, address);
				continue;
			}

			if (i > 20)
			{
				storeName = "森林" + i + "店";
				buildStore("s-" + i, storeName, address1);
				continue;

			}
		}

		List<UserModel> userList = userDao.list();

		for (int i = 0; i < userList.size(); i++)
		{
			UserModel user = userList.get(i);

			user.setStores(Arrays.asList(store, store1));

			userDao.update(user);
		}

		UserModel user1 = userDao.findUserById("test");
		user1.setStores(Arrays.asList(store, store1));
		userDao.update(user1);

		for (int i = 0; i < 100; i++)
		{
			AddressModel address5 = buildAddress(region, city,
					"shanghai street" + i);
			buildCustomer("1380013800" + i, "fly" + i, address5);
		}

		for (int i = 0; i < 10; i++)
		{
			buildSource("客户来源" + i);
		}
		
		for (int i = 10; i < 15; i++)
		{
			buildExhibition("展会" + i);
		}

	}

	public SourceModel buildSource(final String name)
	{
		SourceModel source = new SourceModel();
		source.setName(name);
		source.setType(CoreConstants.SourceType.NORMAL);
		sourceService.createSource(source);
		return source;
	}
	
	public SourceModel buildExhibition(final String name)
	{
		SourceModel source = new SourceModel();
		source.setName(name);
		source.setType(CoreConstants.SourceType.EXHIBITION);
		sourceService.createSource(source);
		return source;
	}

	public StoreModel buildStore(final String id, final String name,
			final AddressModel address)
	{
		StoreModel store = new StoreModel();
		store.setId(id);
		store.setAddress(address);
		store.setName(name);
		List<SourceModel> sources = new ArrayList<SourceModel>();

		int j = RandomUtils.nextInt(10, 15);

		for (int i = 0; i < j; i++)
		{
			sources.add(sourceModels.get(i));
		}

		store.setSources(sources);
		storeService.createStore(store);

		return store;
	}

	public CustomerModel buildCustomer(final String cellphone,
			final String name, final AddressModel address)
	{
		CustomerModel customer = new CustomerModel();
		customer.setCellphone(cellphone);
		customer.setName(name);
		customer.setAddress(address);
		customer.setBirthday(new Date());
		customer.setWeddingDate(new Date());
		customer.setEmail("dd@tt.com");
		customer.setComment("yekongzhongzuiliangdexing");
		customer.setQQ("33445566");
		customerService.createCustomer(customer);
		return customer;
	}

	public RegionModel buildRegion(final String code, final String name)
	{
		RegionModel region = new RegionModel();
		region.setName(name);
		region.setIsoCode(code);
		i18NService.createRegion(region);
		return region;
	}

	public CityModel buildCity(final String code, final String name,
			RegionModel region)
	{
		CityModel city = new CityModel();
		city.setIsoCode(code);
		city.setName(name);
		city.setRegion(region);
		i18NService.createCity(city);
		return city;
	}

	public AddressModel buildAddress(final RegionModel region,
			final CityModel city, final String adr1)
	{
		AddressModel address = new AddressModel();
		address.setCity(city);
		address.setRegion(region);
		address.setAdr1(adr1);
		address.setTel1("02160306796");
		i18NService.createAddress(address);
		return address;
	}

	public void setI18NService(I18NService i18nService)
	{
		i18NService = i18nService;
	}

	public void setCustomerService(CustomerService customerService)
	{
		this.customerService = customerService;
	}

	public void setStoreService(StoreService storeService)
	{
		this.storeService = storeService;
	}

}
