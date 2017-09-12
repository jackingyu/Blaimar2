package com.third.facade.order.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.third.dao.util.PaginationSupport;
import com.third.facade.data.DTResults;
import com.third.facade.data.SalesQuotationData;
import com.third.facade.order.SalesQuotationFacade;
import com.third.facade.populator.SalesQuotationDataPopulator;
import com.third.facade.utils.DTResultConvertor;
import com.third.facade.utils.TextMapperUtils;
import com.third.model.SalesQuotationModel;
import com.third.model.SourceModel;
import com.third.service.customer.SourceService;
import com.third.service.order.SalesQuotationService;

public class DefaultSalesQuotationFacade implements SalesQuotationFacade {

	private SalesQuotationService salesQuotationService;
	private SourceService sourceService;
	private SalesQuotationDataPopulator salesQuotationDataPopulator;

	@Override
	public String saveSalesQuotation(SalesQuotationData salesQuotationData)
	{
		SalesQuotationModel salesQuotation = null;
		if (StringUtils.isNotEmpty(salesQuotationData.getPk()))
			salesQuotation = salesQuotationService
					.getSalesQuotation(salesQuotationData.getPk());
		else
			salesQuotation = new SalesQuotationModel();

		salesQuotation.setCellphone(salesQuotationData.getCellphone());
		salesQuotation.setCustomerName(salesQuotationData.getCustomerName());
		salesQuotation.setComment(salesQuotationData.getComment());
		salesQuotation.setPaidamount(BigDecimal
				.valueOf(Double.valueOf(salesQuotationData.getPaidamount())));
		salesQuotation.setPaymentMethod(salesQuotationData.getPaymentMethod());
        salesQuotation.setCoSalesperson(salesQuotationData.getCoSalesperson());
        salesQuotation.setDeliveryDate(salesQuotationData.getDeliveryDate());
        salesQuotation.setWeddingDate(salesQuotationData.getWeddingDate());
        salesQuotation.setTryDate(salesQuotationData.getTryDate());
        salesQuotation.setPhotoDate(salesQuotationData.getPhotoDate());
        if(salesQuotationData.getSource()!=null)
        {
          SourceModel sourceModel = sourceService.getSource(salesQuotationData.getSource().getPk());
          salesQuotation.setSource(sourceModel);
        }
		salesQuotationService.saveSalesQuotation(salesQuotation);
		
		return salesQuotation.getPk();
	}

	@Override
	public DTResults getSalesQuotation(Date startDate, Date endDate,
			Integer startIndex, Integer pageSize, Map<String, String> sp)
	{
		PaginationSupport ps = this.salesQuotationService
				.getSalesQuotations(startDate, endDate, startIndex, pageSize, sp);
		DTResults result = DTResultConvertor.convertPS2DT(ps);
		List<Object[]> arrays = result.getData();

		// translate paymentmethod to paymentmoethodtext
		arrays.forEach(a -> {
			a[4] = TextMapperUtils.getPaymentMethodText(a[4].toString());
		});

		return result;
	}

	@Override
	public void convertQuotation2Order(SalesQuotationData salesQuotationData)
	{
		// TODO Auto-generated method stub

	}

	public void setSalesQuotationService(SalesQuotationService salesQuotationService)
	{
		this.salesQuotationService = salesQuotationService;
	}

	
	public void setSalesQuotationDataPopulator(
			SalesQuotationDataPopulator salesQuotationDataPopulator)
	{
		this.salesQuotationDataPopulator = salesQuotationDataPopulator;
	}

	@Override
	public SalesQuotationData getSalesQuotation(String pk)
	{
		SalesQuotationModel sq = salesQuotationService.getSalesQuotation(pk);
		SalesQuotationData sqData = new SalesQuotationData();
		salesQuotationDataPopulator.populate(sq, sqData);
		return sqData;
	}

	public void setSourceService(SourceService sourceService)
	{
		this.sourceService = sourceService;
	}

	@Override
	public String convert2SalesOrder(String pk)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
