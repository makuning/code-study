package org.example.controller;

import org.example.domain.JsonResult;
import org.example.domain.User;
import org.example.exception.BusinessException;
import org.example.exception.SystemException;
import org.springframework.web.bind.annotation.*;

/**
 * @author makun
 * @project spring
 * @description 用户控制器
 * @date 2022/12/11 16:32:22
 * version 1.0
 */
// 表示所有的方法都将返回结果作为响应体，并让Spring容器进行管理
@RestController
// 将url公共部分提取出来，即url前缀
@RequestMapping("/user")
public class UserController {
    @GetMapping("/test/exception/{id}")
    public JsonResult testException(@PathVariable Integer id) {
        if (id == 1) {
            throw new BusinessException();
        } else {
            throw new SystemException();
        }
    }

    @PostMapping
    public JsonResult save(@RequestBody User user) {
        System.out.println("save方法控制器处理函数执行");
        return new JsonResult(200, "保存成功！", user);
    }

    @PutMapping
    public JsonResult update(@RequestBody User user) {
        return new JsonResult(200, "更新成功！", user);
    }

    @DeleteMapping("/{id}")
    public JsonResult deleteById(@PathVariable Integer id) {
        return new JsonResult(200, id + "删除成功！", null);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public JsonResult findById(@PathVariable Integer id) {
        return new JsonResult(200, id + "查找成功！", new User());
    }
}
