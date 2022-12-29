package com.example.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Repository;

import java.util.Arrays;

/**
 * @author makun
 * @project spring-boot
 * @description
 * @date 2022/12/29 13:42:08
 * version 1.0
 */
@ConfigurationProperties(prefix = "student")
@Repository
public class Student {
    private String school;
    private String clazz;
    private String name;
    private String phone;
    private Integer age;
    private String[] hobbies;

    public Student() {
    }

    public Student(String school, String clazz, String name, String phone, Integer age, String[] hobbies) {
        this.school = school;
        this.clazz = clazz;
        this.name = name;
        this.phone = phone;
        this.age = age;
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "Student{" +
                "school='" + school + '\'' +
                ", clazz='" + clazz + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", hobbies=" + Arrays.toString(hobbies) +
                '}';
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }
}
