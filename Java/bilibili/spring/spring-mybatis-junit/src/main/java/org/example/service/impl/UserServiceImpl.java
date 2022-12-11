package org.example.service.impl;

import org.example.dao.UserDao;
import org.example.domain.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

/**
 * @author makun
 * @project spring
 * @description User服务实现类
 * @date 2022/12/08 21:13:35
 * version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    // 自动装配
    @Autowired
    private UserDao userDao;

    public void save(User account) {
        userDao.save(account);
    }

    public void deleteById(Integer id) {
        userDao.deleteById(id);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User findById(Integer id) {
        return userDao.findById(id);
    }

    /**
     * 构造之后执行
     */
    @PostConstruct
    public void before() {
        System.out.println("UserServiceImpl被创建了");
    }

    /**
     * 被销毁之前执行
     */
    @PreDestroy
    public void after() {
        System.out.println("UserServiceImpl要被销毁了");
    }
}
