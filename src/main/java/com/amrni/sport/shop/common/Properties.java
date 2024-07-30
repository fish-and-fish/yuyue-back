package com.amrni.sport.shop.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
public class Properties extends java.util.Properties {
    public static Properties properties;

    public static String appid;
    public static String secret;

    @Value("${common.app.appid}")
    public void setAppid(String appid){
        this.appid = appid;
    }

    @Value("${common.app.secret}")
    public void setSecret(String secret){
        this.secret = secret;
    }

    public Properties()  {
        properties = this;
    }
}
