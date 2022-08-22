package com.mhh.hz.entity;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;
/**
 * 组合商品明细(WhProductCombination)实体类
 *
 * @author makejava
 * @since 2022-08-19 16:35:27
 */
@Data
public class WhProductCombination implements Serializable {
    private static final long serialVersionUID = -25160133080275414L;
    /**
     * id
     */
    private String id;
    /**
     * 组合商品id
     */
    private String fkWhProduct;
    /**
     * 单品信息
     */
    private String cJson;
    /**
     * 生效时间
     */
    private Date dBegin;
    /**
     * 登记时间
     */
    private Date dDate;
    
    private Date ts;
    /**
     * 版本号
     */
    private Integer version;
    
    private String cUserwork;
    
    private String cUsername;

}

