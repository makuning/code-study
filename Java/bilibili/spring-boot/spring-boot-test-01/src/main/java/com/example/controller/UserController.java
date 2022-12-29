package com.example.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author makun
 * @project spring-boot
 * @description 用户控制类
 * @date 2022/12/19 17:34:48
 * version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/{id}")
    public String getUserById(@PathVariable int id) {
        System.out.println("id ---> " + id);
        return "hello Spring boot";
    }
}
