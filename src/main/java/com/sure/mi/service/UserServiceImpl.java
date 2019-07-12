package com.sure.mi.service;

import com.sure.mi.mapper.UserMapper;
import com.sure.mi.model.User;
import com.sure.mi.util.DBUtil;
import org.apache.ibatis.session.SqlSession;

public class UserServiceImpl implements UserService {
    @Override
    public User displayUserInfo(String username) {
        try {
            SqlSession sqlSession = DBUtil.getSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.selectUserByName(username);
        }
        catch (Exception e) {
            return null;
        }
    }

    @Override
    public void updateUser(User user) {
        try {
            SqlSession sqlSession = DBUtil.getSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.updateUser(user);
            sqlSession.commit();
        }
        catch (Exception e) {
            return;
        }
    }
}
