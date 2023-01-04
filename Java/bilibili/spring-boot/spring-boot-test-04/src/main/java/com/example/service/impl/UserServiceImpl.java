package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.main.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author makun
 * @project spring-boot
 * @description 用户服务类接口实现
 * @date 2023/01/04 18:53:40
 * version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAllUsers() {
        return userDao.queryAll();
    }
}
