package com.amrni.sport.shop.command;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookingCmd implements Serializable {

    private Integer courseId;
    private Integer teacherId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

}
