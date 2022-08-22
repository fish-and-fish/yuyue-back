package com.mhh.hz.entity;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;
/**
 * 订单子表;promotion_talent_amount+promotion_platform_amount+promotion_pay_amount=平台总优惠=platform_cost_amount++promotion_pay_amount(DouyinChildArchive)实体类
 *
 * @author makejava
 * @since 2022-08-19 15:59:59
 */
@Data
public class DouyinChildArchive implements Serializable {
    private static final long serialVersionUID = 835995041107548750L;
    
    private String id;
    /**
     * 主表ID
     */
    private String fkId;
    /**
     * 订单ID
     */
    private String orderId;
    /**
     * 抖音店铺ID
     */
    private String shopId;
    /**
     * 该子订单对应的父订单ID
     */
    private String pid;
    /**
     * 订单发货前order_status与final_status值一致，订单发货后final_status则会包含【订单的售后状态】1在线支付订单待支付；货到付款订单待确认2备货中（只有此状态下，才可发货）3已发货4已取消：1.用户未支付时取消订单；2.用户超时未支付，系统自动取消订单；3.货到付款订单，用户拒收5已完成：1.在线支付订单，商家发货后，用户收货、拒收或者15天无物流更新；2.货到付款订单，用户确认收货6退货中-用户申请7退货中-商家同意退货8退货中-客服仲裁9已关闭-退货失败10退货中-客服同意11退货中-用户已填物流12退货成功-商户同意13退货中-再次客服仲裁14退货中-客服同意退款15退货-用户取消16退款中-用户申请(备货中)17退款中-商家同意(备货中)21退款成功-订单退款（备货中，用户申请退款，最终退款成功）22退款成功-订单退款 (已发货时，用户申请退货，最终退货退款成功)24退货成功-商户已退款 (特指货到付款订单，已发货时，用户申请退货，最终退货退款成功)25退款中-用户取消(备货中)26退款中-商家拒绝（备货中）27退货中-等待买家处理（已发货，商家拒绝用户退货申请）28退货失败（已发货，商家拒绝用户退货申请，客服仲裁支持商家）29退货中-等待买家处理（已发货，用户填写退货物流，商家拒绝）30退款中-退款申请（已发货，用户申请仅退款）31退款申请取消（已发货，用户申请仅退款时，取消申请）32退款中-商家同意（已发货，用户申请仅退款，商家同意申请）33退款中-商家拒绝（已发货，用户申请仅退款，商家拒绝申请）34退款中-客服仲裁（已发货，用户申请仅退款，商家拒绝申请，买家申请客服仲裁）35退款中-客服同意（已发货，用户申请仅退款，商家拒绝申请，客服仲裁支持买家）36退款中-支持商家（已发货，用户申请仅退款，商家拒绝申请，客服仲裁支持商家）37已关闭-退款失败（已发货，用户申请仅退款时，退款关闭）38退款成功-售后退款（特指货到付款订单，已发货，用户申请仅退款时，最终退款成功）39退款成功-订单退款（已发货，用户申请仅退款时，最终退款成功）
     */
    private Integer finalStatus;
    /**
     * 在抖音小程序下单时，买家的抖音小程序ID
     */
    private String openId;
    /**
     * 商品ID
     */
    private String productId;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 头图，商品主图第一张
     */
    private String productPic;
    /**
     * 该子订单购买的商品 sku_id
     */
    private String comboId;
    /**
     * 该子订单所购买的sku的售价
     */
    private Double comboAmount;
    /**
     * 该子订单所购买的sku的数量
     */
    private Integer comboNum;
    /**
     * 该子订单购买的商品的编码 code
     */
    private String code;
    /**
     * 该子订单所属商品规格描述
     */
    private String specDesc;
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
     * 音尊达
     */
    private String shopOrderTagUi;
    /**
     * 物流公司ID 各ID对应的物流公司
     */
    private String logisticsId;
    
    private String logisticsCompanyCode;
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
     * 订单类型 (0实物，2普通虚拟，4poi核销，5三方核销，6服务市场)
     */
    private Integer orderType;
    /**
     * 商品发货方式, 1-全款预售（定时开售） 2-阶梯预售（延迟发货）,不返回则代表现货
     */
    private Integer preSaleType;
    /**
     * 订单创建时间，例如 "1512553757"
     */
    private String createTime;
    /**
     * 订单更新时间
     */
    private String updateTime;
    /**
     * 订单最晚发货时间
     */
    private String expShipTime;
    /**
     * 订单取消原因
     */
    private String cancelReason;
    /**
     * 支付类型 (0：货到付款，1：微信，2：支付宝）
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
     * 子订单实付金额（不包含运费）
     */
    private Double totalAmount;
    /**
     * 子订单的享受的平台直降补贴金额
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
     * 【业务来源】 1、鲁班 2、小店 3、好好学习 4、ev 5、虚拟 6、建站 7、核销 8、玉石 9、ez 10、ep 11、虚拟卡券 12、服务市场 13、EP视频课 14、EP直播课 21、跨境BBC 22、跨境BC 23、跨境CC,UPC 24、手机充值 25、拍卖保证金 26、懂车帝抵扣券 27、懂车帝返现券 28、离岛免税 29、海南会员购 30、抽奖 32、dou+券 76、大闸蟹 99、保险 102、小店海外
     */
    private Integer cBiz;
    /**
     * 是否有退货运费险
     */
    private String isInsurance;
    
    private String cType;
    
    private String cosRatio;
    
