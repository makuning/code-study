package org.example;

import org.example.config.SpringConfig;
import org.example.domain.User;
import org.example.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;

// 配置类启动器
@RunWith(SpringJUnit4ClassRunner.class)
// 设置Spring环境对应的配置类
@ContextConfiguration(classes = SpringConfig.class)
public class AppTest {
    @Autowired
    private UserService userService;

    @Test
    public void testFindById() {
        User user = userService.findById(1);
        System.out.println(user);
    }

    @Test
    public void testFindAll() {
        List<User> users = userService.findAll();
        System.out.println(users);
    }
}
