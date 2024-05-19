package com.atguigu.controller;


import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService service;

    @RequestMapping
    public void delete(){
        service.delete();
    }

    @RequestMapping("123")
    public List<User> findall(){
        List<User> users = userMapper.queryAll();
        return users;
    }
}
