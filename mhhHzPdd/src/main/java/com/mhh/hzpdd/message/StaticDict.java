package com.mhh.hzpdd.message;

import java.util.HashMap;

public class StaticDict {

	public static final Integer ENABLED = 1;
	public static final Integer DISABLED = 0;
	public static final Integer YES = 1;
	public static final Integer NO = 0;
	public static final Integer SUCCESS = 1;
	public static final Integer FAILED = 0;

	public static final String SUCCEEDED = "SUCCEEDED";
	public static final String SESSION_CACHE_USER_NOTICE = "NOTICE:";

	public static final String DEFAULT_ADMIN_WORK = "admin";
	public static final String DEFAULT_ADMIN_NAME = "管理员";
	public static final String DEFAULT_USER_PASSWORD = "mhh123456";
	public static final String STRING_CONCAT_AT = "@";

	public static final String DEFAULT_USER_ANONYMOUS = "anonymous";

	public static final String PBE_DEFAULT_PASSWORD = "yymqkj@maihh";

	public static final String DEFAULT_USERWORK = "SYSTEM";
	public static final String DEFAULT_USERNAME = "SYSTEM";

	public static final String DEFAULT_HIGH_SEAS = "公海";

	public static final Integer TOKEN_EXPIRE_MONTH = 2;
	public static final String TOKEN_ISSUSER = "maihh.com";

	public static final String CACHE_USERINFO_PATH = "USERINFO";
	public static final String CACHE_AUTH_PATH = "AUTH";

	public static final Integer EXIT_NO = -1;
	public static final Integer EXIT_NORMAL = 0;
	public static final Integer EXIT_OTHER_LOGIN = 10;
	public static final Integer EXIT_KICK_OUT = 20;
	public static final Integer EXIT_DISABLED = 30;
	public static final Integer EXIT_EXPIRE = 40;
	public static final Integer EXIT_PASSWORD_CHANGED = 50;

	public static final String SESSION_USERINFO = "userinfo";
	public static final String SESSION_MODULE = "module";
	public static final String CACHE_USER_CACHE_FOLDER = "userinfo";

	public static final Integer USER_TYPE_ZT = 1; // 中台
	public static final Integer USER_TYPE_YW = 2; // 业务
	public static final Integer USER_TYPE_ZS = 4; // 招商
	public static final Integer USER_TYPE_YY = 8; // 运营
	public static final Integer USER_TYPE_YNW = 16; // 运维
	public static final Integer USER_TYPE_GY = 32; // 供应商
	public static final Integer USER_TYPE_DR = 64; // 达人
	public static final Integer USER_TYPE_JG = 128; // 机构
	public static final Integer USER_TYPE_GT = 256; // 供应商推荐

	public static final Integer USER_TYPE_ALL = 65535;

	public static final Integer CLIENT_TYPE_PT = 1; // 内部PC

	public static final String SCHEDULED_LOCK_PATH = "scheduled:lock";

	public static final String SMS_PHONE_LOCK_PATH = "SMS:PHONE:LOCK";

	public static final String SMS_PHONE_CODE_PATH = "SMS:PHONE:CODE";

	public static final String SMS_SIGN_MAIHH = "麦好火";

	public static final String SMS_TEMPLATE_CODE = "SMS_207520551";

	public static final String SMS_TEMPLATE_PASSWORD = "SMS_234409282";

	public static final Integer MODULE_FUNCTION = 10;

	public static final Integer MODULE_FIELD = 20;

	public static final String PLATFORM_DOUYIN = "292584219933147136";

	public static final String PLATFORM_KUAISHOU = "292606027390517248";

	public static final String PLATFORM_PINDUODUO = "394083805343789058";

	public static final String MQ_TOPIC_PLATFORM_EVENTS = "PLATFORM_EVENTS";

	public static final String MQ_TOPIC_SOCKET_EVENTS = "SOCKET_BROADCAST_EVENTS";

	public static final String MQ_TOPIC_SCHEDULED_SYNC_ORDER = "SCHEDULED_SYNC_ORDER";

	public static final String MQ_TOPIC_SCHEDULED_SYNC_SERVICE_ORDER = "SCHEDULED_SYNC_SERVICE_ORDER";

