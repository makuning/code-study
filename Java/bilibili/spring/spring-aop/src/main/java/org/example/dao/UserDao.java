package org.example.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.domain.User;
import java.util.List;

/**
 * @author makun
 * @project spring
 * @description
 * @date 2022/12/08 20:06:28
 * version 1.0
 */
public interface UserDao {

    @Insert("insert into t_user(name, gender, age, phone, birthday) values(#{name},#{gender},#{age},#{phone},#{birthday})")
    void save(User account);

    @Delete("delete from t_user where id = #{id} ")
    void deleteById(Integer id);

    @Update("update t_user set name = #{name} , gender = #{gender}, age = #{age}, phone = #{phone}, birthday = #{birthday} where id = #{id} ")
    void update(User user);

    @Select("select * from t_user")
    List<User> findAll();

    @Select("select * from t_user where id = #{id} ")
    User findById(Integer id);
}
