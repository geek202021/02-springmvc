package com.jun.service.impl;

import com.jun.bean.User;
import com.jun.dao.UserMapper;
import com.jun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HuangJun7
 * @date 2021-11-12 20:24
 */
@Service
public class UserServiceImpl implements UserService {
    /**
     * dao是引用类型，UserMapper类型的对象是在spring的配置文件中创建的
     * 引用类型的自动注入：@AutoWired
     */
    @Autowired
    private UserMapper dao;
    @Override
    public int addUser(User user) {
        int rows = dao.insertUser(user);
        return rows;
    }

    @Override
    public List<User> queryUsers() {
        List<User> users = dao.selectUsers();
        return users;
    }
}