	// public static final String MQ_TOPIC_SCHEDULED_SYNC_DY_WORKERORDER =
	// "SCHEDULED_SYNC_DY_WORKERORDER";

	// public static final String MQ_TOPIC_SCHEDULED_SYNC_KUAISHOU_ORDER =
	// "SCHEDULED_SYNC_KUAISHOU_ORDER";

	public static final String MQ_TOPIC_SCHEDULED_SYNC_SETT = "SCHEDULED_SYNC_SETT";

	public static final String MQ_TOPIC_SCHEDULED_SYNC_WORKERORDER = "SCHEDULED_SYNC_WORKERORDER";

	public static final String MQ_TOPIC_SCHEDULED_SYNC_PRODUCT = "SCHEDULED_SYNC_PRODUCT";

	public static final String MQ_TOPIC_SCHEDULED_LIVE_CHANGE_DEADLINE = "LIVE_CHANGE_DEADLINE";
	public static final String MQ_TOPIC_SCHEDULED_BRAND_SALE = "BRAND_SALE";
	public static final String MQ_TOPIC_SCHEDULED_BEAND_TARGET = "BEAND_TARGET";

	public static final String MQ_TOPIC_SCHEDULED_LIVE_TO_GONGHAI = "LIVE_TO_GONGHAI";
	public static final String MQ_TOPIC_SCHEDULED_LIVE_OUT_GONGHAI = "LIVE_OUT_GONGHAI";
	public static final String MQ_TOPIC_SCHEDULED_LIVE_SALE_ORDER = "LIVE_SALE_ORDER";

	public static final String MQ_TOPIC_SCHEDULED_SAMPLE_SEND_LOGISTICS = "SAMPLE_SEND_LOGISTICS";

	public static final String MQ_TOPIC_SCHEDULED_RECONCILIATIONLIVE = "RECONCILIATIONLIVE";
	public static final String MQ_TOPIC_SCHEDULED_SYNC_COMMISSION = "SYNC_COMMISSION";
	public static final String MQ_TOPIC_SCHEDULED_SALEMONEYNOTICE = "SALEMONEYNOTICE";
	public static final String MQ_TOPIC_SCHEDULED_GROUP_AVERAGE = "GROUP_AVERAGE";

	public static final Integer SIGN_METHOD_MD5 = 1;

	public static final Integer SIGN_METHOD_HMAC_SHA256 = 2;

	public static final Integer SCHEDULED_TYPE_SYNC_ORDER = 0;
	public static final Integer SCHEDULED_TYPE_SYNC_SETT = 1;
	public static final Integer SCHEDULED_TYPE_SYNC_COMMISSION = 2;
	public static final Integer SCHEDULED_TYPE_SYNC_SERVICE_ORDER = 4;
	public static final Integer SCHEDULED_TYPE_SYNC_AFTERSALE = 5;

	private static HashMap<Integer, String> typeTopicMap = new HashMap<Integer, String>() {
		{
			put(SCHEDULED_TYPE_SYNC_ORDER, MQ_TOPIC_SCHEDULED_SYNC_ORDER);
			put(SCHEDULED_TYPE_SYNC_SETT, MQ_TOPIC_SCHEDULED_SYNC_SETT);
			put(SCHEDULED_TYPE_SYNC_COMMISSION, MQ_TOPIC_SCHEDULED_SYNC_COMMISSION);
			put(SCHEDULED_TYPE_SYNC_SERVICE_ORDER, MQ_TOPIC_SCHEDULED_SYNC_SERVICE_ORDER);
			put(SCHEDULED_TYPE_SYNC_AFTERSALE, MQ_TOPIC_SCHEDULED_SYNC_WORKERORDER);
		}
	};

	public static final String PREFIX_LOGISTICS_ID_PINDUODUO = "PD";

	/**
	 * @Fields quality : 质量保证金
	 */
	public static final int quality = 0;
	/**
	 * @Fields product : 货品保证金
	 */
	public static final int product = 1;
	/**
	 * @Fields service : 服务费
	 */
	public static final int service = 2;
	/**
	 * @Fields aftersale : 售后
	 */
	public static final int aftersale = 3;
	/**
	 * @Fields aftersale : 结算
	 */
	public static final int settlement = 4;
	/**
	 * @Fields aftersale : 反结算
	 */
	public static final int unsettlement = 5;
	/**
	 * @Fields add : 充值
	 */
	public static final int add = 0;
	/**
	 * @Fields sub : 扣款
	 */
	public static final int sub = 1;

