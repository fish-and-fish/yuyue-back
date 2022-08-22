package com.mhh.hz;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan(basePackages = {"com.mhh.hz.dao"})
public class MhhHzApplication {

    public static void main(String[] args) {
        SpringApplication.run(MhhHzApplication.class, args);
    }

}
