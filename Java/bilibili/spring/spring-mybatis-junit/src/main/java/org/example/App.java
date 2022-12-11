package org.example;

import org.example.config.SpringConfig;
import org.example.domain.User;
import org.example.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;

public class App {
    public static void main( String[] args ) {
        // 创建Spring容器的上下文，并传入我们的配置类
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        // 获取容器中的UsrServiceImpl
        UserService service = context.getBean(UserService.class);
        // 查找所有用户
        List<User> users = service.findAll();
        // 打印所有用户
        System.out.println(users);
        // 关闭钩子
        context.registerShutdownHook();
        /*
        * 关闭
        * context.close();
        * */
    }
}
