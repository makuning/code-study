package org.example.config;

import org.example.controller.interceptor.ProjectInterceptor;
import org.example.controller.interceptor.ProjectInterceptor2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author makun
 * @project spring
 * @description springmvc支持
 * @date 2022/12/12 09:16:04
 * version 1.0
 */

//@Configuration
public class SpringMvcSupport extends WebMvcConfigurationSupport {
    // 注入beans中的拦截器
    @Autowired
    private ProjectInterceptor projectInterceptor;

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
    }

    // 拦截器
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(projectInterceptor).addPathPatterns("/user","/user/*");
    }
}
