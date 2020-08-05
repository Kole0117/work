package com.access;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.access.dao")
public class SpringbootMybatiesDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatiesDemoApplication.class, args);
    }

}
