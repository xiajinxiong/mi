package com.sure.mi.service;

import com.sure.mi.model.OrderInfo;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public interface AlipayService {

    void fastPay(String username, Date createdAt, OrderInfo[] orderInfos, HttpServletResponse httpServletResponse);
}
