package org.example.controller.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.domain.JsonResult;
import org.example.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author makun
 * @project spring
 * @description 拦截器
 * @date 2022/12/12 16:05:02
 * version 1.0
 */

// 交给SpringMVC容器管理
@Component
public class ProjectInterceptor implements HandlerInterceptor {
    // 运行在控制器处理方法之前
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取请求头Content-Type的属性值
        String header = request.getHeader("Content-Type");
        System.out.println(header);

        // 获取控制器对应的那个处理方法，也就是controller中的那个方法
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        // 打印对应controller的类型
        System.out.println(handlerMethod.getBeanType());
        // 执行对应controller中对应的方法
        handlerMethod.getMethod().invoke(handlerMethod.getBean(), new User());

        if (request.getRequestURI().equals("/user")) {
            response.setHeader("Content-Type", "application/json");
            // 获取写入响应体数据的流
            PrintWriter writer = response.getWriter();
            // 写入经jackson对象处理后的JsonResult的json字符串
            writer.write(new ObjectMapper().writeValueAsString(new JsonResult(200, "please login first", null)));
            // 刷新输出流
            writer.flush();
            // 关闭输出流
            writer.close();
            // 不再往后执行
            return false;
        }

        // 放行
        return true;
    }

    // 运行在控制器处理方法之后
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    // 运行在控制器处理方法完成之后
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }
}
