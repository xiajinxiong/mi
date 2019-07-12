package com.sure.mi;

import com.sure.mi.mapper.OrderMapper;
import com.sure.mi.mapper.VersionMapper;
import com.sure.mi.model.Order;
import com.sure.mi.service.CartService;
import com.sure.mi.service.CartServiceImpl;
import com.sure.mi.util.DBUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class Test {

    @org.junit.Test
    public void test() {
        CartService cartService = new CartServiceImpl();
        String username="xiajx";
        String name="小米6";
        String version="全网通版 6GB+128GB";
        String color="亮黑色";
        cartService.dropItem(username, name, version, color);
    }

    @org.junit.Test
    public void test2() {
        SqlSession sqlSession = DBUtil.getSession();
        VersionMapper versionMapper = sqlSession.getMapper(VersionMapper.class);
        long id = versionMapper.selectIdByVersionAndColor("全网通版 6GB+128GB", "亮黑色", 1);
        System.err.println(id);
    }

    @org.junit.Test
    public void test3 () throws UnsupportedEncodingException {
        System.out.println(URLDecoder.decode("http://localhost:8081/mi_war_exploded/cart?buy=1&name=%E5%B0%8F%E7%B1%B36&version=%E5%85%A8%E7%BD%91%E9%80%9A%E7%89%88%206GB%2B128GB&color=%E4%BA%AE%E9%BB%91%E8%89%B2",
                StandardCharsets.UTF_8.name()));
    }

    @org.junit.Test
    public void test4() {
        Date date = new Date(1562846639160L);
        System.out.println(date);
    }

    @org.junit.Test
    public void test5() {
        SqlSession sqlSession = DBUtil.getSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        Order order = new Order(1, 2, 3, 4, new Date());
        orderMapper.insertOrder(order);
        sqlSession.commit();
    }
}
