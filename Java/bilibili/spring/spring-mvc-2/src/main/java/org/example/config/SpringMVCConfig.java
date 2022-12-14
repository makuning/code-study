package org.example.config;

import org.example.controller.interceptor.ProjectInterceptor;
import org.example.controller.interceptor.ProjectInterceptor2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author makun
 * @project spring
 * @description springmvc配置类
 * @date 2022/12/11 18:55:43
 * version 1.0
 */
@Configuration
@ComponentScan({"org.example.controller","org.example.config"})
@EnableWebMvc
public class SpringMVCConfig implements WebMvcConfigurer {
    // 注入beans中的拦截器
    @Autowired
    private ProjectInterceptor projectInterceptor;
    @Autowired
    private ProjectInterceptor2 projectInterceptor2;

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(projectInterceptor).addPathPatterns("/user","/user/*");
        registry.addInterceptor(projectInterceptor2).addPathPatterns("/user","/user/*");
    }

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
    }
}
