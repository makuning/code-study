package top.marken.service;

import top.marken.domain.User;

import java.util.List;

/**
 * @author makun
 * @project spring-test
 * @description
 * @date 2022/12/08 16:06:10
 * version 1.0
 */
public interface MyService {
    User findById(int id);
    List<User> findAll();
}
