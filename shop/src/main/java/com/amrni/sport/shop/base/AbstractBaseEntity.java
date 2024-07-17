package com.amrni.sport.shop.base;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractBaseEntity<T extends Model<?>> extends Model<T> implements Serializable{

    @Version
    @com.baomidou.mybatisplus.annotation.Version
    private Integer version;

    @CreatedDate
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime created;

    @LastModifiedDate
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime modified;

}