    private String userName;
    /**
     * 仓库ID
     */
    private String warehouseId;
    /**
     * 仓库外部ID
     */
    private String outWarehouseId;
    /**
     * 供应商ID
     */
    private String warehouseSupplier;
    /**
     * 该子订单所使用的店铺满减优惠信息
     */
    private String shopFullCampaign;
    /**
     * 店铺满减活动ID
     */
    private String shopCampaignId;
    /**
     * 分摊到该子订单上的满减金额，单位：分
     */
    private Double shopFullAmount;
    /**
     * 该子订单所使用的平台满减金额，单位：分
     */
    private Double platformFullAmount;
    /**
     * 该子订单所使用的平台满减优惠信息
     */
    private String platformFullCampaign;
    /**
     * 平台满减活动ID
     */
    private String platformCampaignId;
    /**
     * 平台满减分摊详情
     */
    private String costSource;
    /**
     * 单优惠总金额= 店铺优惠金额+ 平台优惠金额+ 达人优惠金额+ 支付优惠金额
     */
    private Double promotionAmount;
    /**
     * 优惠由谁承担：1-店铺承担，2-平台承担
     */
    private Integer sourceType;
    /**
     * 子订单已发货商品数量
     */
    private Integer shippedNum;
    /**
     * 子订单中的品id列表
     */
    private String itemIds;
    /**
     * 修改的货款总计
     */
    private Double adjustAmount;
    
    private Date dDate;
    
    private Date ts;
    
    private Integer version;
    
    private String campaignInfo;
    /**
     * 订单状态1在线支付订单待支付；货到付款订单待确认 2备货中（只有此状态下，才可发货）3整单已发货4已取消5已完成101部分发货105订单支付成功，风控处理中；订单支付成功，待成团。
     */
    private Integer orderStatus;
    
    private String outProductId;
    
    private String outSkuId;
    /**
     * 主播信息和佣金
     */
    private String allianceInfo;
    /**
     * 带货达人ID 为0，则表示达人ID为空
     */
    private String authorId;
    /**
     * 达人名字
     */
    private String authorName;
    /**
     * 下单来源：1-直播间  2-短视频  3-文章
     */
    private Integer themeType;
    
    private String appId;
    
    private String roomId;
    
    private String contentId;
    
    private String videoId;
    
    private String originId;
    
    private String cid;
    
    private String pageId;
    
    private Date dLogisticsTime;
    
    private Date dReceiptTime;
    
    private Date dCreateTime;
    
    private Date dUpdateTime;
    
    private Date dExpShipTime;
    /**
     * 是否已结算0否1是
     */
    private Integer nSettlement;
    /**
     * 供应商
     */
    private String fkWhCompany;
    /**
     * 售后金额分
     */
    private Double nAftersaleMoney;
    /**
     * 麦好火收服务费 分
     */
    private Double nServiceMoney;
    /**
     * 商品成本 分
     */
    private Double nProductCost;
    /**
     * 运费成本 分
     */
    private Double nLogisticsMoney;
    /**
     * 退货数
     */
    private Integer nProductReturn;
    /**
     * 交易类型0其他1拼团2定金预售
     */
    private Integer tradeType;
    /**
     * 店铺优惠金额，单位分
     */
    private Double promotionShopAmount;
    /**
     * 平台优惠金额，单位分
     */
    private Double promotionPlatformAmount;
    /**
     * 订单优惠商家承担部分，单位分
     */
    private Double shopCostAmount;
    /**
     * 订单优惠平台承担部分含达人优惠，单位分
     */
    private Double platformCostAmount;
    /**
     * 达人优惠金额（带货达人承担补贴成本），单位分
     */
    private Double promotionTalentAmount;
    /**
     * 支付优惠金额（例如支付宝平台会给出一些支付的优惠金额），单位分
     */
    private Double promotionPayAmount;
    /**
     * 卖家应收金额，单位分
     */
    private Double shopReceivableAmount;
    /**
     * 0未进行任何数据操作1付款后进行单品同步
     */
    private Integer nChange;
    /**
     * 0未进行任何数据操作1付款后进行业务员同步
     */
    private Integer nUser;
    /**
     * 退款金额
     */
    private Double nMoneyRetrun;
    /**
     * 0未进行任何数据操作1付款后进行跟进人同步
     */
    private Integer nUserDocking;
    /**
     * 结算时间
     */
    private Date dSettlement;
    /**
     * 实际支付金额
     */
    private Double payAmount;
    /**
     * 结算时所有补贴总和含支付补贴
     */
    private Double platformCoupon;
    /**
     * 支付优惠字段
     */
    private Double payPromotionAmount;
    /**
     * 订单退款金额
     */
    private Double orderRefund;
    /**
     * 抖音收的服务费 分
     */
    private Double nPlatMoney;
    /**
     * 实际佣金单位分
     */
    private Double realCommission;
    /**
     * 线下佣金
     */
    private Double nOfflineCommission;
    /**
     * 商品渠道费用
     */
    private Double goodLearnChannelFee;
    /**
     * 结算店铺获得金额
     */
    private Double settleAmount;
    
    private Double nLogisticsMoneyLook;
    
    private String fkWhPlatform;
    /**
     * 预估佣金，单位：分
     */
    private Double estimatedComission;
    /**
     * 加密用户ID串
     */
    private String doudianOpenId;
    /**
     * （biz存的是c_biz;c_biz存的是biz）【C端流量来源】 0、unknown 2、精选联盟 8、小店自卖
     */
    private Integer biz;
    /**
     * 订单数量默认1
     */
    private Integer nOrdernum;
    /**
     * 需要获取佣金的订单是否已经获取过(佣金为0) 0否1是
     */
    private Integer nGetCommission;

}

