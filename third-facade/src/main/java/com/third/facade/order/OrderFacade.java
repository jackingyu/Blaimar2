package com.third.facade.order;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.third.exceptions.ProductNotFoundException;
import com.third.facade.data.DTResults;
import com.third.facade.data.ListData;
import com.third.facade.data.OrderData;
import com.third.facade.data.OrderEntryData;
import com.third.facade.data.PaymentData;
import com.third.facade.data.SizeAttributeGroupData;
import com.third.facade.populator.option.OrderOption;
import com.third.model.OrderModel;

public interface OrderFacade {
	void createOrder(OrderData orderData);

	DTResults getOrders(Date startDate, Date endDate, Integer startIndex,
			Integer pageSize, Map<String, String> sp);

	@Deprecated
	OrderData getOrder(final String orderCode);

	OrderData getOrderForOptions(final String orderCode,
			final Collection<OrderOption> orderOption);

	void updateOrder(final OrderData order);

	void createOrderEntry(final OrderEntryData orderEntryData) throws ProductNotFoundException;

	void updateOrderEntry(final OrderEntryData orderEntryData) throws ProductNotFoundException;

	void removeOrderEntry(final String orderEntryPK);

	DTResults getOrderEntries(Date startDate, Date endDate, Integer startIndex,
			Integer pageSize, Map<String, String> sp);

	OrderEntryData getOrderEntry(final String orderEntryPK);

	String[] createPayment(final PaymentData payment);

	String[] removePayment(final String paymentPK);

	/**
	 * @param itemCategory
	 * @return in the map key: 10-L 量,20-剪,30-裁
	 */
	Map<String, SizeAttributeGroupData> getSizeAttributes(
			final Integer itemCategory);

	OrderEntryData getSizeDatas(String orderEntryPK);

	String uploadMediaForOrderEntry(final String entryPK,
			final MultipartFile media);

	String getMediaForOrderEntry(final String entryPK);

	List<OrderData> getOrdersForCustomer(final String customerPK);

	DTResults getOrderEntriesByPKorId(String entryPK, String externalId);

	DTResults getOrderEntriesByPKorId(String entryPK, String externalId,
			Integer status);
	
	boolean isExist(final String orderCode);
	
	List<OrderData> getOrdersForCurrentUser(Integer orderStatus);

	List<Object[]> exportOrderEntries(Date startDate, Date endDate, int i, int j,
			Map<String, String> sp);

    void updateOrderEntryActualTryDate(OrderEntryData orderEntryData);

    OrderData getOrderForOptionsByPK(String orderPK,
            Collection<OrderOption> orderOptions);
	
}
