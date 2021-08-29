package com.llmc.dataSynchronization.controller;




import com.alibaba.fastjson.JSONObject;
import com.llmc.dataSynchronization.model.OrderGoods;
import com.llmc.dataSynchronization.service.WareService;
import com.llmc.dataSynchronization.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("api/warehouse")
public class WarehouseController {
    @Autowired
    WareService wareService;

    /**
     * 获取是否在配送范围 返回true false
     * @param lng
     * @param lat
     * @return
     */
    @RequestMapping("getDisScopFlg")
    public Result getDisScopFlg(String lng,String lat){

        return wareService.getDisScopFlg(lng,lat);
    }


    /**
     * 获取距离最近的仓库
     * @param lng
     * @param lat
     * @return
     */
    @RequestMapping("getLatelyWearhouse")
    public Result getLatelyWearhouse(String lng,String lat){

        return wareService.getLatelyWearhouse(lng,lat);
    }

//    /**
//     * 获取距离最近的成品仓库
//     * @param lng
//     * @param lat
//     * @return
//     */
//    @RequestMapping("getLatelyWearhouse")
//    public Result getLatelyChenWearhouse(String lng,String lat){
//
//        return wareService.getLatelyWearhouse(lng,lat);
//    }


    /**
     * 获取商品库存
     * @return
     */
    @RequestMapping("getGoodsStock")
    public Result getGoodsStock(int goodsId){

        return wareService.getGoodsStock((goodsId));
    }

    /**
     * 获取最近仓库商品库存
     * @return
     */
    @RequestMapping("getLimitGoodsStock")
    public Result getLimitGoodsStock(String lng,String lat,int goodsId){

    return wareService.getLimitGoodsStock(lng,lat,goodsId);
    }

    /**
     * 获取距离最近的仓库的促销仓商品库存
     * @param lng
     * @param lat
     * @param goodsId
     * @return
     */
    @RequestMapping("getLimitActivityGoodsStock")
    public Result getLimitActivityGoodsStock(String lng,String lat,int goodsId){

        return wareService.getLimitActivityGoodsStock(lng,lat,goodsId);

    }

    /**
     * 减库存
     * @param
     * @return
     */
    @RequestMapping("mulStock")
    public Result mulStock(@RequestBody JSONObject jsonObject){


        Map<String, Object> jsonMap = JSONObject.toJavaObject(jsonObject, Map.class);
        List<OrderGoods> orderGoodsList = (List<OrderGoods>) jsonMap.get("orderGoodsList");
        int wearHouseId = (int)jsonMap.get("wearHouseId");
        return wareService.mulStock(orderGoodsList,wearHouseId);

    }


    @RequestMapping("test")
    public String test(){

        return "ttttttt";
    }

}
