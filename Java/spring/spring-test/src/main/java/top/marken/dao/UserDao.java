package top.marken.dao;

import org.apache.ibatis.annotations.Select;
import top.marken.domain.User;
import java.util.List;

/**
 * @author makun
 * @project spring-test
 * @description 用户
 * @date 2022/12/08 16:18:16
 * version 1.0
 */
public interface UserDao {
    @Select("select * from t_user")
    List<User> findAll();

    @Select("select * from t_user where id = #{id} ")
    User findById(Integer id);
}
