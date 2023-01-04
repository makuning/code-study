package com.example.dao;

import com.example.main.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * @author makun
 * @project spring-boot
 * @description 用户持久层访问
 * @date 2023/01/04 18:55:06
 * version 1.0
 */

// 让Mybatis知道这是一个持久层访问的接口，并且交给SpringBoot管理
@Mapper
public interface UserDao {
    @Select("select * from t_user")
    List<User> queryAll();
}
