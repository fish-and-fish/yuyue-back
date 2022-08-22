package com.mhh.hz.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 类目(WhCategory)实体类
 *
 * @author makejava
 * @since 2022-08-19 15:55:38
 */
public class WhCategory implements Serializable {
    private static final long serialVersionUID = 402977586540018281L;
    /**
     * ID
     */
    private String id;
    /**
     * 类目编号
     */
    private String cNum;
    /**
     * 类目名称
     */
    private String cName;
    /**
     * 是否删除0否1是
     */
    private Integer nDelete;
    
    private String cMemo;
    /**
     * 序号
     */
    private Integer nOrder;
    
    private String cUserwork;
    
    private String cUsername;
    /**
     * 登记时间
     */
    private Date dDate;
    
    private Date ts;
    /**
     * 版本号
     */
    private Integer version;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCNum() {
        return cNum;
    }

    public void setCNum(String cNum) {
        this.cNum = cNum;
    }

    public String getCName() {
        return cName;
    }

    public void setCName(String cName) {
        this.cName = cName;
    }

    public Integer getNDelete() {
        return nDelete;
    }

    public void setNDelete(Integer nDelete) {
        this.nDelete = nDelete;
    }

    public String getCMemo() {
        return cMemo;
    }

    public void setCMemo(String cMemo) {
        this.cMemo = cMemo;
    }

    public Integer getNOrder() {
        return nOrder;
    }

    public void setNOrder(Integer nOrder) {
        this.nOrder = nOrder;
    }

    public String getCUserwork() {
        return cUserwork;
    }

    public void setCUserwork(String cUserwork) {
        this.cUserwork = cUserwork;
    }

    public String getCUsername() {
        return cUsername;
    }

    public void setCUsername(String cUsername) {
        this.cUsername = cUsername;
    }

    public Date getDDate() {
        return dDate;
    }

    public void setDDate(Date dDate) {
        this.dDate = dDate;
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

}

