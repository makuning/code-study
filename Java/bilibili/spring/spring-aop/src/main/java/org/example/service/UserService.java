package org.example.service;

import org.example.domain.User;
import java.util.List;

/**
 * @author makun
 * @project spring
 * @description User服务类接口
 * @date 2022/12/08 21:11:37
 * version 1.0
 */
public interface UserService {
    void save(User account);

    void deleteById(Integer id);

    void update(User user);

    List<User> findAll();

    User findById(Integer id);

    void testException();
}
