package com.third.service.order;

import java.util.Date;
import java.util.Map;

import com.third.dao.util.PaginationSupport;
import com.third.model.OrderModel;
import com.third.model.PaymentModel;


public interface PaymentService
{
	void createPayment(PaymentModel payment);
	
	void removePayment(final String paymentPK);
	
	PaymentModel getPayment(final String paymentPK);
	
	PaginationSupport getPayments(final Date startDate, final Date endDate, final Integer startIndex, final Integer pageSize,
			final Map<String, String[]> sp);

}
