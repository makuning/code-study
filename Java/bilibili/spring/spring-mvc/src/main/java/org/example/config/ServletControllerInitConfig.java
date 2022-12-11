package org.example.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

/**
 * @author makun
 * @project spring
 * @description servlet初始化配置
 * @date 2022/12/11 16:38:54
 * version 1.0
 */
public class ServletControllerInitConfig extends AbstractDispatcherServletInitializer {
    // 配置Webapp的容器
    protected WebApplicationContext createServletApplicationContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        // 配置容器的配置类
        context.register(SpringMVCConfig.class);
        return context;
    }

    // 配置哪些请求url交割springmvc处理
    protected String[] getServletMappings() {
        // 表示将所有的请求都交割SpringMVC处理
        return new String[]{"/"};
    }

    // 配置全局的容器
    protected WebApplicationContext createRootApplicationContext() {
        return null;
    }
}
