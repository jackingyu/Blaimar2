package com.third.controller.pages.lte;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.log4j.Logger;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.third.controller.pages.AbstractPageController;
import com.third.controller.pages.ControllerConstants;
import com.third.core.util.DataTableCriterias;
import com.third.facade.data.DTResults;
import com.third.facade.data.OrderData;
import com.third.facade.data.PaymentData;
import com.third.facade.data.StoreData;
import com.third.facade.data.TextMapper;
import com.third.facade.order.OrderFacade;
import com.third.facade.populator.option.OrderOption;
import com.third.facade.utils.TextMapperUtils;
import com.third.model.CoreConstants;


@Controller
public class OrderPageController extends AbstractPageController
{
	private static final Logger LOG = Logger.getLogger(com.third.controller.pages.lte.OrderPageController.class);
	private static final String ORDER_CODE_PATH_VARIABLE_PATTERN = "/{orderCode:.*}";

	@Resource(name = "orderFacade")
	private OrderFacade orderFacade;


	@RequestMapping(value = "/order/orderlistpage", method = RequestMethod.GET)
	public String orderListPage(Model model)
	{
		fillAllStore2View(model);
		fillOrderStatus2View(model);
		return ControllerConstants.LTE.ORDERLISTPAGE;
	}

	@RequestMapping(value = "/order/orderlist")
	@ResponseBody
	public Object getOrderList(@RequestParam(value = "orderCode", required = false) final String orderCode,
			@RequestParam(value = "cellphone", required = false) final String cellphone,
			@RequestParam(value = "customerName", required = false) final String name,
			@RequestParam(value = "orderDate", required = false) final String orderDate,
			@RequestParam(value = "storeCodes", required = false) final String storeCodes,
			@RequestParam(value = "orderStatus", required = false) final String orderStatus,
			@RequestParam(value = "startDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
			@RequestParam(value = "endDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
			final DataTableCriterias criterias)
	{
		Map<String, String> sp = new HashMap<String, String>();
		sp.put("cellphone", cellphone);
		sp.put("orderCode", orderCode);
		sp.put("name", name);
		sp.put("orderDate", orderDate);
		sp.put("orderStatus", orderStatus);

		sp.put("storeCodes", storeCodes);

		DTResults r = orderFacade.getOrders(startDate, endDate, criterias.getStart(), criterias.getLength(), sp);

		return r;
	}

	@RequestMapping(value = "/order/get/" + ORDER_CODE_PATH_VARIABLE_PATTERN, method = RequestMethod.GET)
	public String orderDetail(@PathVariable("orderCode") String orderCode, final Model model, final HttpServletRequest request,
			final HttpServletResponse response)
	{
		LOG.info("orderCode:" + orderCode);
		OrderData orderData = orderFacade.getOrderForOptions(orderCode, Arrays.asList(OrderOption.BASIC, OrderOption.PAYMENTS));
		model.addAttribute("paymentTypes", TextMapperUtils.getPaymentTypes());

		model.addAttribute("paymentMethods", TextMapperUtils.getPaymentMethods());
		model.addAttribute("order", orderData);
		return ControllerConstants.LTE.ORDERDETAILSPAGE;
	}

	@RequestMapping(value = "/order/createorderpage", method = RequestMethod.GET)
	public String getCreateOrderPage(final Model model, final HttpServletRequest request, final HttpServletResponse response)
	{
		fillAllStore2View(model);
		return ControllerConstants.LTE.CREATEORDERPAGE;
	}

	@RequestMapping(value = "/order/modifyorderpage" + ORDER_CODE_PATH_VARIABLE_PATTERN, method = RequestMethod.GET)
	public String getModifyOrderPage(@PathVariable("orderCode") String orderCode, final Model model,
			final HttpServletRequest request, final HttpServletResponse response)
	{
      //TODO:如果角色只有销售员,则只允许看到自己的订单
		OrderData orderData = orderFacade.getOrderForOptions(orderCode,
				Arrays.asList(OrderOption.BASIC, OrderOption.PAYMENTS, OrderOption.ENTRIES));
		model.addAttribute("paymentTypes", TextMapperUtils.getPaymentTypes());

		model.addAttribute("paymentMethods", TextMapperUtils.getPaymentMethods());
		model.addAttribute("itemCategorys", TextMapperUtils.getItemCategories());
		model.addAttribute("orderData", orderData);
		model.addAttribute("statusText", orderData.getStatusText());
		
		model.addAttribute("editable",orderData.getStatus().equals(CoreConstants.OrderStatus.NEW));
		
		fillStore2View(model, orderData.getStore().getCode());
		return ControllerConstants.LTE.MODIFYORDERPAGE;
	}

	@RequestMapping(value = "/order/addpayment", method = RequestMethod.POST)
	@ResponseBody
	public Object addPayment(@RequestParam(value = "orderCode", required = true) final String orderCode,
			@RequestParam(value = "paymentMethod", required = true) final String paymentMethod,
			@RequestParam(value = "paymentType", required = true) final String paymentType,
			@RequestParam(value = "amount", required = true) final BigDecimal amount, final Model model,
			final HttpServletRequest request, final HttpServletResponse response)
	{
		PaymentData payment = new PaymentData();
		payment.setAmount(amount);
		payment.setOrderCode(orderCode);
		payment.setPaidTime(new Date());
		payment.setPaymentMethod(paymentMethod);
		payment.setPaymentType(paymentType);
		return orderFacade.createPayment(payment);
	}

	@RequestMapping(value = "/order/removepayment", method = RequestMethod.POST)
	@ResponseBody
	public Object removePayment(@RequestParam(value = "paymentPK", required = true) final String paymentPK, final Model model,
			final HttpServletRequest request, final HttpServletResponse response)
	{
		return orderFacade.removePayment(paymentPK);
	}

	@RequestMapping(value = "/order/payments/" + ORDER_CODE_PATH_VARIABLE_PATTERN, method = RequestMethod.GET)
	@ResponseBody
	public Object getPayments(@PathVariable("orderCode") String orderCode, final Model model, final HttpServletRequest request,
			final HttpServletResponse response)
	{
		OrderData orderData = orderFacade.getOrderForOptions(orderCode, Arrays.asList(OrderOption.PAYMENTS));
		List<PaymentData> paymentDatas = orderData.getPayments();
		DTResultsV data = new DTResultsV();
		data.setRecordsFiltered(paymentDatas.size());
		data.setRecordsTotal(paymentDatas.size());
		List<String[]> listDatas = new ArrayList<String[]>();
		for (int i = 0; i < paymentDatas.size(); i++)
		{
			PaymentData paymentData = paymentDatas.get(i);

			String[] row = new String[5];
			row[0] = paymentData.getPaymentTypeText();
			row[1] = paymentData.getPaymentMethodText();
			row[2] = paymentData.getAmount().toString();
			row[3] = DateFormatUtils.format(paymentData.getPaidTime(), "yyyy-MM-dd HH:mm:ss");
			row[4] = paymentData.getPk();

			listDatas.add(row);
		}
		;

		data.setData(listDatas);
		return data;
	}

	@RequestMapping(value = "/order/save")
	public String createOrder(@RequestParam(value = "orderCode", required = false) final String orderCode,
			@RequestParam(value = "orderPK", required = true) final String orderPK,
			@RequestParam(value = "contactinfo", required = false) final String contactinfo,
			@RequestParam(value = "cellphone") final String cellphone,
			@RequestParam(value = "storeCode", required = true) final String storeCode,
			@RequestParam(value = "receiveable", required = true) final String receiveable,
			@RequestParam(value = "tryDate") @DateTimeFormat(pattern = "yyyy-MM-dd") final Date tryDate,
			@RequestParam(value = "photoDate") @DateTimeFormat(pattern = "yyyy-MM-dd") final Date photoDate,
			@RequestParam(value = "deliveryDate") @DateTimeFormat(pattern = "yyyy-MM-dd") final Date deliveryDate,
			@RequestParam(value = "weddingDate",required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") final Date weddingDate,
			@RequestParam(value = "customerName", required = false) final String customerName,
			@RequestParam(value = "comment", required = false) final String comment,
			@RequestParam(value = "coSalesperson", required = false) final String coSalesperson, final Model model)
	{
		OrderData order = new OrderData();
		order.setPk(orderPK);
		order.setOrderCode(orderCode);
		order.setContactinfo(contactinfo);
		//find customer by cellphone
		order.setCellphone(cellphone);
		order.setComment(comment);
		order.setPhotoDate(photoDate);
		order.setDeliveryDate(deliveryDate);
		order.setCoSalesperson(coSalesperson);
		order.setTryDate(tryDate);
		order.setOrderDate(new Date());
		order.setWeddingDate(weddingDate);
		order.setCustomerName(customerName);
      order.setReceiveable(receiveable);
      
		StoreData store = new StoreData();
		store.setCode(storeCode);
		order.setStore(store);

		if (StringUtils.isBlank(orderPK))
			orderFacade.createOrder(order);
		else
			//TODO:需要判断订单状态为新建(需要考虑是否允许admin修改)
			orderFacade.updateOrder(order);

		return REDIRECT_PREFIX + "/order/modifyorderpage/" + orderCode;
	}
}
