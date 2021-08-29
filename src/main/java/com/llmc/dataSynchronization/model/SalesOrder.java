package com.llmc.dataSynchronization.model;

import java.math.BigDecimal;

public class SalesOrder {

    private String id;
    //单据日期
    private String billdate;
    //部门编号 00101
    private String departmentCode;
    //员工id 1
    private String employeeID;
    //公司编码 00003
    private String companyCode;
    //编号 0000100001
    private String stockCode;
    //接收日期 当前时间 yyyy mm dd
    private String receiveDate;

    //1
    private String createBy;
    //1
    private String lastUpdateBy;
    //当前时间 yyyy mm dd hh mm ss
    private String createTime;
    //当前时间 yyyy mm dd hh mm ss
    private String lastUpdateTime;
    //0
    private String statusId;


    //当前年
    private int periodYear;
    //当前月
    private int periodMonth;
    //当前月
    private int period;
    //总金额
    private double alrAccAmt;
    //订单号
    private String billNo;


    //00001
    private String sCompanyID;


    //finish
    private String workFlowNodeName;
    //-1
    private String workFlowNode;
    //CreditSale
    private String tradeType;


    //当前时间
    private String finishTime;
    //uuid
    private String certificate;
    // 100
    private double discount;
    // 1
    private double currencyRate;
    //总额
    private double totalAmount;
    //总额
    private double totalTaxAmount;
    // 1001
    private int account;
    //总额
    private double accountAmount;
    //3
    private int inVoiceType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBilldate() {
        return billdate;
    }

    public void setBilldate(String billdate) {
        this.billdate = billdate;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(String receiveDate) {
        this.receiveDate = receiveDate;
    }


    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }


    public int getPeriodYear() {
        return periodYear;
    }

    public void setPeriodYear(int periodYear) {
        this.periodYear = periodYear;
    }

    public int getPeriodMonth() {
        return periodMonth;
    }

    public void setPeriodMonth(int periodMonth) {
        this.periodMonth = periodMonth;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public double getAlrAccAmt() {
        return alrAccAmt;
    }

    public void setAlrAccAmt(double alrAccAmt) {
        this.alrAccAmt = alrAccAmt;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setCurrencyRate(double currencyRate) {
        this.currencyRate = currencyRate;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setTotalTaxAmount(double totalTaxAmount) {
        this.totalTaxAmount = totalTaxAmount;
    }

    public void setAccountAmount(double accountAmount) {
        this.accountAmount = accountAmount;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }



    public String getsCompanyID() {
        return sCompanyID;
    }

    public void setsCompanyID(String sCompanyID) {
        this.sCompanyID = sCompanyID;
    }



    public String getWorkFlowNodeName() {
        return workFlowNodeName;
    }

    public void setWorkFlowNodeName(String workFlowNodeName) {
        this.workFlowNodeName = workFlowNodeName;
    }

    public String getWorkFlowNode() {
        return workFlowNode;
    }

    public void setWorkFlowNode(String workFlowNode) {
        this.workFlowNode = workFlowNode;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }



    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }



    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public double getDiscount() {
        return discount;
    }

    public double getCurrencyRate() {
        return currencyRate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public double getTotalTaxAmount() {
        return totalTaxAmount;
    }

    public double getAccountAmount() {
        return accountAmount;
    }

    public int getInVoiceType() {
        return inVoiceType;
    }

    public void setInVoiceType(int inVoiceType) {
        this.inVoiceType = inVoiceType;
    }
}
