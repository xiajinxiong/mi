package com.sure.mi.service;

import com.sure.mi.mapper.OrderMapper;
import com.sure.mi.mapper.UserMapper;
import com.sure.mi.mapper.VersionMapper;
import com.sure.mi.model.Order;
import com.sure.mi.model.OrderInfo;
import com.sure.mi.model.Transaction;
import com.sure.mi.util.DBUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;

public class OrderServiceImpl implements OrderService{


    @Override
    public boolean placeOrder(String username, OrderInfo orderInfo, Date createdAt) {
        try {
            String name = orderInfo.getName();
            String version = orderInfo.getVersion();
            String color = orderInfo.getColor();
            int number = orderInfo.getNumber();
            SqlSession sqlSession = DBUtil.getSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            long userId = userMapper.selectIdByName(username);
            System.out.println("userId get");
            VersionMapper versionMapper = sqlSession.getMapper(VersionMapper.class);
            long versionId = versionMapper.selectIdByNameAndVersionAndColor(name, version, color);
            System.out.println("versionId get");
            Order order = new Order(versionId, userId, number, 0, createdAt);
            OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
            orderMapper.insertOrder(order);
            sqlSession.commit();
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    @Override
    public Transaction displayOrder(String username) {
        return null;
    }
}
