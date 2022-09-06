package com.mhh.hzpdd.entity;

import java.util.Date;
import java.util.List;


import lombok.Data;

/**
 * 店铺
 * 
 * @author zhbin
 *
 */
@Data
public class WhShopExt extends WhShop {
	
	private List<WhShopExt> whShopExtList;
	
//	private List<WhShopBrandExt> whShopBrandExtList;
//
//	private List<WhShopProductExt> whShopProductExtList;
//
//	private List<WhShopUserExt> whShopUserExtList;
	
	private List<String> ids;
	
	private String ccompanyname;
	
	private String cplatformname;
	
	private String ccompanynum;
	
	private String cplatformnum;
	
	private Date lastUpdate;

	
	private String historyId;

	
	private String currentTime;

	
	private Integer sversion;

	
	private String accessToken;

	
	private String code;

	
	private String cid;

	
	private String cusernamezs;
	
	private String cusernameyy;
	
	private String cusernamezt;
	
	private String cusernamexs;

	
	private String cphonezs;
	
	private String cphoneyy;
	
	private String cphonezt;
	
	private String cphonexs;

	
	private String fkwhgroup;
	
	private String cbrandname;
	
	private String cdduseridyy;
	
	private String cddunionidyy;

	
	private Integer synctype;
}