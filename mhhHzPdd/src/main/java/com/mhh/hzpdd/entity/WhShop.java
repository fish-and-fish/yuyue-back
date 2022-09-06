package com.mhh.hzpdd.entity;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

/**
 * 店铺(WhShop)表实体类
 *
 * @author makejava
 * @since 2022-09-05 16:42:02
 */
@Data
public class WhShop {

    private String id;
    //店铺编号
    private String cNum;
    //店铺名称
    private String cName;
    //店铺平台
    private String fkWhPlatform;
    //店铺链接
    private String cUrl;
    //店铺评分
    private String cScore;
    //店铺描述
    private String cMemo;
    //店铺logo
    private String cLogo;
    //卖家中心截图
    private String cScreenshot;
    //店铺等级
    private String cGrade;
    //授权类型：1自有授权，2工具授权
    private Integer nType;
    //平台店铺key:1时必填
    private String cShopkey;
    //平台店铺secret:1时必填
    private String cShopsecret;
    //供应商id
    private String fkWhCompany;

    private String cUserwork;

    private String cUsername;
    //登记时间
    private LocalDate dDate;

    private LocalDate ts;
    //版本号
    private Integer version;
    //是否启用同步
    private Integer nSync;
    //同步状态0失败1成功
    private Integer nSyncstatus;
    //抖音店铺ID
    private String cShopid;
    //0禁用1启用
    private Integer nStatus;
    //招商对接人
    private String fkSysUserZs;
    //运营对接人
    private String fkSysUserYy;
    //中台对接人
    private String fkSysUserZt;
    //销售对接人
    private String fkSysUserXs;
    //所属行业
    private String cIndustry;
    //10合作中，20已结束
    private Integer nClose;
    //关闭时间
    private LocalDate dClose;
    //openId
    private String cOpenid;
    //最后一次错误原因
    private String cLastemsg;
    //0供货价结算1佣金结算
    private Integer nSettType;
    //百分比
    private Double nSettPrice;






    private List<String> companyList;

    private List<String> liveList;

    private List<String> organizationList;


    private List<String> shopList;


    private List<Integer> typeList;
    /**
     * @Fields groupid : 登录业务员的小组ID
     */

    private String groupid;

    /**
     * @Fields groupList : 登录人的小组
     */

    private List<String> groupList;

    /**
     * @Fields nplat : 0平台1非平台
     */

    private Integer nplat;

    /**
     * @Fields nadmin : 0不是管理员1是管理员
     */

    private Integer nadmin;

    private Integer isadmin;
    /**
     * @Fields fkidunplat : 主播或者供应商ID
     */

    private String fkidunplat;
    /**
     * @Fields fksysuserplat : 平台用户ID
     */

    private String fksysuserplat;
    /**
     * @Fields nliveorsup : 主播或供应商 64网红/32供应商
     */

    private Integer nliveorsup;

}

