package com.sure.mi.service;

import com.sure.mi.mapper.UserMapper;
import com.sure.mi.model.LogInInfo;
import com.sure.mi.util.DBUtil;
import org.apache.ibatis.session.SqlSession;

public interface LogInService {

    boolean logIn(LogInInfo logInInfo);
}
