package com.amrni.sport.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SnowFlakeConfig {

    @Bean
    public SnowFlakeUtils snowFlakeUtils(){
        return new SnowFlakeUtils(1, 9);
    }
}
