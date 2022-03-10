package com.example.orderconsumertest.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderUtil {

    public static String getOrderId(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        String orderId=sdf.format(new Date());
        return orderId + RandomStringUtils.randomNumeric(6);
    }
}
