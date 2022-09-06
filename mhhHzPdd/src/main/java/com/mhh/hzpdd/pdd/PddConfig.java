package com.mhh.hzpdd.pdd;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@ConfigurationProperties(prefix = "application.pdd")
@Component
@Data
public class PddConfig {

    private String clientId = "96bbb6d41e6d4d0cac6573cd18669f9a";

    private String secret = "41af2fc312b80cb7209027d8581b4e6f7f9347b6";

    private String AUTHAPI = "https://fuwu.pinduoduo.com/service-market/auth?response_type=code&client_id=%s&redirect_uri=%s&state=%s";

}
