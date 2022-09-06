package com.mhh.hzpdd.pdd;

import javax.annotation.Resource;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.mhh.hzpdd.message.SchudledMessage;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PddEventsListener {


	@Resource
	private PddCore pddCore;


	//    @EventListener(condition = "#event.platform eq T(com.maihh.wanghong.utils.StaticDict).PLATFORM_PINDUODUO and #event.topic eq T(com.maihh.wanghong.utils.StaticDict).MQ_TOPIC_SCHEDULED_SYNC_KUAISHOU_PRODUCT")
//    public void syncProductEventListener(SchudledMessage event) throws Exception {
//        pddCore.syncProduct(JSONObject.parseObject(event.getMessage(), WhShopExt.class));
//    }
//
//    @EventListener(condition = "#event.platform eq T(com.maihh.wanghong.utils.StaticDict).PLATFORM_PINDUODUO and #event.topic eq T(com.maihh.wanghong.utils.StaticDict).MQ_TOPIC_SCHEDULED_SYNC_Pin")
//    public void syncOrderEventListener(SchudledMessage event) throws Exception {
//        pddCore.syncOrder(JSONObject.parseObject(event.getMessage(), WhShopExt.class));
//    }

	@EventListener(condition = "#event.platform eq T(com.mhh.hzpdd.message.StaticDict).PLATFORM_PINDUODUO and #event.topic eq T(com.mhh.hzpdd.message.StaticDict).MQ_TOPIC_SCHEDULED_SYNC_ORDER")
	public void syncOrderEventListener(SchudledMessage event) throws Exception {
//		WhShopExt whShopExt = JSONObject.parseObject(event.getMessage(), WhShopExt.class);
//		log.info("店铺【{}】开始同步订单", whShopExt.getCname());
//		pddCore.syncOrder(whShopExt);
//		log.info("店铺【{}】开始同步订单", whShopExt.getCname());
		System.out.println(event.getMessage());
	}
}
