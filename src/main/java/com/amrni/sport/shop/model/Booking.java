package com.amrni.sport.shop.model;

import com.amrni.sport.shop.base.AbstractBaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@TableName("Booking")
@Entity(name = "Booking")
@Data
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class Booking extends AbstractBaseEntity implements Serializable {

    @Id
    //    @GenericGenerator(name = "id",strategy = "com.speeder.common.config.SnowIdGenerator")
    //    @GeneratedValue(generator = "id")
    @TableId(type = IdType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;

    private Integer courseId;

    private Integer teacherId;

    private LocalDateTime bookingStartTime;

    private LocalDateTime bookingEndTime;

    private LocalDateTime bookingTime;

    private LocalDateTime completeTime;

    private LocalDateTime cancelTime;

    private String bookStatus;

    @TableField(exist = false)
    @Transient
    private Course course;

    @TableField(exist = false)
    @Transient
    private Teacher teacher;
}

