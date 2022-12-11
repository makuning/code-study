package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author makun
 * @project spring
 * @description springmvc配置类
 * @date 2022/12/11 18:55:43
 * version 1.0
 */
@Configuration
@ComponentScan({"org.example.controller"})
public class SpringMVCConfig {

}
