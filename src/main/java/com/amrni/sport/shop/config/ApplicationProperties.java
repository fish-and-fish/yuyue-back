package com.amrni.sport.shop.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@ConfigurationProperties(prefix = "application")
@Component
@Data
public class ApplicationProperties {
//	/**
//	 * 定时是否运行在此服务器上
//	 */
//	private boolean taskRunOnServer = false;
//
//	private boolean aliyunEndpoint_Internal = true;
//
//	private String ossHost = "https://oss.taoulike.com";
//
//	private boolean sandbox = true;

	private int maxPageSize = 200;

}
