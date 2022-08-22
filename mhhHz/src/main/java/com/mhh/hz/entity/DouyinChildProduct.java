package com.mhh.hz.entity;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;
/**
 * (DouyinChildProduct)实体类
 *
 * @author makejava
 * @since 2022-08-19 16:00:01
 */
@Data
public class DouyinChildProduct implements Serializable {
    private static final long serialVersionUID = 342819065144739365L;
    
    private String id;
    /**
     * 订单ID
     */
    private String orderId;
    
    private String fkWhCompany;
    
    private String c69code;
    
    private String cName;
    
    private Integer nCount;
    
    private Date dDate;
    
    private Date ts;
    
    private Integer version;
    /**
     * 商品成本
     */
    private Double nCost;
    /**
     * 优惠价格
     */
    private Double nDiscount;
    /**
     * 优惠外键
     */
    private String fkWhDiscount;
    /**
     * 总优惠个数; 订单单品总数为ncount*comboNum
     */
    private Integer nDiscountCount;
    
    private String cUserwork;
    
    private String cUsername;

}

