package com.mhh.hzpdd.pdd;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import com.google.common.collect.Maps;
import com.mhh.hzpdd.entity.WhShopExt;
import com.mhh.hzpdd.message.StaticDict;
import com.pdd.pop.sdk.http.PopClient;
import com.pdd.pop.sdk.http.PopHttpClient;
import com.pdd.pop.sdk.http.api.pop.request.PddLogisticsAddressGetRequest;
import com.pdd.pop.sdk.http.api.pop.request.PddOrderNumberListIncrementGetRequest;
import com.pdd.pop.sdk.http.api.pop.response.PddLogisticsAddressGetResponse;
import com.pdd.pop.sdk.http.api.pop.response.PddOrderNumberListIncrementGetResponse;

@Component
public class PddCore {

    @Resource
    private PddConfig pddConfig;

    @Resource
    private ApplicationContext ctx;

    @Resource
    private StringRedisTemplate stringRedisTemplate;


    private static HashMap<String, String> areaCodeMap = Maps.newHashMap();

    private static Map<String, String> platformMap = Maps.newHashMap();

    @PostConstruct
    public void init(){
        PddOrderNumberListIncrementGetRequest request = new PddOrderNumberListIncrementGetRequest();
        request.setPageSize(100);
        request.setIsLuckyFlag(0);
        request.setOrderStatus(5);
        request.setRefundStatus(5);
        request.setUseHasNext(true);
        request.setPage(0);
        request.setStartUpdatedAt(new Date().getTime() - 1000 * 60 * 60 * 5);
        request.setEndUpdatedAt(new Date().getTime());
//        PddOrderNumberListIncrementGetResponse response = getCLient().syncInvoke(request, getAccessToken(StaticDict.PLATFORM_PINDUODUO, shop));

    }

    public void initAreaCode() {
        try {
            PddLogisticsAddressGetRequest request = new PddLogisticsAddressGetRequest();
            PddLogisticsAddressGetResponse response = getCLient().syncInvoke(request);
            if (response.getLogisticsAddressGetResponse() != null) {
                List<PddLogisticsAddressGetResponse.LogisticsAddressGetResponseLogisticsAddressListItem> logisticsAddressList = response.getLogisticsAddressGetResponse().getLogisticsAddressList();
                if (logisticsAddressList != null && logisticsAddressList.size() > 0) {
                    for (PddLogisticsAddressGetResponse.LogisticsAddressGetResponseLogisticsAddressListItem item : logisticsAddressList) {
                        areaCodeMap.put(item.getId().toString(), item.getNationalCode());
                    }
                }
            }
        } catch (Exception ex) {

        }
    }

    private PopClient getCLient() {
        return new PopHttpClient(pddConfig.getClientId(), pddConfig.getSecret());
    }

    public void syncOrder(WhShopExt shop) throws Exception {
        Date lastUpdate = Date.from(LocalDate.now().with(TemporalAdjusters.firstDayOfMonth()).minusMonths(1).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        if (shop.getLastUpdate() != null) {
            lastUpdate = shop.getLastUpdate();
        }
        Date endTime = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
        Long beginTs = lastUpdate.getTime() / 1000;
        long endTs = endTime.getTime() / 1000;
        Long tempEndTs = beginTs + 30 * 60;
        int page = 1;
        PddCore thatCore = ctx.getBean(PddCore.class);
        while (endTs - beginTs > 0) {
            tempEndTs = tempEndTs > endTs ? endTs : tempEndTs;
            boolean hasNext = thatCore.syncOrder(shop, beginTs, tempEndTs, page);
            if (hasNext) {
                page = page + 1;
            } else {
                beginTs = tempEndTs;
                tempEndTs = beginTs + 30 * 60;
                page = 1;
            }
        }
        System.out.println("搞定");
    }

    public boolean syncOrder(WhShopExt shop, Long beginTs, Long endTs, int page) throws Exception {
        PddOrderNumberListIncrementGetRequest request = new PddOrderNumberListIncrementGetRequest();
        request.setPageSize(100);
        request.setIsLuckyFlag(0);
        request.setOrderStatus(5);
        request.setRefundStatus(5);
        request.setUseHasNext(true);
        request.setPage(page);
        request.setStartUpdatedAt(beginTs);
        request.setEndUpdatedAt(endTs);
        PddOrderNumberListIncrementGetResponse response = getCLient().syncInvoke(request, getAccessToken(StaticDict.PLATFORM_PINDUODUO, shop));
        if (response.getOrderSnIncrementGetResponse() != null) {
            List<PddOrderNumberListIncrementGetResponse.OrderSnIncrementGetResponseOrderSnListItem> orderList = response.getOrderSnIncrementGetResponse().getOrderSnList();
            if (orderList != null && orderList.size() > 0) {
                for (PddOrderNumberListIncrementGetResponse.OrderSnIncrementGetResponseOrderSnListItem item : orderList) {
                    if (StringUtils.isNotBlank(item.getPayTime())) {
//                        DouyinChildExt douyinChildExt = orderValueSet(item, shop);
//                        douyinChildExt.setAuthorId("0");
//                        insertOrder(douyinChildExt, shop);
                    }
                }
            }
//            whShopService.syncResult(shop, new Date(endTs * 1000), 1, "OK");
            return response.getOrderSnIncrementGetResponse().getHasNext();
        } else {
            throw new Exception(response.getErrorResponse().getErrorMsg() + "-" + response.getErrorResponse().getSubMsg());
        }

    }

    public String getAccessToken(String platfrom, WhShopExt whShopExt) throws Exception {
//        String root = "wanghong" + ":" + platformMap.getOrDefault(platfrom, platfrom) + ":token:" + whShopExt.getCshopkey() + ":" + whShopExt.getCshopid() + ":";
        String root = "wanghong" + ":" + platformMap.getOrDefault(platfrom, platfrom) + ":token:" + whShopExt.getCShopkey() + ":" + whShopExt.getCShopid() + ":";
        String err = "授权已失效,请重新授权";
        if (stringRedisTemplate.hasKey(root + "accessToken")) {
            return stringRedisTemplate.opsForValue().get(root + "accessToken");
        }
        if (stringRedisTemplate.hasKey(root + "refreshToken")) {
            return refresh(stringRedisTemplate.opsForValue().get(root + "refreshToken"), whShopExt);
        }
        throw new Exception(err);
    }

    private String refresh(String refreshToken, WhShopExt whShopExt) throws Exception {
        throw new Exception("请重写刷新token的方法");
    }
}
