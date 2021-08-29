package com.llmc.dataSynchronization.mapper;

import com.llmc.dataSynchronization.model.OrderSqlserver;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface OrderSqlserverMapper {

    @Select("select a.*,b.classCode  from dbo.tblGoods b\n" +
            "\n" +
            "right join \n" +
            "(\n" +
            "SELECT *from openquery(LLDB,'select * from v_order_sqlserver where  to_days(ordertime) = to_days(now())')\n" +
            ") a \n" +
            "\n" +
            "\n" +
            "on a.goods_sn = b.GoodsNumber")
    List<OrderSqlserver> getOrderSqlserver();


}
