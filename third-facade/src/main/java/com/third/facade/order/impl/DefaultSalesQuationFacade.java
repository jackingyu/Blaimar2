package com.third.facade.order.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.third.dao.util.PaginationSupport;
import com.third.facade.data.DTResults;
import com.third.facade.data.SalesQuationData;
import com.third.facade.order.SalesQuationFacade;
import com.third.facade.utils.DTResultConvertor;
import com.third.facade.utils.TextMapperUtils;
import com.third.model.SalesQuationModel;
import com.third.service.order.SalesQuationService;

public class DefaultSalesQuationFacade implements SalesQuationFacade {

	private SalesQuationService salesQuationService;

	@Override
	public void saveSalesQuation(SalesQuationData salesQuationData)
	{
		SalesQuationModel salesQuation = null;
		if (StringUtils.isNotEmpty(salesQuationData.getPk()))
			salesQuation = salesQuationService
					.getSalesQuation(salesQuationData.getPk());

		salesQuation.setCellphone(salesQuationData.getCellphone());
		salesQuation.setCustomerName(salesQuationData.getCustomerName());
		salesQuation.setComment(salesQuationData.getComment());
		salesQuation.setPaidamount(BigDecimal
				.valueOf(Double.valueOf(salesQuationData.getPaidamount())));
		salesQuation.setPaymentMethod(salesQuationData.getPaymentMethod());

		salesQuationService.saveSalesQuation(salesQuation);
	}

	@Override
	public DTResults getSalesQuation(Date startDate, Date endDate,
			Integer startIndex, Integer pageSize, Map<String, String> sp)
	{
		PaginationSupport ps = this.salesQuationService
				.getSalesQuations(startDate, endDate, startIndex, pageSize, sp);
		DTResults result = DTResultConvertor.convertPS2DT(ps);
		List<Object[]> arrays = result.getData();

		// translate paymentmethod to paymentmoethodtext
		arrays.forEach(a -> {
			a[4] = TextMapperUtils.getPaymentMethodText(a[4].toString());
		});

		return result;
	}

	@Override
	public void convertQuation2Order(SalesQuationData salesQuationData)
	{
		// TODO Auto-generated method stub

	}

	public void setSalesQuationService(SalesQuationService salesQuationService)
	{
		this.salesQuationService = salesQuationService;
	}

}