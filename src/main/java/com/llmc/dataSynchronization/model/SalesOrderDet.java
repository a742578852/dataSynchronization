package com.llmc.dataSynchronization.model;

import java.math.BigDecimal;

public class SalesOrderDet {
    //id
    private String id;
    //主表id
    private String fRef;
    //商品编号
    private String goodsCode;
    //1
    private String employeeId;
    //00101
    private String departmentCode;
    //数量
    private double notOutQty;
    //0000100001
    private String stockCode;
    //0
    private int finishStatus;
    //00001
    private String sCompanyID;

    //总金额
    private double needReceiveAmt;
    //数量
    private double notPayQty;
    //数量
    private double qty;
    //单价
    private double price;
    //总价
    private double amount;
    //100
    private double discount;
    //单价
    private double disPrice;
    //总价
    private double disBackAmt;
    //单价
    private double taxPrice;
    //总价
    private double taxAmount;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getfRef() {
        return fRef;
    }

    public void setfRef(String fRef) {
        this.fRef = fRef;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }



    public double getNotOutQty() {
        return notOutQty;
    }

    public void setNotOutQty(double notOutQty) {
        this.notOutQty = notOutQty;
    }



    public int getFinishStatus() {
        return finishStatus;
    }

    public void setFinishStatus(int finishStatus) {
        this.finishStatus = finishStatus;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getsCompanyID() {
        return sCompanyID;
    }

    public void setsCompanyID(String sCompanyID) {
        this.sCompanyID = sCompanyID;
    }

    public double getNeedReceiveAmt() {
        return needReceiveAmt;
    }

    public void setNeedReceiveAmt(double needReceiveAmt) {
        this.needReceiveAmt = needReceiveAmt;
    }

    public double getNotPayQty() {
        return notPayQty;
    }

    public void setNotPayQty(double notPayQty) {
        this.notPayQty = notPayQty;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getDisPrice() {
        return disPrice;
    }

    public void setDisPrice(double disPrice) {
        this.disPrice = disPrice;
    }

    public double getDisBackAmt() {
        return disBackAmt;
    }

    public void setDisBackAmt(double disBackAmt) {
        this.disBackAmt = disBackAmt;
    }

    public double getTaxPrice() {
        return taxPrice;
    }

    public void setTaxPrice(double taxPrice) {
        this.taxPrice = taxPrice;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }
}
