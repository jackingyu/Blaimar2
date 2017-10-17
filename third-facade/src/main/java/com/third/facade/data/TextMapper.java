package com.third.facade.data;

import java.util.HashMap;

import com.third.core.constants.CoreConstants;


public class TextMapper {
	public static HashMap<String, String> PaymentType = new HashMap<String, String>();
	public static HashMap<String, String> PaymentMethod = new HashMap<String, String>();
	public static HashMap<String, String> ItemCategory = new HashMap<String, String>();
	public static HashMap<String, String> SizeAttributeGroup = new HashMap<String, String>();
	public static HashMap<String, String> ReservationChannel = new HashMap<String, String>();
	public static HashMap<String, String> OrderStatus = new HashMap<String, String>();
	public static HashMap<String, String> ItemCategory2Category = new HashMap<String, String>();

	static
	{
		PaymentType.put(CoreConstants.PaymentType.DownPayment, "订金");
		PaymentType.put(CoreConstants.PaymentType.NormalPayment, "付款");
	}

	static
	{
		PaymentMethod.put(CoreConstants.PaymentMethod.CreditCard, "信用卡");
		PaymentMethod.put(CoreConstants.PaymentMethod.Cash, "现金");
		PaymentMethod.put(CoreConstants.PaymentMethod.O2OAliPay, "网络支付");
	}

	static
	{
		ItemCategory.put(CoreConstants.ItemCategory.Suit, "西服量身单");
		ItemCategory.put(CoreConstants.ItemCategory.Trousers, "西裤量身单");
		ItemCategory.put(CoreConstants.ItemCategory.Shirt, "衬衫量身单");
		ItemCategory.put(CoreConstants.ItemCategory.Vest, "背心量身单");
		//ItemCategory.put(CoreConstants.ItemCategory.Norm, "普通销售项");
	}

	static
	{
		ItemCategory2Category.put(CoreConstants.ItemCategory.Suit,
				CoreConstants.Category.Suit);
		ItemCategory2Category.put(CoreConstants.ItemCategory.Trousers,
				CoreConstants.Category.Suit);
		ItemCategory2Category.put(CoreConstants.ItemCategory.Shirt,
				CoreConstants.Category.Shirt);
		ItemCategory2Category.put(CoreConstants.ItemCategory.Vest,
				CoreConstants.Category.Suit);
//		ItemCategory2Category.put(CoreConstants.ItemCategory.Norm,
//				CoreConstants.Category.Norm);
	}

	static
	{
		SizeAttributeGroup.put("10", "裁");
		SizeAttributeGroup.put("20", "量");
		SizeAttributeGroup.put("30", "试");
	}

	static
	{
		ReservationChannel.put(CoreConstants.ReservationChannel.Weixin, "微信");
		ReservationChannel.put(CoreConstants.ReservationChannel.Web, "网站");
	}

	static
	{
		OrderStatus.put(CoreConstants.OrderStatus.NEW.toString(), "新建");
		OrderStatus.put(CoreConstants.OrderStatus.FACTORY_APPROVE.toString(),
				"工厂已排产");
		OrderStatus.put(CoreConstants.OrderStatus.FINICIAL_APPROVE.toString(),
				"财务已确认");
		OrderStatus.put(CoreConstants.OrderStatus.STORE_APPROVE.toString(),
				"门店已确认");
		OrderStatus.put(CoreConstants.OrderStatus.FACTORY_DELIVERED.toString(),
				"工厂已发货");
		OrderStatus.put(CoreConstants.OrderStatus.STORE_RECEIPT.toString(),
				"门店已收货");
		OrderStatus.put(CoreConstants.OrderStatus.STORE_DELIVERED.toString(),
				"顾客已取件");
	}

}
