package top.marken.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @author makun
 * @project spring-test
 * @description Spring配置类
 * @date 2022/12/08 15:54:41
 * version 1.0
 */
@Configuration
@PropertySource({"classpath:jdbc.properties"})
@ComponentScan({"top.marken.service"})
@Import({MybatisConfig.class, JdbcConfig.class})
public class SpringConfig {

}
