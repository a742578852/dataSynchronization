package com.llmc.dataSynchronization.mapper;

import com.llmc.dataSynchronization.model.SalesOrder;
import org.apache.ibatis.annotations.Insert;

public interface SalesOrderMapper {

    @Insert("insert into dbo.tblSalesOrder (id,billdate,departmentCode,employeeID,companyCode,stockCode,receiveDate," +
            "createBy,lastUpdateBy,createTime,lastUpdateTime,statusId,periodYear,periodMonth,period,alrAccAmt,billNo," +
            "sCompanyID,workFlowNodeName,workFlowNode,tradeType,finishTime,CertificateNo,discount,currencyRate,totalAmount," +
            "totalTaxAmount,account,accountAmount,inVoiceType) values (#{id},#{billdate},#{departmentCode},#{employeeID}," +
            "#{companyCode},#{stockCode},#{receiveDate},#{createBy},#{lastUpdateBy},#{createTime},#{lastUpdateTime},#{statusId}," +
            "#{periodYear},#{periodMonth},#{period},#{alrAccAmt},#{billNo},#{sCompanyID},#{workFlowNodeName},#{workFlowNode}," +
            "#{tradeType},#{finishTime},#{certificate},#{discount},#{currencyRate},#{totalAmount},#{totalTaxAmount}," +
            "#{account},#{accountAmount},#{inVoiceType})")
    int insertSalesOrder(SalesOrder salesOrder);
}
