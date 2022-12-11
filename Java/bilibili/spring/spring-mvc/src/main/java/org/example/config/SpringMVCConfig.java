package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author makun
 * @project spring
 * @description mvc配置类
 * @date 2022/12/11 16:35:55
 * version 1.0
 */
// 让此类以配置类的角色交给Spring容器管理
@Configuration
// 配置控制器扫描
@ComponentScan({"org.example.controller"})
public class SpringMVCConfig {
}
