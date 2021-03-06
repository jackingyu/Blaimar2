package com.third.facade.testdata.builder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import com.third.core.constants.CoreConstants.PaymentMethod;
import com.third.core.constants.CoreConstants.PaymentType;
import com.third.model.AddressModel;
import com.third.model.CustomerModel;
import com.third.model.OrderEntryModel;
import com.third.model.OrderModel;
import com.third.model.OrderProcessRecordModel;
import com.third.model.PaymentModel;
import com.third.model.SourceModel;
import com.third.model.StoreModel;
import com.third.service.customer.CustomerService;
import com.third.service.customer.SourceService;
import com.third.service.order.OrderProcessService;
import com.third.service.order.OrderService;
import com.third.service.product.ProductService;
import com.third.service.store.StoreService;
import com.third.service.user.UserService;

public class LotsOrderDataBuilder {
	@Resource(name = "orderService")
	private OrderService orderService;

	@Resource(name = "storeService")
	private StoreService storeService;

	@Resource(name = "customerService")
	private CustomerService customerService;

	@Resource(name = "userService")
	private UserService userService;

	@Resource(name = "productService")
	private ProductService productService;

	@Resource(name = "orderProcessService")
	private OrderProcessService orderProcessService;

	@Resource(name = "sourceService")
	private SourceService sourceService;

	private List<SourceModel> sources;

	public void buildData(final Integer start, final Integer length)
	{
		sources = sourceService.getSources();

		for (int i = 0; i < length; i++)
		{
			Integer orderCode = start + i;
			buildOrder("m" + orderCode.toString());
		}

	}

	public void buildOrderProcess(final OrderModel orderModel)
	{
		OrderProcessRecordModel op = new OrderProcessRecordModel();
		op.setMessage("dadfds");
		op.setOrderCode(orderModel.getCode());
		op.setFromStatus("0");
		op.setToStatus("1");
		orderProcessService.createOrderProcess(op);
	}

	public OrderModel buildOrder(final String orderCode)
	{
		OrderModel orderModel = new OrderModel();

		orderModel.setCode(orderCode);

		Calendar calendar = Calendar.getInstance();
		Date today = new Date();
		orderModel.setDeliveryDate(
				getNextDay(today, RandomUtils.nextInt(0, 365)));
		orderModel.setOrderDate(getNextDay(today, 365));
		orderModel.setStore(storeService.getStoreForCode("s-1"));
		orderModel.setPhotoDate(getNextDay(today, 3));
		orderModel.setWeddingDate(getNextDay(today, 20));
		orderModel.setStatus(0);
		CustomerModel customer = buildCustomer("13800138001" + orderCode,
				"name" + orderCode);
		orderModel.setCustomer(customer);
		orderModel.setSalesperson(
				userService.getUserById("test" + RandomUtils.nextInt(0, 20)));
		StoreModel store = storeService.getStoreForCode("s-1");
		orderModel.setStore(store);

		PaymentModel paymentModel = new PaymentModel();
		paymentModel.setPaymentMethod(PaymentMethod.Cash);
		paymentModel.setPaymentType(PaymentType.DownPayment);
		paymentModel.setPaymentEntryNo(10);
		paymentModel.setAmount(BigDecimal.valueOf(100.00));
		paymentModel.setPaidTime(Calendar.getInstance().getTime());
		paymentModel.setStore(store);

		List<PaymentModel> payments = new ArrayList<PaymentModel>();
		payments.add(paymentModel);

		BigDecimal paidamount = new BigDecimal(100);

		for (int i = 0; i < 5; i++)
		{
			PaymentModel paymentModel1 = new PaymentModel();
			paymentModel1.setPaymentMethod(PaymentMethod.CreditCard);
			paymentModel1.setPaymentType(PaymentType.NormalPayment);
			paymentModel1.setPaymentEntryNo(10 + i);
			paymentModel.setStore(store);
			paymentModel1
					.setAmount(BigDecimal.valueOf(RandomUtils.nextInt(1, 199)));
			paymentModel1.setPaidTime(Calendar.getInstance().getTime());
			payments.add(paymentModel1);
			paidamount = paidamount.add(paymentModel1.getAmount());
		}

		orderModel.setReceiveable(
				BigDecimal.valueOf(RandomUtils.nextInt(1000, 9999)));
		orderModel.setPaidamount(paidamount);
		orderModel.setOpenamount(orderModel.getReceiveable()
				.subtract(orderModel.getPaidamount()));

		OrderEntryModel entry = new OrderEntryModel();
		entry.setQuantity(11);
		entry.setEntryNo(1);
		entry.setComment("test order entry");
		entry.setDeliveryDate(new Date());
		entry.setSizeDate(new Date());
		entry.setItemCategory("10");
		entry.setStyle("测试规格");
		entry.setProductTitle("成品西装");
		entry.setSizeDate(new Date());
		entry.setDesigner(userService.getDesignerForStore(entry.getStore().getId()).get(0));
		entry.setTryDate(new Date());
		entry.setComment("我是一个备注备注备注");
		entry.setStore(store);
		entry.setProduct(productService
				.getProductForCode("p-" + RandomUtils.nextInt(0, 50)));
		List<OrderEntryModel> entries = new ArrayList<OrderEntryModel>();
		entries.add(entry);

		orderModel.setOrderEntries(entries);
		orderModel.setPayments(payments);

		orderService.createOrder(orderModel);
		return orderModel;
	}

	public static Date getNextDay(Date date, int after)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, +after);// +1今天的时间加一天
		date = calendar.getTime();
		return date;
	}

	public CustomerModel buildCustomer(final String cellphone,
			final String name)
	{
		CustomerModel customer = new CustomerModel();
		customer.setCellphone(cellphone);
		customer.setName(name);
		customer.setBirthday(new Date());
		customer.setWeddingDate(new Date());
		customer.setEmail("dd@tt.com");
		customer.setComment("yekongzhongzuiliangdexing");
		customer.setQQ("33445566");
		customer.setSource(sources.get(RandomUtils.nextInt(0, 5)));

		customerService.createCustomer(customer);
		return customer;
	}

}
