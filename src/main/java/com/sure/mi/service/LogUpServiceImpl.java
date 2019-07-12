package com.sure.mi.service;

import com.sure.mi.mapper.UserMapper;
import com.sure.mi.model.LogUpInfo;
import com.sure.mi.util.DBUtil;
import org.apache.ibatis.session.SqlSession;

public class LogUpServiceImpl implements LogUpService{
    @Override
    public int logUp(LogUpInfo logUpInfo) {
        try {
            SqlSession sqlSession = DBUtil.getSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            String username = userMapper.checkUsername(logUpInfo);
            String phone = userMapper.checkPhone(logUpInfo);
            int re;
            if (username != null && phone != null) {
                re = -1;
            }
            else {
                if (username != null) {
                    re = -2;
                }
                else {
                    if (phone != null) {
                        re = -3;
                    }
                    else re = 0;
                }
            }
            if (re == 0) {
                userMapper.insertUser(logUpInfo);
                sqlSession.commit();
            }
            System.out.print("re==" + re);
            return re;
        }
        catch (Exception e) {
            return -4;
        }
    }
}
