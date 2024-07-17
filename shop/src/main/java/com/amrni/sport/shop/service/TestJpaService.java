package com.amrni.sport.shop.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.amrni.sport.shop.config.DataSourceContextHolder;
import com.amrni.sport.shop.jpa.TestJpa;
import com.amrni.sport.shop.model.Test;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestJpaService {

    private final TestJpa testJpa;

//    @PostConstruct
    public void f(){
        DataSourceContextHolder.setDataSource("primary");
        List<Test> all = testJpa.findAll();
        System.out.println(all);

        DataSourceContextHolder.setDataSource("secondary");
        List<Test> secondary = testJpa.findAll();
        System.out.println(secondary);

    }

    //    private final TrackingJpa trackingJpa;
    //    private void saveTracking(String trackingNumber) {
    //        Tracking tracking = trackingJpa.findByTrackingNumber(trackingNumber);
    //        if (tracking != null) {
    //            return;
    //        }
    //        OkHttpClient client = new OkHttpClient();
    //        String url = "https://wms.jisuhaiwaicang.com/public/hz-fedex-tracking-status?trackingNumber=";
    //        url += trackingNumber;
    //        Request request = new Request.Builder()
    //                .url(url)
    //                .build();
    //        try {
    //            Response response = client.newCall(request).execute();
    //            tracking = new Tracking();
    //            tracking.setTrackingNumber(trackingNumber);
    //            tracking.setJson(response.body().string());
    //            trackingJpa.save(tracking);
    //            Thread.sleep(4000);
    //        } catch (IOException | InterruptedException e) {
    //            e.printStackTrace();
    //        }
    //    }
}

