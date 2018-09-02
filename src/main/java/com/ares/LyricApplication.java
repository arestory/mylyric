package com.ares;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class LyricApplication {

    public static void main(String[] args) {
        SpringApplication.run(LyricApplication.class, args);

        System.out.println("test ------------------");
    }
}
