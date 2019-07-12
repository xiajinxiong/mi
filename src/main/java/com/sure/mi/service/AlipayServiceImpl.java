package com.sure.mi.service;

import com.alipay.api.AlipayApiException;
import com.sure.mi.mapper.UserMapper;
import com.sure.mi.model.OrderInfo;
import com.sure.mi.model.User;
import com.sure.mi.util.AlipayUtil;
import com.sure.mi.util.DBUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class AlipayServiceImpl implements AlipayService{
    @Override
    public void fastPay(String username, Date date, OrderInfo[] orderInfos, HttpServletResponse httpServletResponse) {
        SqlSession sqlSession = DBUtil.getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        long userId = userMapper.selectIdByName(username);
        String out_trade_no = String.valueOf(date.getTime()) + userId;
        System.out.println("userid=" + userId);
        double price = 0;
        StringBuilder subject = new StringBuilder();
        StringBuilder body = new StringBuilder();
        for (OrderInfo order : orderInfos) {
            price += order.getNumber() * order.getPrice();
            subject.append(order.getName()).append(" ");
            body.append(order.getVersion()).append(" ").append(order.getColor()).append(" ")
                    .append(order.getPrice()).append(" ");
        }
        try {
            AlipayUtil.pay(httpServletResponse, out_trade_no, price, subject.toString(), body.toString());
        }  catch (IOException | AlipayApiException e) {
            e.printStackTrace();
        }

    }
}
