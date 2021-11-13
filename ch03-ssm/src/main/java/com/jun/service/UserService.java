package com.jun.service;

import com.jun.bean.User;

import java.util.List;

/**
 * @author HuangJun7
 * @date 2021-11-12 20:19
 */
public interface UserService {
    int addUser(User user);

    List<User> queryUsers();
}
