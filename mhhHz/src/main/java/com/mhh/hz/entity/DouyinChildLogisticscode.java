package com.mhh.hz.entity;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;
/**
 * (DouyinChildLogisticscode)实体类
 *
 * @author makejava
 * @since 2022-08-19 16:00:01
 */
@Data
public class DouyinChildLogisticscode implements Serializable {
    private static final long serialVersionUID = -17785056336255512L;
    
    private String id;
    /**
     * 订单ID
     */
    private String orderId;
    /**
     * 物流单号
     */
    private String logisticsCode;
    
    private String logisticsId;
    
    private String logisticsCompanyCode;
    /**
     * 快递单发了当前子单商品个数
     */
    private Integer nCount;
    
    private Date ts;
    /**
     * 版本
     */
    private Integer version;
    /**
     * 重量
     */
    private Double nWeight;
    /**
     * 体积
     */
    private Double nVolume;
    
    private Date dShiptime;
    
    private String cUserwork;
    
    private String cUsername;
    
    private Date dDate;

}

