package org.example.controller;

import org.example.domain.Result;
import org.example.domain.User;
import org.example.exception.BusinessException;
import org.example.exception.SystemException;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;

/**
 * @author makun
 * @project spring
 * @description 用户页面控制器
 * @date 2022/12/11 18:54:47
 * version 1.0
 */
//@Controller
//@ResponseBody
@RestController
@RequestMapping("/user")
public class UserController {
    //@RequestMapping(value = "",method = RequestMethod.POST)
    @PostMapping
    public String userSave(@RequestBody User user) {
        System.out.println("/user");
        System.out.println(user);
        return "{\"url\",\"/user/save\"}";
    }

    // @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @GetMapping("/{id}")
    public String userGet(@PathVariable Integer id) {
        System.out.println("/user/" + id);
        return "{\"url\",\"/user/get\"}";
    }

    @GetMapping("/exception/test/{id}")
    public Result exceptionTest(@PathVariable Integer id) {
        try {
            if (id == 1) {
                int i = 1 / 0;
            } else {
                throw new FileNotFoundException();
            }
        } catch (ArithmeticException e) {
            throw new BusinessException(e.getMessage(), 500);
        } catch (FileNotFoundException e) {
            throw new SystemException(500 ,e.getMessage());
        }
        return new Result();
    }

    @PostMapping("/test")
    public Result test(String name) {
        System.out.println(name);
       return new Result(200,"成功",null);
    }
}
