package com.atguigu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.atguigu.mapper")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
        System.out.println("a");
        System.out.println("a");


    }
}