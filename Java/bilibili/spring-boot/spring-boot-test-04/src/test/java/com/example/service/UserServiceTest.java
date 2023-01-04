package com.example.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author makun
 * @project spring-boot
 * @description
 * @date 2023/01/04 19:00:17
 * version 1.0
 */
@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;
    @Test
    void getAllUsers() {
        System.out.println(userService.getAllUsers());
    }
}