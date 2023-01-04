package com.example.service;

import com.example.main.User;
import java.util.List;

/**
 * @author makun
 * @project spring-boot
 * @description 用户服务接口
 * @date 2023/01/04 18:51:37
 * version 1.0
 */

public interface UserService {
    List<User> getAllUsers();
}
