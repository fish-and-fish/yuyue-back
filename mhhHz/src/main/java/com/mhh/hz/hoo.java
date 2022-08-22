package com.mhh.hz;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class hoo {

    static Map<String, String> map = new LinkedHashMap<>();

    public static void main(String[] args) {
        String a = "ccompanyname\n" +
                "供应商名称\n" +
                "250\n" +
                "cbrand\n" +
                "品牌名称\n" +
                "150\n" +
                "ncomboamount\n" +
                "销售金额\n" +
                "150\n" +
                "ncombonum\n" +
                "商品销售量\n" +
                "150\n" +
                "nordernum\n" +
                "子订单数量\n" +
                "150\n" +
                "nlogisticsmoneylook\n" +
                "预付运费\n" +
                "150\n" +
                "ncost\n" +
                "货品成本\n" +
                "150\n" +
                "naftersalemoney\n" +
                "售后金额\n" +
                "150\n" +
                "postAmount\n" +
                "邮费金额\n" +
                "150\n" +
                "couponAmount\n" +
                "平台优惠券金额\n" +
                "150\n" +
                "realcommission\n" +
                "线上佣金\n" +
                "150\n" +
                "nofflinecommission\n" +
                "线下佣金\n" +
                "150\n" +
                "ncomboamount_luban\n" +
                "鲁班金额\n" +
                "150\n" +
                "ncomboamount_xiaodian\n" +
                "小店金额\n" +
                "150\n" +
                "ncomboamount_qitayewu\n" +
                "其他业务来源金额\n" +
                "150\n" +
                "ncomboamount_zhibo\n" +
                "直播金额\n" +
                "150\n" +
                "ncomboamount_shipin\n" +
                "短视频金额\n" +
                "150\n" +
                "ncomboamount_qitaqudao\n" +
                "其他下单来源金额\n" +
                "150\n" +
                "cshopname\n" +
                "店铺名称\n" +
                "200\n" +
                "cproductname\n" +
                "货品名称\n" +
                "400\n" +
                "nservicemoney\n" +
                "服务费\n" +
                "150\n";

        String b = "ccategory\n" +
                "类目\n" +
                "150\n" +
                "nordernum\n" +
                "订单数量\n" +
                "150\n" +
                "nlivenum\n" +
                "出货达人数\n" +
                "150\n" +
                "ncomboamount\n" +
                "销售额\n" +
                "150\n" +
                "ncombonum\n" +
                "销售量\n" +
                "150\n" +
                "nlogisticsmoneylook\n" +
                "预付运费\n" +
                "150\n" +
                "ncost\n" +
                "货品成本\n" +
                "150\n" +
                "naftersalemoney\n" +
                "售后金额\n" +
                "150\n" +
                "postAmount\n" +
                "邮费金额\n" +
                "150\n" +
                "couponAmount\n" +
                "平台优惠券金额\n" +
                "150\n" +
                "nservicemoney\n" +
                "服务费\n" +
                "150\n" +
                "realcommission\n" +
                "线上佣金\n" +
                "150\n" +
                "nofflinecommission\n" +
                "线下佣金\n" +
                "150\n" +
                "ncomboamount_luban\n" +
                "鲁班金额\n" +
                "150\n" +
                "ncomboamount_xiaodian\n" +
                "小店金额\n" +
                "150\n" +
                "ncomboamount_qitayewu\n" +
                "其他业务来源金额\n" +
                "150\n" +
                "ncomboamount_zhibo\n" +
                "直播金额\n" +
                "150\n" +
                "ncomboamount_shipin\n" +
                "短视频金额\n" +
                "150\n" +
                "ncomboamount_qitaqudao\n" +
                "其他下单来源金额\n" +
                "150\n";

        String c = "cshopname\n" +
                "店铺名称\n" +
                "150\n" +
                "ncomboamount\n" +
                "总销售额\n" +
                "150\n" +
                "cusernamezs\n" +
                "招商负责人\n" +
                "150\n" +
                "ccompanyname\n" +
                "供应商名称\n" +
                "250\n" +
                "ncomboamountsend\n" +
                "发货销售额\n" +
                "150\n" +
                "ncomboamount_luban\n" +
                "推广销售\n" +
                "150\n" +
                "ncomboamount_xiaodian\n" +
                "达人销售\n" +
                "150\n" +
                "nmarketingpricein\n" +
                "营销收入\n" +
                "150\n" +
                "ncomboamount_qitayewu\n" +
                "其他销售\n" +
                "150\n" +
                "ncombonum\n" +
                "商品销量\n" +
                "150\n" +
                "nordernum\n" +
                "子订单数\n" +
                "150\n" +
                "nproductcost\n" +
                "货品成本\n" +
                "150\n" +
                "postAmount\n" +
                "邮费金额\n" +
                "150\n" +
                "nlogisticsmoney\n" +
                "物流成本\n" +
                "150\n" +
                "nplatmoney\n" +
                "平台扣点\n" +
                "150\n" +
                "realcommission\n" +
                "达人佣金\n" +
                "150\n" +
                "nofflinecommission\n" +
                "线下佣金\n" +
                "150\n" +
                "nmarketingpriceout\n" +
                "营销支出\n" +
                "150\n" +
                "ncomboamount_zhibo\n" +
                "直播销售\n" +
                "150\n" +
                "ncomboamount_shipin\n" +
                "短视频销售\n" +
                "150\n" +
                "ncomboamount_qitaqudao\n" +
                "其他来源销售\n" +
                "150\n" +
                "ncomboamount_xiaodianzimai\n" +
                "小店自卖\n" +
                "150\n" +
                "ncomboamount_qitaliuliang\n" +
                "其他流量来源\n" +
                "150\n" +
                "cplatformname\n" +
                "平台名称\n" +
                "150\n" +
                "cusernameyy\n" +
                "运营人\n" +
                "150\n" +
                "ncomboamountcalculate\n" +
                "计提费用\n" +
                "150\n" +
                "naftersalemoneystr\n" +
                "售后金额\n" +
                "150\n" +
                "nmhhservicemoney\n" +
                "麦好火服务费\n" +
                "150\n" +
                "ngrossprofit\n" +
                "毛利\n" +
                "150\n" +
                "ngrossprofitpercentage\n" +
                "毛利率" +
                "150\n";

        f(a);
        f(b);
        f(c);
        String sql = "CREATE TABLE `douyin_item`  (" +
                "  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL";
        for (String k : map.keySet()) {
            sql += ",\n" +
                    "  `" + k + "` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '"
                    + map.get(k) + "'";
        }
        sql += "\n) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '订单子表;promotion_talent_amount+promotion_platform_amount+promotion_pay_amount=平台总优惠=platform_cost_amount++promotion_pay_amount' ROW_FORMAT = Dynamic;\n";

        System.out.println(sql);
        System.out.println(map.size());
    }

    public static void f(String a) {
        final String[] splitC = a.split("\n");
        for (int i = 0; i < splitC.length; ) {
            map.put(splitC[i], splitC[i + 1]);
            i += 3;
        }

    }

}
