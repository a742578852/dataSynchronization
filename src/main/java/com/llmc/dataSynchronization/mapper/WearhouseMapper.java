package com.llmc.dataSynchronization.mapper;

import com.llmc.dataSynchronization.model.Wearhouse;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface WearhouseMapper {
    /**
     * 查询获取所有仓库
     * @return
     */
    @Select("select * from dsc_wearhouse")
    List<Wearhouse> queryWhole();

    @Select("select * from dsc_wearhouse where parent_id = 0")
    List<Wearhouse> queryAll();

    @Select("select * from dsc_wearhouse where type = 1")
    List<Wearhouse> querychenAll();

    @Select("select * from dsc_wearhouse where type = 2")
    List<Wearhouse> queryCuAll();

    @Select("select * from dsc_wearhouse where type = #{type} and parent_id = #{parentId}")
    Wearhouse queryWearhouse(@Param("parentId") int parentId, @Param("type") int type);


}
