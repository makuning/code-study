package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author makun
 * @project spring
 * @description springmvc配置类
 * @date 2022/12/11 18:55:43
 * version 1.0
 */
@Configuration
@ComponentScan({"org.example.controller"})
@EnableWebMvc
public class SpringMVCConfig {

}
