package com.third.facade.utils;

import java.util.ArrayList;
import java.util.List;

import com.third.core.constants.CoreConstants;
import com.third.facade.data.ComboboxData;
import com.third.facade.data.TextMapper;

public class TextMapperUtils {
    public static List<ComboboxData> getPaymentTypes()
    {
        List<ComboboxData> results = new ArrayList<ComboboxData>();
        TextMapper.PaymentType.entrySet().forEach(s -> {
            ComboboxData combobox = new ComboboxData();
            combobox.setCode(s.getKey());
            combobox.setText(s.getValue());
            results.add(combobox);
        });

        return results;
    }

    public static List<ComboboxData> getPaymentMethods()
    {
        List<ComboboxData> results = new ArrayList<ComboboxData>();
        TextMapper.PaymentMethod.entrySet().forEach(s -> {
            ComboboxData combobox = new ComboboxData();
            combobox.setCode(s.getKey());
            combobox.setText(s.getValue());
            results.add(combobox);
        });

        return results;
    }

    public static List<ComboboxData> getItemCategories()
    {
        List<ComboboxData> results = new ArrayList<ComboboxData>();
        TextMapper.ItemCategory.entrySet().forEach(s -> {
            ComboboxData combobox = new ComboboxData();
            combobox.setCode(s.getKey());
            combobox.setText(s.getValue());
            results.add(combobox);
        });

        return results;
    }

    public static List<ComboboxData> getOrderStatus()
    {
        List<ComboboxData> results = new ArrayList<ComboboxData>();
        TextMapper.OrderStatus.entrySet().forEach(s -> {
            ComboboxData combobox = new ComboboxData();
            combobox.setCode(s.getKey());
            combobox.setText(s.getValue());

            // this means the status is all
            if (Integer.valueOf(
                    s.getKey()) == CoreConstants.OrderStatus.ALL_STATUS)
                combobox.setSelected(true);

            results.add(combobox);
        });

        return results;
    }

    public static List<ComboboxData> getOrderStatusWithoutAll()
    {
        List<ComboboxData> results = new ArrayList<ComboboxData>();
        TextMapper.OrderStatus.entrySet().forEach(s -> {
            if (Integer.valueOf(
                    s.getKey()) != CoreConstants.OrderStatus.ALL_STATUS)
            {
                ComboboxData combobox = new ComboboxData();
                combobox.setCode(s.getKey());
                combobox.setText(s.getValue());

                results.add(combobox);
            }
        });

        return results;
    }

    public static String getOrderStatusText(final Integer status)
    {
        return TextMapper.OrderStatus.get(status.toString());
    }

    public static String getOrderStatusText4Cust(final Integer status)
    {
        return TextMapper.OrderStatus4Cust.get(status.toString());
    }

    public static String getItemCategoryText(final String itemCategory)
    {
        return TextMapper.ItemCategory.get(itemCategory);
    }

    public static String getPaymentMethodText(final String paymentMethod)
    {
        return TextMapper.PaymentMethod.get(paymentMethod);
    }
}
