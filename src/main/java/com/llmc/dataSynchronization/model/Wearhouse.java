package com.llmc.dataSynchronization.model;

import java.util.Date;

public class Wearhouse {

    /**
     * 仓库id
     */
     private int dscWearhouseId;

     private Date createTime;

     private Date updateTime;

     private String createBy;

     private String updateBy;

     private int isValid;
    /**
     * 仓库名
     */
    private String wId;

    private String biaohao;

    private String longitude;

    private String latitude;

    private String position;

    private Wearhouse acWearhouse;

    private Wearhouse productWearhouse;


    public Wearhouse getAcWearhouse() {
        return acWearhouse;
    }

    public void setAcWearhouse(Wearhouse acWearhouse) {
        this.acWearhouse = acWearhouse;
    }

    public Wearhouse getProductWearhouse() {
        return productWearhouse;
    }

    public void setProductWearhouse(Wearhouse productWearhouse) {
        this.productWearhouse = productWearhouse;
    }

    public int getDscWearhouseId() {
        return dscWearhouseId;
    }

    public void setDscWearhouseId(int dscWearhouseId) {
        this.dscWearhouseId = dscWearhouseId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public int getIsValid() {
        return isValid;
    }

    public void setIsValid(int isValid) {
        this.isValid = isValid;
    }

    public String getwId() {
        return wId;
    }

    public void setwId(String wId) {
        this.wId = wId;
    }

    public String getBiaohao() {
        return biaohao;
    }

    public void setBiaohao(String biaohao) {
        this.biaohao = biaohao;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
