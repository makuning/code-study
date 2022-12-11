package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author makun
 * @project spring
 * @description 用户控制器
 * @date 2022/12/11 16:32:22
 * version 1.0
 */
// 让Spring容器进行管理
@Controller
public class UserController {
    // 请求的url地址
    @RequestMapping("/user/save")
    // 让方法返回的结果就作为响应的响应体，不做处理
    @ResponseBody
    public String save() {
        System.out.println("/user/save");
        return "{\"username\":\"John\"}";
    }
}
