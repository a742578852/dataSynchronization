package com.llmc.dataSynchronization.model;

import java.util.Date;

public class StockGoods {

    private int stocksgoodsId;

    private int IsValid;

    private int goodsId;

    private String goodsSn;

    private String goodsName;

    private int goodsNumber;

    private String wId;


    public String getwId() {
        return wId;
    }

    public void setwId(String wId) {
        this.wId = wId;
    }

    public int getStocksgoodsId() {
        return stocksgoodsId;
    }

    public void setStocksgoodsId(int stocksgoodsId) {
        this.stocksgoodsId = stocksgoodsId;
    }

    public int getIsValid() {
        return IsValid;
    }

    public void setIsValid(int isValid) {
        IsValid = isValid;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsSn() {
        return goodsSn;
    }

    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(int goodsNumber) {
        this.goodsNumber = goodsNumber;
    }
}
