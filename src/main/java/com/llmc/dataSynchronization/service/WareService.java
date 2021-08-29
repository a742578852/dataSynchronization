package com.llmc.dataSynchronization.service;

import com.llmc.dataSynchronization.model.OrderGoods;
import com.llmc.dataSynchronization.util.Result;

import java.util.List;
import java.util.Map;

public interface WareService {


    Result getDisScopFlg(String lng, String lat);


    Result getLatelyWearhouse(String lng,String lat);

    Result getLatelyChenWearhouse(String lng,String lat);


    Result getGoodsStock(int goodsId);

    /**
     * 获取距离最近的仓库商品库存
     * @return
     */
    Result getLimitGoodsStock(String lng,String lat,int goodsId);


    Result getLimitActivityGoodsStock(String lng,String lat,int goodsId);


    /**
     * 出库减库存
     * @param
     * @param wearHouseId
     * @return
     */
    Result mulStock(List<OrderGoods> goodsList, int wearHouseId);



}
