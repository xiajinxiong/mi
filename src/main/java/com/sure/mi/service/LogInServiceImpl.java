package com.sure.mi.service;

import com.sure.mi.mapper.UserMapper;
import com.sure.mi.model.LogInInfo;
import com.sure.mi.model.User;
import com.sure.mi.util.DBUtil;
import org.apache.ibatis.session.SqlSession;

public class LogInServiceImpl implements LogInService{
    @Override
    public boolean logIn(LogInInfo logInInfo) {
        try {
            SqlSession sqlSession = DBUtil.getSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            String username = userMapper.selectUser(logInInfo);
            System.out.println("result=" + username);
            return username != null;
        }
        catch (Exception e) {
            return false;
        }
    }
}