	/**
	 * @Fields refund : 退款
	 */
	public static final int refund = 2;
	/**
	 * 模块包含下级
	 */
	public static final int MODULE_HAS_CHILD = 1;
	/**
	 * 模块没有下级
	 */
	public static final int MODULE_HAS_NOT_CHILD = 0;
	public static final int AUTH_TYPE_SELF = 1;
	public static final int AUTH_TYPE_TOOL = 2;
	public static final int SOCKET_EVENTS_TYPE_MESSAGE = 10;
	public static final int SOCKET_EVENTS_TYPE_KICKOUT = 20;

	public static final int SOCKET_MESSAGE_TYPE_KICKOUT = 10;
	public static final int SOCKET_MESSAGE_TYPE_NOTICE = 0;
	public static final int SOCKET_MESSAGE_TYPE_DEFAULT = 9900;

	/**
	 * @Fields unplat : 用户主类型:内部
	 */
	public static final int plat = 1;

	/**
	 * @Fields unplat : 用户主类型:外部
	 */
	public static final int unplat = 2;

	/**
	 * @Fields company : 用户登录绑定类型：机构
	 */
	public static final int organization = 3;

	/**
	 * @Fields company : 用户登录绑定类型：供应商
	 */
	public static final int company = 2;
	/**
	 * @Fields live : 用户登录绑定类型：主播
	 */
	public static final int live = 1;

	/**
	 * 定向链接提交
	 */
	public static final int WHORIENTATIONLINK_SUBMIT = 1;
	/**
	 * 更换校对人
	 */
	public static final int WHORIENTATIONLINK_CHECK = 2;
	/**
	 * 定向链接更换处理人
	 */
	public static final int WHORIENTATIONLINK_CHANGEPROCESSUSER = 3;
	/**
	 * 校对
	 */
	public static final int WHORIENTATIONLINK_UNCHECK = 4;
	/**
	 * 定向链接被完成
	 */
	public static final int WHORIENTATIONLINK_COMPLETETRUE = 5;
	/**
	 * 定向链接确认未通过
	 */
	public static final int WHORIENTATIONLINK_UNPASS = 6;
	/**
	 * 定向链接接收任务
	 */
	public static final int WHORIENTATIONLINK_RECEIVE = 7;
	/**
	 * 定向链接被拒绝
	 */
	public static final int WHORIENTATIONLINK_REFUSE = 8;
	/**
	 * 定向链接运营审核未通过
	 */
	public static final int WHORIENTATIONLINK_UNREVIEW = 9;
	/**
	 * 校对人分配
	 */
	public static final int WHORIENTATIONLINK_LINKCHECKUSER = 10;
	/**
	 * 达人商品佣金审核
	 */
	public static final int WHLIVEPRODUCTCOMMISSION_AUDI = 11;
	/**
	 * 达人商品佣金运营审核
	 */
	public static final int WHLIVEPRODUCTCOMMISSION_AUDITYY = 12;
	/**
	 * 生产计划单审核
	 */
	public static final int WHPLANPRODUCTION_REVIEW = 13;
	/**
	 * 计划单审核
	 */
	public static final int WHPLAN_REVIEW = 14;
	/**
	 * 单品调价审批完成
	 */
	public static final int PRODUCTPRICE_NOTICE = 15;
	/**
	 * 招商合同审批
	 */
	public static final int WHCONTRACT_REVIEW = 16;
	/**
	 * 招商需求审核
	 */
	public static final int WHPRODUCTIONLINE_REVIEW = 17;
	/**
	 * @Fields WHSTARTLIVE : 上播
	 */
	public static final int WHSTARTLIVE = 18;

	/**
	 * @Fields WHSAMPLESEND : 寄样校验
	 */
	public static final int WHSAMPLESEND_INSERT = 19;

	public static String getTopic(Integer ntype) {
		return typeTopicMap.getOrDefault(ntype, "OTHER");
	}
}
