package com.jun.dao;

import com.jun.bean.User;

import java.util.List;

/**
 * @author HuangJun7
 * @date 2021-11-12 20:10
 */
public interface UserMapper {
    int insertUser(User user);

    List<User> selectUsers();
}
