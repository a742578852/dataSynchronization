package com.llmc.dataSynchronization.mapper;

import com.llmc.dataSynchronization.model.StockGoods;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface StockGoodsMapper {

    /**
     * 获取商品库存信息
     * @param goodsId
     * @return
     */
    @Select("select coalesce(sum(goods_number),0) from dsc_stocks_goods a" +
            "left join dsc_wearhouse b on a.dsc_wearhouseId = b.dsc_wearhouseId" +
            " where a.goods_id = #{goodsId} and b.parent_id = 0")
    int queryStockGoodsByGoodsId(int goodsId);

    /**
     * 获取离我最近仓库的商品库存信息
     * @param goodsId
     * @return
     */
    @Select("select goods_number from dsc_stocks_goods where goods_id = #{goodsId} and dsc_wearhouseId = #{wareHouseId}")
    Integer queryLimitGoodsByGoodsId(@Param("goodsId") int goodsId, @Param("wareHouseId") int wareHouseId);


    @Select("select goods_number from dsc_stocks_goods where goods_id = #{goodsId} and dsc_wearhouseId = #{wareHouseId}")
    Integer queryGoodsStockPromByParms(@Param("goodsId") int goodsId,@Param("wareHouseId") int wareHouseId);


    @Select("select * from dsc_stocks_goods where goods_id = #{goodsId} and dsc_wearhouseId = #{wareHouseId}")
    StockGoods queryStockGoodsByGoodsIdAndWearId(@Param("goodsId") int goodsId,@Param("wareHouseId") int wareHouseId);


    //减库存
    @Update("update dsc_stocks_goods set goods_number = (goods_number - #{number}) where goods_id = #{goodsId} and dsc_wearhouseId = #{wearHouseId}")
    int updateStockGoods(@Param("goodsId") int goodsId,@Param("wearHouseId") int wearHouseId,@Param("number") int number);

    @Select("select * from dsc_stocks_goods where goods_sn = #{goodsSn}")
    List<StockGoods> queryStock(String goodsSn);

    @Select("select * from dsc_stocks_goods where stocksgoodsId = #{id}")
    StockGoods queryStockGoodsById(int id);

    @Update("update dsc_stocks_goods set goods_number = #{number} where stocksgoodsId = #{id}")
    int updateStockGoodsById(@Param("id") int id,@Param("number") int number);

}
