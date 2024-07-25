package com.amrni.sport.shop.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties("app.datasource")
public class DataSourceProperties {
    private Map<String, DataSourceConfig> dataSources;

    public Map<String, DataSourceConfig> getDataSources() {
        return dataSources;
    }

    public void setDataSources(Map<String, DataSourceConfig> dataSources) {
        this.dataSources = dataSources;
    }

    @Data
    public static class DataSourceConfig {
        private String url;
        private String username;
        private String password;

    }
}

