package com.amrni.sport.shop.vo;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BookingInfoVo {

    private Integer finishCourseNum;
    private Integer bookingCourseNum;

    private Boolean vip;
    private LocalDateTime expiredTime;

}

