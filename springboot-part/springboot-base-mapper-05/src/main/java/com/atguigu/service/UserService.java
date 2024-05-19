package com.atguigu.service;

import com.atguigu.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@org.springframework.stereotype.Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Transactional
    public void delete(){

       int rows= userMapper.delete(1);
        System.out.println(rows);

    }
}
