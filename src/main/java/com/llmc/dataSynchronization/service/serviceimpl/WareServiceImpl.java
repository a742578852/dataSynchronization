package com.llmc.dataSynchronization.service.serviceimpl;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.llmc.dataSynchronization.config.DicConfig;
import com.llmc.dataSynchronization.mapper.StockGoodsMapper;
import com.llmc.dataSynchronization.mapper.WearhouseMapper;
import com.llmc.dataSynchronization.model.OrderGoods;
import com.llmc.dataSynchronization.model.StockGoods;
import com.llmc.dataSynchronization.model.Wearhouse;
import com.llmc.dataSynchronization.service.WareService;
import com.llmc.dataSynchronization.util.MapDistance;
import com.llmc.dataSynchronization.util.Result;
import com.llmc.dataSynchronization.util.StringUtils;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class WareServiceImpl implements WareService {
    @Autowired
    WearhouseMapper wearhouseMapper;
    @Autowired
    StockGoodsMapper stockGoodsMapper;

    @Override
    public Result getDisScopFlg(String lng, String lat) {

        //获取所有仓库
        List<Wearhouse> wearhouses = wearhouseMapper.queryAll();

        boolean flg = false;
        String distence;
        for (Wearhouse wearhouse:wearhouses){
            distence = MapDistance.getDistance(lat,lng,wearhouse.getLatitude(),wearhouse.getLongitude());
            if (null == lat || null == lng){
                continue;
            }
            if (DicConfig.SHIPPINGSCOPE>Integer.parseInt(distence)){
                flg = true;
                break;
            }

        }

        return new Result(200,true,"获取成功",flg);
    }

    @Override
    public Result getLatelyWearhouse(String lng, String lat) {
        //获取所有仓库
        List<Wearhouse> wearhouses = wearhouseMapper.queryAll();
        Wearhouse wearhouse = new Wearhouse();
        String distence = "";

        for (Wearhouse wearhouse1:wearhouses){
            String dis = MapDistance.getDistance(lat,lng,wearhouse1.getLatitude(),wearhouse1.getLongitude());
            if (StringUtils.isEmpity(distence)){
                distence = dis;
                wearhouse = wearhouse1;
            }else {
                if (Integer.parseInt(dis)<Integer.parseInt(distence)){
                    distence = dis;
                    wearhouse = wearhouse1;
                }
            }

        }

        //查询成品仓

        Wearhouse prW = wearhouseMapper.queryWearhouse(wearhouse.getDscWearhouseId(),1);

        //查询促销仓
        Wearhouse acW = wearhouseMapper.queryWearhouse(wearhouse.getDscWearhouseId(),2);

        wearhouse.setAcWearhouse(acW);

        wearhouse.setProductWearhouse(prW);

        return new Result(200,true,"获取成功",wearhouse);
    }

    @Override
    public Result getLatelyChenWearhouse(String lng, String lat) {
        return null;
    }

    @Override
    public Result getGoodsStock(int goodsId) {
        int count = stockGoodsMapper.queryStockGoodsByGoodsId(goodsId);

        return new Result(200,true,"获取成功",count);
    }

    @Override
    public Result getLimitGoodsStock(String lng,String lat,int goodsId) {

        //获取所有仓库
        List<Wearhouse> wearhouses = wearhouseMapper.querychenAll();
        Wearhouse wearhouse = new Wearhouse();
        String distence = "";

        for (Wearhouse wearhouse1:wearhouses){
            String dis = MapDistance.getDistance(lat,lng,wearhouse1.getLatitude(),wearhouse1.getLongitude());
            if (StringUtils.isEmpity(distence)){
                distence = dis;
                wearhouse = wearhouse1;
            }else {
                if (Integer.parseInt(dis)<Integer.parseInt(distence)){
                    distence = dis;
                    wearhouse = wearhouse1;
                }
            }

        }

        Integer count = stockGoodsMapper.queryLimitGoodsByGoodsId(goodsId,wearhouse.getDscWearhouseId());
        if (count == null){
            count = 0;
        }

        return new Result(200,true,"获取成功",count);
    }

    @Override
    public Result getLimitActivityGoodsStock(String lng, String lat, int goodsId) {

        //获取所有仓库
        List<Wearhouse> wearhouses = wearhouseMapper.queryCuAll();
        Wearhouse wearhouse = new Wearhouse();
        String distence = "";

        for (Wearhouse wearhouse1:wearhouses){
            String dis = MapDistance.getDistance(lat,lng,wearhouse1.getLatitude(),wearhouse1.getLongitude());
            if (StringUtils.isEmpity(distence)){
                distence = dis;
                wearhouse = wearhouse1;
            }else {
                if (Integer.parseInt(dis)<Integer.parseInt(distence)){
                    distence = dis;
                    wearhouse = wearhouse1;
                }
            }

        }

       Integer count = stockGoodsMapper.queryLimitGoodsByGoodsId(goodsId,wearhouse.getDscWearhouseId());

        if (count == null){
            count = 0;
        }


        return new Result(200,true,count);
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public Result mulStock(List<OrderGoods> goodsList, int wearHouseId) {
        //成品仓
        Wearhouse chengWear = wearhouseMapper.queryWearhouse(wearHouseId,1);

        //促销仓
        Wearhouse cuWear = wearhouseMapper.queryWearhouse(wearHouseId,2);

        List<OrderGoods> orderGoodsList = new Gson().fromJson(new Gson().toJson(goodsList), new TypeToken<List<OrderGoods>>(){}.getType());
        try {
            for (OrderGoods orderGoods:orderGoodsList){
                //减成品仓
                if (StringUtils.isEmpity(orderGoods.getExtensionCode())
                        && stockGoodsMapper.queryStockGoodsByGoodsIdAndWearId(orderGoods.getGoodsId(),chengWear.getDscWearhouseId()).getGoodsNumber()>0){

                    stockGoodsMapper.updateStockGoods(orderGoods.getGoodsId(),chengWear.getDscWearhouseId(),orderGoods.getGoodsNumber());


                    //减促销仓
                }else if (stockGoodsMapper.queryStockGoodsByGoodsIdAndWearId(orderGoods.getGoodsId(),cuWear.getDscWearhouseId()).getGoodsNumber()>0){
                    stockGoodsMapper.updateStockGoods(orderGoods.getGoodsId(),cuWear.getDscWearhouseId(),orderGoods.getGoodsNumber());

                }

            }
        }catch (Exception e){
            return new Result(204,true,"出库失败",0);
        }


        return new Result(200,true,"出库成功",1);
    }


}
