package com.amrni.sport.shop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@EnableJpaAuditing
@EnableAsync
public class ShopApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ShopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
