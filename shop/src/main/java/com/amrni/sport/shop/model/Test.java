package com.amrni.sport.shop.model;

import com.amrni.sport.shop.base.AbstractBaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
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

@TableName("test")
@Entity(name = "test")
@Data
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class Test extends AbstractBaseEntity implements Serializable {

    @Id
    @GenericGenerator(name = "id", strategy = "com.amrni.sport.shop.config.SnowIdGenerator")
    @GeneratedValue(generator = "id")
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private String name;

}

