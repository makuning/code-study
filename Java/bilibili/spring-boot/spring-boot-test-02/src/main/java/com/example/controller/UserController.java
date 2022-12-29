package com.example.controller;

import com.example.domain.Student;
import com.example.domain.User;
import com.example.domain.param.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;

/**
 * @author makun
 * @project spring-boot
 * @description
 * @date 2022/12/29 13:27:59
 * version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Value("${student.hobbies[0]}")
    private String hobbit;
    @Autowired
    private Student student;
    @Autowired
    private Environment environment;

    @GetMapping("/value/student/hobbit")
    public JsonData getYamlStudentHobbitByValue() {
        return new JsonData(0, hobbit, "处理成功！");
    }

    @GetMapping("/{id}")
    public JsonData getUserById(@PathVariable("id") int id) {
        System.out.println("id ----> " + id);
        return new JsonData(0,new User(1,"马某人","男",21,"19960798888",new Date(993312000000L),9999999.9999D),"处理成功！");
    }

    @GetMapping("/environment/student/name")
    public JsonData getStudentNameByEnvironment() {
        return new JsonData(0, environment.getProperty("student.name"), "处理成功！");
    }

    @GetMapping("/yaml/student")
    public JsonData getYamlStudentByDomain() {
        return new JsonData(0, student, "处理成功！");
    }
}
