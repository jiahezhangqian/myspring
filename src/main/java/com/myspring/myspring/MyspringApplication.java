package com.myspring.myspring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.myspring.myspring.mapper")
@SpringBootApplication
public class MyspringApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyspringApplication.class, args);
    }

}
