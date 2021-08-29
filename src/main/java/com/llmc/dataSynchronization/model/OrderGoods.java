package com.llmc.dataSynchronization.model;



import java.io.Serializable;
import java.math.BigDecimal;

/**
 * dsc_order_goods
 * @author 
 */

public class OrderGoods implements Serializable {
    private Integer recId;

    private Integer orderId;

    /**
     * 会员ID
     */
    private Integer userId;

    private String cartRecid;

    private Integer goodsId;

    private String goodsName;

    private String goodsSn;

    private Integer productId;

    private Integer goodsNumber;

    private BigDecimal marketPrice;

    private BigDecimal goodsPrice;

    private String goodsAttr;

    private Integer sendNumber;

    private Integer isReal;

    private String extensionCode;

    private Integer parentId;

    private Integer isGift;

    private Integer modelAttr;

    private String goodsAttrId;

    private Integer ruId;

    private BigDecimal shoppingFee;

    private Integer warehouseId;

    private Integer areaId;

    private Integer areaCity;

    private Integer isSingle;

    private Integer freight;

    private Integer tid;

    private BigDecimal shippingFee;

    /**
     * 分销佣金百分比
     */
    private BigDecimal drpMoney;

    /**
     * 订单商品是否参与分销
     */
    private Integer isDistribution;

    private String commissionRate;

    /**
     * 用户选择的当前商品的分期期数 -1:不分期
     */
    private Integer stagesQishu;

    /**
     * 商品规格货号
     */
    private String productSn;

    /**
     * 正品保证
     */
    private Integer isReality;

    /**
     * 包退服务
     */
    private Integer isReturn;

    /**
     * 闪速配送
     */
    private Integer isFast;

    /**
     * 校验直通|0否|1是
     */
    private Integer ifPass;

    /**
     * 备注
     */
    private String remarks;

    private static final long serialVersionUID = 1L;


    public Integer getRecId() {
        return recId;
    }

    public void setRecId(Integer recId) {
        this.recId = recId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCartRecid() {
        return cartRecid;
    }

    public void setCartRecid(String cartRecid) {
        this.cartRecid = cartRecid;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsSn() {
        return goodsSn;
    }

    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(Integer goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsAttr() {
        return goodsAttr;
    }

    public void setGoodsAttr(String goodsAttr) {
        this.goodsAttr = goodsAttr;
    }

    public Integer getSendNumber() {
        return sendNumber;
    }

    public void setSendNumber(Integer sendNumber) {
        this.sendNumber = sendNumber;
    }

    public Integer getIsReal() {
        return isReal;
    }

    public void setIsReal(Integer isReal) {
        this.isReal = isReal;
    }

    public String getExtensionCode() {
        return extensionCode;
    }

    public void setExtensionCode(String extensionCode) {
        this.extensionCode = extensionCode;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getIsGift() {
        return isGift;
    }

    public void setIsGift(Integer isGift) {
        this.isGift = isGift;
    }

    public Integer getModelAttr() {
        return modelAttr;
    }

    public void setModelAttr(Integer modelAttr) {
        this.modelAttr = modelAttr;
    }

    public String getGoodsAttrId() {
        return goodsAttrId;
    }

    public void setGoodsAttrId(String goodsAttrId) {
        this.goodsAttrId = goodsAttrId;
    }

    public Integer getRuId() {
        return ruId;
    }

    public void setRuId(Integer ruId) {
        this.ruId = ruId;
    }

    public BigDecimal getShoppingFee() {
        return shoppingFee;
    }

    public void setShoppingFee(BigDecimal shoppingFee) {
        this.shoppingFee = shoppingFee;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getAreaCity() {
        return areaCity;
    }

    public void setAreaCity(Integer areaCity) {
        this.areaCity = areaCity;
    }

    public Integer getIsSingle() {
        return isSingle;
    }

    public void setIsSingle(Integer isSingle) {
        this.isSingle = isSingle;
    }

    public Integer getFreight() {
        return freight;
    }

    public void setFreight(Integer freight) {
        this.freight = freight;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public BigDecimal getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(BigDecimal shippingFee) {
        this.shippingFee = shippingFee;
    }

    public BigDecimal getDrpMoney() {
        return drpMoney;
    }

    public void setDrpMoney(BigDecimal drpMoney) {
        this.drpMoney = drpMoney;
    }

    public Integer getIsDistribution() {
        return isDistribution;
    }

    public void setIsDistribution(Integer isDistribution) {
        this.isDistribution = isDistribution;
    }

    public String getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(String commissionRate) {
        this.commissionRate = commissionRate;
    }

    public Integer getStagesQishu() {
        return stagesQishu;
    }

    public void setStagesQishu(Integer stagesQishu) {
        this.stagesQishu = stagesQishu;
    }

    public String getProductSn() {
        return productSn;
    }

    public void setProductSn(String productSn) {
        this.productSn = productSn;
    }

    public Integer getIsReality() {
        return isReality;
    }

    public void setIsReality(Integer isReality) {
        this.isReality = isReality;
    }

    public Integer getIsReturn() {
        return isReturn;
    }

    public void setIsReturn(Integer isReturn) {
        this.isReturn = isReturn;
    }

    public Integer getIsFast() {
        return isFast;
    }

    public void setIsFast(Integer isFast) {
        this.isFast = isFast;
    }

    public Integer getIfPass() {
        return ifPass;
    }

    public void setIfPass(Integer ifPass) {
        this.ifPass = ifPass;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}