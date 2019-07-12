package com.sure.mi.service;

import com.sure.mi.mapper.CartMapper;
import com.sure.mi.mapper.ProductMapper;
import com.sure.mi.mapper.UserMapper;
import com.sure.mi.mapper.VersionMapper;
import com.sure.mi.model.CartItem;
import com.sure.mi.util.DBUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CartServiceImpl implements CartService{
    @Override
    public void addToCart(String username, String name, String version, String color) {
        try {
            SqlSession sqlSession = DBUtil.getSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
            VersionMapper versionMapper = sqlSession.getMapper(VersionMapper.class);
            CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
            long userId = userMapper.selectIdByName(username);
            System.out.println("user+" + userId);
            long productId = productMapper.selectIdByName(name);
            System.out.println("product_id+" + productId);
            long versionId = versionMapper.selectIdByVersionAndColor(version, color, productId);
            System.out.println("version_id+" + versionId);
            Integer n = cartMapper.selectNumber(userId, productId, versionId);
            if (n == null) {
                cartMapper.addToCart(userId, productId, versionId);
            }
            else {
                cartMapper.updateCart(userId, productId, versionId, n + 1);
            }
            sqlSession.commit();

        }
        catch (Exception e) {
            System.err.println(e);
        }
    }

    @Override
    public void dropItem(String username, String name, String version, String color) {
        try {
            SqlSession sqlSession = DBUtil.getSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
            VersionMapper versionMapper = sqlSession.getMapper(VersionMapper.class);
            CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
            long userId = userMapper.selectIdByName(username);
            long productId = productMapper.selectIdByName(name);
            long versionId = versionMapper.selectIdByVersionAndColor(version, color, productId);
            Integer n = cartMapper.selectNumber(userId, productId, versionId);
            if (n <= 1) {
                cartMapper.deleteCart(userId, productId, versionId);
            }
            else {
                cartMapper.updateCart(userId, productId, versionId, n - 1);
            }
            sqlSession.commit();
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }

    @Override
    public List<CartItem> displayItems(String username) {
        SqlSession sqlSession = DBUtil.getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Long userId = userMapper.selectIdByName(username);
        CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
        return cartMapper.selectCartByUserId(userId);
    }

    @Override
    public void dropCart(String username, String name, String version, String color) {
        SqlSession sqlSession = DBUtil.getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        VersionMapper versionMapper = sqlSession.getMapper(VersionMapper.class);
        CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
        long userId = userMapper.selectIdByName(username);
        long productId = productMapper.selectIdByName(name);
        long versionId = versionMapper.selectIdByVersionAndColor(version, color, productId);
        cartMapper.deleteCart(userId, productId, versionId);
        System.out.println("deleting after");
        sqlSession.commit();
    }
}
