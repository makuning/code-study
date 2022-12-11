package org.example.config;

import org.springframework.context.annotation.*;

/**
 * @author makun
 * @project spring
 * @description Spring配置类
 * @date 2022/12/08 20:07:29
 * version 1.0
 */
// 表示这是一个配置类
@Configuration
// 表示需要扫描哪里，将有对应注解的类创建对象并添加到容器中
@ComponentScan({"org.example.service","org.example.aop"})
// 读取配置文件
@PropertySource({"classpath:jdbc.properties"})
// 导入jdbc配置类，Mybatis配置类
@Import({JdbcConfig.class, MybatisConfig.class})
// 开启切面自动代理
@EnableAspectJAutoProxy
public class SpringConfig {
}
