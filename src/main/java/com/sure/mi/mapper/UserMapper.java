package com.sure.mi.mapper;

import com.sure.mi.model.LogInInfo;
import com.sure.mi.model.LogUpInfo;
import com.sure.mi.model.User;

public interface UserMapper {

    void insertUser(LogUpInfo logUpInfo);
    String selectUser(LogInInfo logInInfo);
    String checkUsername(LogUpInfo logUpInfo);
    String checkPhone(LogUpInfo logUpInfo);
    User selectUserByName(String username);
    void updateUser(User user);
    Long selectIdByName(String username);
}
