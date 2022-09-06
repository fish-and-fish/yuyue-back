package com.mhh.hzpdd.pdd;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.pdd.pop.sdk.message.MessageHandler;
import com.pdd.pop.sdk.message.WsClient;
import com.pdd.pop.sdk.message.model.Message;

@Component
public class PddMesageListener {

    @Resource
    private PddConfig pddConfig;

    private WsClient wsClient;

    @PostConstruct
    public void start() {
        if (wsClient == null) {
            listener();
        }
//        if (!applicationProperties.isSandbox()) {
//            wsClient.connect();
//        }
        wsClient.connect();
    }

    @PreDestroy
    public void destory() {
        if (wsClient != null && wsClient.isOnline()) {
            wsClient.close();
        }
    }

    public void listener() {
        wsClient = new WsClient(pddConfig.getClientId(), pddConfig.getSecret(), new MessageHandler() {
            @Override
            public void onMessage(Message message) throws Exception {
                System.out.println(message.getContent());
            }
        });
    }
}
