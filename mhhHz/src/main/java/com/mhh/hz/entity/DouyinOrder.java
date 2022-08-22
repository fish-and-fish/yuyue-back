package com.mhh.hz.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.Data;
/**
 * https://op.jinritemai.com/docs/api-docs/15/55(DouyinOrder)实体类
 *
 * @author makejava
 * @since 2022-08-19 15:58:40
 */
@Data
public class DouyinOrder implements Serializable {
    private static final long serialVersionUID = -22638599900085055L;
    
    private String id;
    /**
     * 父订单ID，带大写字母A
     */
    private String orderId;
    /**
     * 抖音店铺ID
     */
    private String shopId;
    /**
     * 在抖音小程序下单时，买家的抖音小程序ID
     */
    private String openId;
    /**
     * 订单状态1在线支付订单待支付；货到付款订单待确认 2备货中（只有此状态下，才可发货）3整单已发货4已取消5已完成101部分发货105订单支付成功，风控处理中；订单支付成功，待成团。
     */
    private Integer orderStatus;
    /**
     * 订单类型 (0实物，2普通虚拟，4poi核销，5三方核销，6服务市场)
     */
    private Integer orderType;
    /**
     * 父订单已发货商品数量
     */
    private Integer shippedNum;
    /**
     * 子订单数量
     */
    private Integer childNum;
    /**
     * 收件人地址
     */
    private String postAddr;
    /**
     * 邮政编码
     */
    private String postCode;
    /**
     * 收件人姓名
     */
    private String postReceiver;
    /**
     * 收件人电话
     */
    private String postTel;
    /**
     * 买家备注
     */
    private String buyerWords;
    /**
     * 卖家备注
     */
    private String sellerWords;
    /**
     * 插旗信息：0：灰1：紫2: 青3：绿4： 橙5： 红
     */
    private String sellerRemarkStars;
    /**
     * 物流公司ID 各ID对应的物流公司
     */
    private String logisticsId;
    /**
     * 物流单号
     */
    private String logisticsCode;
    /**
     * 发货时间。未发货时为"0"，已发货返回秒级时间戳
     */
    private String logisticsTime;
    /**
     * 收货时间。未收货时为"0"，已发货返回秒级时间戳
     */
    private String receiptTime;
    /**
     * 订单创建时间，例如 "1512553757"
     */
    private String createTime;
    /**
     * 订单更新时间
     */
    private String updateTime;
    /**
     * 订单最晚发货时间，例如 1512553887
     */
    private String expShipTime;
    /**
     * 订单取消原因
     */
    private String cancelReason;
    /**
     * 支付类型 (0：货到付款，1：微信，2：支付宝,·4：银行卡,5：余额, 8：放心花, 9：新卡支付）
     */
    private Integer payType;
    /**
     * 支付时间 (pay_type为0货到付款时, 此字段为空)，例如"2018-06-01 12:00:00"
     */
    private Date payTime;
    /**
     * 邮费金额 (单位: 分)
     */
    private Double postAmount;
    /**
     * 平台优惠券金额 (单位: 分)
     */
    private Double couponAmount;
    /**
     * 商家优惠券金额 (单位: 分)
     */
    private Double shopCouponAmount;
    /**
     * 优惠券id
     */
    private String couponMetaId;
    /**
     * 优惠券详情 (type为优惠券类型，具体如下表所示, credit为优惠金额,单位分)
     */
    private String couponInfo;
    /**
     * 主播优惠券金额 (单位: 分)
     */
    private Double talentCouponDiscount;
    /**
     * 主播优惠券ID
     */
    private String talentCouponId;
    /**
     * 主播优惠券模板id
     */
    private String talentCouponMetaId;
    /**
     * 订单实付金额（不包含运费）
     */
    private Double orderTotalAmount;
    /**
     * 所有子订单的享受的平台直降补贴金额汇总
     */
    private Double platformDirectReductionPlatformAmount;
    /**
     * 是否评价 :1已评价，0未评价
     */
    private Integer isComment;
    /**
     * 催单次数
     */
    private Integer urgeCnt;
    /**
     * 订单APP渠道，如下所示0:站外1:火山2:抖音3:头条4:西瓜5:微信6:闪购7:头条lite版本8:懂车帝9:皮皮虾11:抖音极速版12:TikTok
     */
    private Integer bType;
    /**
     * 订单来源类型0:未知1:app2:小程序3:h5
     */
    private Integer subBType;
    /**
     * 订单业务类型，如下所示1:鲁班广告2:联盟4:商城8:自主经营10:线索通支付表单12:抖音门店14:抖+15:穿山甲
     */
    private Integer cBiz;
    /**
     * 是否有退货运费险
     */
    private String isInsurance;
    /**
     * 修改的货款总计
     */
    private Double adjustAmount;
    /**
     * 修改的运费总计
     */
    private Double adjustPostAmount;
    
    private String cType;
    
    private String cosRatio;
    
    private String userName;
    
    private Date dDate;
    
    private Date ts;
    
    private Integer version;
    /**
     * 交易类型0其他1拼团2定金预售
     */
    private Integer tradeType;
    /**
     * 物流信息
     */
    private String logisticsInfo;
    /**
     * 是否已结算0否1是
     */
    private Integer nSettlement;
    
    private String cUserwork;
    
    private String cUsername;

}

