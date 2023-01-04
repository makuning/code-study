package com.example;

import com.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootTest04ApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    void getAllUsers() {
        System.out.println(userService.getAllUsers());
    }

}
