package top.marken.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.marken.dao.UserDao;
import top.marken.domain.User;
import top.marken.service.MyService;
import java.util.List;

/**
 * @author makun
 * @project spring-test
 * @description
 * @date 2022/12/08 16:06:30
 * version 1.0
 */
@Service
public class MyServiceImpl implements MyService {
    @Autowired
    private UserDao userDao;

    public User findById(int id) {
        return userDao.findById(id);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }
}
