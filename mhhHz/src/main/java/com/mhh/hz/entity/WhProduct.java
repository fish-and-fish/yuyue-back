package com.mhh.hz.entity;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;
/**
 * (WhProduct)实体类
 *
 * @author makejava
 * @since 2022-08-19 16:35:27
 */
@Data
public class WhProduct implements Serializable {
    private static final long serialVersionUID = 600236850635478171L;
    /**
     * ID
     */
    private String id;
    /**
     * 商品编号
     */
    private String cNum;
    /**
     * 商品名称
     */
    private String cName;
    /**
     * 供应商
     */
    private String fkWhCompany;
    
    private String fkWhBrand;
    /**
     * 商品商家编号
     */
    private String c69code;
    /**
     * 分类
     */
    private String cCategory;
    /**
     * 卖点
     */
    private String cFeature;
    /**
     * 链接
     */
    private String cUrl;
    /**
     * 主图
     */
    private String cPicture;
    /**
     * 包邮0否1是
     */
    private Integer nMail;
    /**
     * 卖家承担运费险0否1是
     */
    private Integer nMailmoney;
    /**
     * 登记时间
     */
    private Date dDate;
    
    private Date ts;
    /**
     * 版本号
     */
    private Integer version;
    /**
     * 1级分类id
     */
    private String firstCid;
    /**
     * 1级分类名称
     */
    private String firstCname;
    /**
     * 2级分类名称
     */
    private String secondCid;
    /**
     * 2级分类名称
     */
    private String secondCname;
    /**
     * 3级分类id
     */
    private String thirdCid;
    /**
     * 3级分类名称
     */
    private String thirdCname;
    /**
     * 4级分类id
     */
    private String fourthCid;
    /**
     * 4级分类名称
     */
    private String fourthCname;
    /**
     * 运费模板
     */
    private String fkWhTemplate;
    /**
     * 体积
     */
    private Double nVolume;
    /**
     * 重量
     */
    private Double nWeight;
    /**
     * 成本价（元）
     */
    private Double nCost;
    /**
     * 售后承担比例
     */
    private Double nProportion;
    /**
     * productid
     */
    private String cProductid;
    /**
     * 商品订单数量
     */
    private Integer nOrdernum;
    /**
     * 商品订单售后数量
     */
    private Integer nAftersalenum;
    /**
     * 销售量
     */
    private Integer nSalenum;
    /**
     * 商品类型0单品1组合
     */
    private Integer nType;
    /**
     * 备注
     */
    private String cMemo;
    /**
     * 是否隐藏0否1是
     */
    private Integer nHide;
    /**
     * 品牌
     */
    private String cBrand;
    /**
     * 0新建10招商团队审核15招商佣金审核20ERP创建30运营上架
     */
    private Integer nStatus;
    /**
     * 主播ID
     */
    private String fkWhLive;
    /**
     * 售价元
     */
    private Double nPrice;
    /**
     * 截图附件
     */
    private String cAnnex;
    /**
     * 佣金百分比
     */
    private Double nCommission;
    /**
     * 是否设置不良率0否1是
     */
    private Integer nProportionstatus;
    /**
     * 链接
     */
    private String cLink;
    /**
     * 单位
     */
    private String cUnit;
    /**
     * 规格型号
     */
    private String cSpecification;
    /**
     * 市场价
     */
    private Double nMarketprice;
    /**
     * 生产周期
     */
    private Integer nProductioncycle;
    /**
     * 保质期（天）
     */
    private Integer nShelflife;
    /**
     * 包材生产周期
     */
    private Integer nProductioncyclepackage;
    /**
     * 日能产
     */
    private Double nNissan;
    /**
     * 产品类目id
     */
    private String fkWhProductCategory;
    
    private String cUserwork;
    
    private String cUsername;
    /**
     * 是否已经手动操作0否1是
     */
    private Integer nHand;
    /**
     * 是否允许送样0否1是
     */
    private Integer nSamplesend;
    /**
     * 快手产品子类目ID
     */
    private String kuaishouCategory;
    /**
     * 快手产品子类目名称
     */
    private String kuaishouCategoryName;
    /**
     * 税率
     */
    private Double nTariff;
    /**
     * 含税价
     */
    private Double nTariffprice;

}

