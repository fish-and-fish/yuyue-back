package com.mhh.hz.update;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.mhh.hz.dao.DouyinChildDao;
import com.mhh.hz.entity.DouyinChild;

@Component
public class TongBu {

    @Resource
    DouyinChildDao douyinChildDao;

//    @Scheduled(cron = "0/15 * * * * ?")   //定时器定义，设置执行时间
    @Scheduled(fixedDelay = 1000)
    private void process() {
        final DouyinChild douyinChild = douyinChildDao.selectById(1);
    }
}
