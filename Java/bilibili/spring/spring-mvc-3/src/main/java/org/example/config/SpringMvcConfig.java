package org.example.config;

import org.example.controller.interceptor.ProjectInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
// 开启功能
@EnableWebMvc
// 载入支持配置
public class SpringMvcConfig implements WebMvcConfigurer {
    // 自动注入容器中我们之前写的拦截器
    @Autowired
    private ProjectInterceptor projectInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
        // 表示匹配/user路径与/user/下所有的路径
        // 被匹配的路径就会按照编写的拦截器进行拦截
        registry.addInterceptor(projectInterceptor).addPathPatterns("/user","/user/**");
    }

    // 增加资源处理器
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 表示将webapp目录下的pages目录下的所有文件都映射在/pages/**这个url地址中
        registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
    }
}
