//package com.llmc.dataSynchronization.scheduled;
//
//
//import com.llmc.dataSynchronization.mapper.OrderSqlserverMapper;
//import com.llmc.dataSynchronization.mapper.SalesOrderDetMapper;
//import com.llmc.dataSynchronization.mapper.SalesOrderMapper;
//import com.llmc.dataSynchronization.model.OrderSqlserver;
//import com.llmc.dataSynchronization.model.SalesOrder;
//import com.llmc.dataSynchronization.model.SalesOrderDet;
//import com.llmc.dataSynchronization.util.Arith;
//import com.llmc.dataSynchronization.util.DateUtils;
//import com.llmc.dataSynchronization.util.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.time.LocalDateTime;
//import java.util.Calendar;
//import java.util.List;
//import java.util.Map;
//
//@EnableScheduling
//@Configuration      //1.主要用于标记配置类，兼备Component的效果。
//  // 2.开启定时任务
//public class Sch {
//    @Autowired
//    OrderSqlserverMapper orderSqlserverMapper;
//    @Autowired
//    SalesOrderDetMapper salesOrderDetMapper;
//    @Autowired
//    SalesOrderMapper salesOrderMapper;
//
//
//    @Transactional(rollbackFor = Exception.class)
//    //3.添加定时任务
//    //@org.springframework.scheduling.annotation.Scheduled(cron = "0 59 23 * * ?")
//    @org.springframework.scheduling.annotation.Scheduled(cron = "0 59 23 1/1 * ? ")
//    //或直接指定时间间隔，例如：5秒
//    //@Scheduled(fixedRate=5000)
//    public void updateCate() {
//
//        List<Map> map = salesOrderDetMapper.queryDet();
//        //获取当天所有订单
//        List<OrderSqlserver> orderSqlservers = orderSqlserverMapper.getOrderSqlserver();
//        //总金额
//        double totalPrice = 0;
//        //获取销货单id
//        String orderId = StringUtils.getUuid().substring(0,29);
//
//        for (OrderSqlserver orderSqlserver:orderSqlservers){
//            double amount = Arith.mul(orderSqlserver.getGoodsNumber(),orderSqlserver.getGoodsPrice());
//            totalPrice = Arith.add(totalPrice,amount);
//        }
//
//        SalesOrder salesOrder = new SalesOrder();
//        salesOrder.setId(orderId);
//        salesOrder.setBilldate(DateUtils.getDay());
//        salesOrder.setDepartmentCode("00101");
//        salesOrder.setEmployeeID("1");
//        salesOrder.setCompanyCode("00003");
//        salesOrder.setStockCode("0000100001");
//        salesOrder.setReceiveDate(DateUtils.getDay());
//        salesOrder.setCreateBy("1");
//        salesOrder.setLastUpdateBy("1");
//        salesOrder.setCreateTime(DateUtils.getTime());
//        salesOrder.setLastUpdateTime(DateUtils.getTime());
//        salesOrder.setStatusId("0");
//        salesOrder.setPeriodYear(Calendar.getInstance().get(Calendar.YEAR));
//        salesOrder.setPeriodMonth(Calendar.getInstance().get(Calendar.MONTH));
//        salesOrder.setPeriod(Calendar.getInstance().get(Calendar.MONTH));
//        salesOrder.setAlrAccAmt(totalPrice);
//
//        String billNo = "SO"+DateUtils.getDays()+StringUtils.getUuid().substring(0,2);
//        salesOrder.setBillNo(billNo);
//        salesOrder.setsCompanyID("00001");
//        salesOrder.setWorkFlowNodeName("finish");
//        salesOrder.setWorkFlowNode("-1");
//        salesOrder.setTradeType("CreditSale");
//        salesOrder.setFinishTime(DateUtils.getTime());
//        salesOrder.setCertificate(orderId);
//        salesOrder.setDiscount(10);
//        salesOrder.setCurrencyRate(1);
//        salesOrder.setTotalAmount(totalPrice);
//        salesOrder.setTotalTaxAmount(totalPrice);
//        salesOrder.setAccount(1001);
//        salesOrder.setAccountAmount(totalPrice);
//        salesOrder.setInVoiceType(3);
//        salesOrderMapper.insertSalesOrder(salesOrder);
//
//        for (OrderSqlserver orderSqlserver:orderSqlservers){
//            SalesOrderDet salesOrderDet = new SalesOrderDet();
//            salesOrderDet.setId(StringUtils.getUuid().substring(0,29));
//            salesOrderDet.setfRef(orderId);
//            salesOrderDet.setGoodsCode(orderSqlserver.getClassCode());
//            salesOrderDet.setEmployeeId("1");
//            salesOrderDet.setDepartmentCode("00101");
//            salesOrderDet.setNotOutQty(orderSqlserver.getGoodsNumber());
//            salesOrderDet.setStockCode("0000100001");
//            salesOrderDet.setFinishStatus(0);
//            salesOrderDet.setsCompanyID("00001");
//            salesOrderDet.setNeedReceiveAmt(Arith.mul(orderSqlserver.getGoodsNumber(),orderSqlserver.getGoodsPrice()));
//            salesOrderDet.setNotPayQty(orderSqlserver.getGoodsNumber());
//            salesOrderDet.setQty(orderSqlserver.getGoodsNumber());
//            salesOrderDet.setPrice(orderSqlserver.getGoodsPrice());
//            salesOrderDet.setAmount(salesOrderDet.getNeedReceiveAmt());
//            salesOrderDet.setDiscount(100);
//            salesOrderDet.setDisPrice(orderSqlserver.getGoodsPrice());
//            salesOrderDet.setDisBackAmt(salesOrderDet.getNeedReceiveAmt());
//            salesOrderDet.setTaxPrice(orderSqlserver.getGoodsPrice());
//            salesOrderDet.setTaxAmount(Arith.mul(orderSqlserver.getGoodsNumber(),orderSqlserver.getGoodsPrice()));
//
//            salesOrderDetMapper.insertSalesOrderDet(salesOrderDet);
//
//        }
//
//
//        System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
//    }
//
//}
