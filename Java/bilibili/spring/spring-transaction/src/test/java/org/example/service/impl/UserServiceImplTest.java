package org.example.service.impl;

import org.example.config.SpringConfig;
import org.example.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author makun
 * @project spring
 * @description
 * @date 2022/12/11 14:42:18
 * version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Test
    public void testTransfer() {
        userService.transfer(1,2,50D);
    }
}