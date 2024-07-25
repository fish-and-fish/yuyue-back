package com.amrni.sport.shop.config;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Twitter的分布式自增ID雪花算法snowflake
 * 只能用69年哦~
 */
public class SnowFlakeUtils {
    /**
     * 起始时间戳 2019-01-01 00:00:00.000
     */
    private final static long START_TIMESTAMP = Date.from(LocalDateTime.of(2019, 1, 1, 0, 0, 0).atZone(ZoneId.systemDefault()).toInstant()).getTime();

    /**
     * 每一部分占用位数
     */
    private final static long SEQUENCE_BIT = 12;        //序列号占用的位数
    private final static long MACHINE_BIT = 5;            //机器表示占用的位数
    private final static long DATACENTER_BIT = 5;        //数据中心你占用的位数

    /**
     * 每一部分的最大值
     */
    private final static long MAX_DATACENTER_ID = -1L ^ (-1L << DATACENTER_BIT);
    private final static long MAX_MACHINE_ID = -1L ^ (-1L << MACHINE_BIT);
    private final static long MAX_SEQUENCE = -1L ^ (-1L << SEQUENCE_BIT);

    /**
     * 每一部分向左的位移
     */
    private final static long MACHINE_LEFT = 0L + SEQUENCE_BIT;
    private final static long DATACENTER_LEFT = MACHINE_LEFT + MACHINE_BIT;
    private final static long TIMESTAMP_LEFT = DATACENTER_LEFT + DATACENTER_BIT;

    //数据中心ID
    private long dataCenterId;

    //机器ID
    private long machineId;

    //当前序列号
    private long sequence = 0L;

    //上一次时间戳
    private long lastTimeStamp = -1L;

    public SnowFlakeUtils(long dataCenterId, long machineId) {
        if (dataCenterId > MAX_DATACENTER_ID || dataCenterId < 0) {
            throw new IllegalArgumentException("datacenterId can't be greater than " + MAX_DATACENTER_ID + " or less than 0");
        }
        if (machineId > MAX_MACHINE_ID || machineId < 0) {
            throw new IllegalArgumentException("machineId can't be greater than " + MAX_MACHINE_ID + " or less than 0");
        }
        this.dataCenterId = dataCenterId;
        this.machineId = machineId;
    }

    //获取下一个序列
    public synchronized long nextId() {
        long currentTimestamp = getNewTimeStamp();
        if (currentTimestamp < lastTimeStamp) {
            throw new RuntimeException("Clock moved backwards.  Refusing to generate id");
        }
        if (currentTimestamp == lastTimeStamp) {
            sequence = (sequence + 1) & MAX_SEQUENCE;
            if (sequence == 0L) {
                currentTimestamp = getNextTimeStamp();
                sequence = 0L;
            }
        } else {
            sequence = 0;
        }
        lastTimeStamp = currentTimestamp;
        return (currentTimestamp - START_TIMESTAMP) << TIMESTAMP_LEFT | dataCenterId << DATACENTER_LEFT | machineId << MACHINE_LEFT | sequence;
    }

    private long getNextTimeStamp() {
        long timeStamp = getNewTimeStamp();
        while (timeStamp <= lastTimeStamp) {
            timeStamp = getNewTimeStamp();
        }
        return timeStamp;
    }

    private long getNewTimeStamp() {
        return System.currentTimeMillis();
    }
}
