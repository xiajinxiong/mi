package com.sure.mi.service;

import com.sure.mi.model.User;

public interface UserService {

    User displayUserInfo(String username);
    void updateUser(User user);
}
