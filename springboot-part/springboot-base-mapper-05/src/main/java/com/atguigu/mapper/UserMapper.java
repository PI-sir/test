package com.atguigu.mapper;

import com.atguigu.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> queryAll();

    int delete(int i);
}
