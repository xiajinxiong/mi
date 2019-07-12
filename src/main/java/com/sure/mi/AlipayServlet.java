package com.sure.mi;

import com.google.gson.Gson;
import com.sure.mi.model.OrderInfo;
import com.sure.mi.service.AlipayService;
import com.sure.mi.service.AlipayServiceImpl;
import com.sure.mi.service.OrderService;
import com.sure.mi.service.OrderServiceImpl;
import com.sure.mi.util.UserNameUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "AlipayServlet", urlPatterns = "/alipay")
public class AlipayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gson gson = new Gson();
        OrderInfo[] list = gson.fromJson(request.getParameter("test"), OrderInfo[].class);
        System.out.println("order:");
        for (OrderInfo order : list) {
            System.out.println(order);
        }
        String username = UserNameUtil.getUsername(request.getCookies());
        if (username == null) {
            response.getWriter().close();
        }
        Date date = new Date();
        OrderService orderService = new OrderServiceImpl();
        System.out.println("line 34");
        for (OrderInfo orderInfo : list) {
            orderService.placeOrder(username, orderInfo, date);
        }
        AlipayService alipayService = new AlipayServiceImpl();
        alipayService.fastPay(username, date, list, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
