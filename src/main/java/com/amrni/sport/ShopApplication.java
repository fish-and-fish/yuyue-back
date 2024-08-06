package com.amrni.sport;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@EnableJpaAuditing
@EnableAsync
@EnableScheduling
public class ShopApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ShopApplication.class, args);
    }


    @Override
    public void run(String... args) {
        String a = "0806111";
        System.out.println("version:" + a);
        System.out.println("version:" + a);
        System.out.println("version:" + a);
        System.out.println("version:" + a);
    }
}
