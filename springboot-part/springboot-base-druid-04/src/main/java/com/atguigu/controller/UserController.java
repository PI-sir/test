package com.atguigu.controller;

import com.atguigu.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("hello")
    @ResponseBody
    public String hello(){
        return "as";
    }

    @GetMapping("/getUser")
    @ResponseBody
    public List<User> getUser(){
        String sql = "select * from user ; ";
        List<User> user = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));

        return user;
    }

}