package com.sure.mi.service;

import com.sure.mi.mapper.ProductMapper;
import com.sure.mi.model.Product;
import com.sure.mi.util.DBUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class InfoServiceImpl implements InfoService{
    @Override
    public Product searchInfo(String name) {
        try {
            SqlSession sqlSession = DBUtil.getSession();
            ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
            return productMapper.selectProductByName(name);
        }
        catch (Exception e) {
            return null;
        }
    }
}
