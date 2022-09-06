package com.mhh.hzpdd.message;

import lombok.Data;

@Data
public class SchudledMessage {

    /**
     * 消息主题
     */
    private String topic;


    private String platform;

    /**
     * 消息ID
     */
    private String id = "";

    private boolean isQueue = true;

    /**
     * 消息内容
     */
    private String message;

    /**
     * 延迟多少收到消息
     */
    private long delay = 0;

    private Integer type;
}
