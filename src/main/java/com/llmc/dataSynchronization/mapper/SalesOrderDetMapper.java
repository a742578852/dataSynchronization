package com.llmc.dataSynchronization.mapper;

import com.llmc.dataSynchronization.model.SalesOrderDet;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface SalesOrderDetMapper {


    @Insert("insert into dbo.tblSalesOrderDet (id,f_ref,GoodsCode,EmployeeId,DepartmentCode,NotOutQty," +
            "StockCode,FinishStatus,SCompanyID,NeedReceiveAmt,NotPayQty,Qty,Price,Amount,Discount,DisPrice," +
            "DisBackAmt,TaxPrice,TaxAmount) values (#{id},#{fRef},#{goodsCode},#{employeeId},#{departmentCode}," +
            "#{notOutQty},#{stockCode},#{finishStatus},#{sCompanyID},#{needReceiveAmt},#{notPayQty},#{qty}," +
            "#{price},#{amount},#{discount},#{disPrice},#{disBackAmt},#{taxPrice},#{taxAmount})")
    int insertSalesOrderDet(SalesOrderDet salesOrderDet);
    @Select("select * from dbo.tblSalesOrderDet")
    List<Map> queryDet();
}
