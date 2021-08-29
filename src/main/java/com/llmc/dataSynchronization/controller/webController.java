package com.llmc.dataSynchronization.controller;

import com.google.zxing.WriterException;
import com.llmc.dataSynchronization.mapper.StockGoodsMapper;
import com.llmc.dataSynchronization.mapper.WearhouseMapper;
import com.llmc.dataSynchronization.model.StockGoods;
import com.llmc.dataSynchronization.model.Wearhouse;
import com.llmc.dataSynchronization.util.ExcelUtil;
import com.llmc.dataSynchronization.util.ImageBuilderUtils;
import com.llmc.dataSynchronization.util.JbarcodeUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("web")
public class webController {
    @Autowired
    WearhouseMapper wearhouseMapper;
    @Autowired
    StockGoodsMapper stockGoodsMapper;


    @RequestMapping("goLogin")
    public String goLogin(){

        return "login";
    }

    @RequestMapping("toLogin")
    public String toLogin(String name,String password,Model model){

        if (name.equals("admin") && password.equals("123456")){
            return "ll/user";
        }else {
            model.addAttribute("message","账号或密码错误");
            return "login";
        }
    }

    @RequestMapping("toExcelPage")
    public String toExcelPage(){
        return "android/index";
    }

    @RequestMapping("toAreaExcelPage")
    public String toAreaExcelPage(){
        return "android/areaIndex";
    }

    //上传excel附件解析进行图片生成
    @PostMapping("toExcelImg")
    public String toExcelImg(String excelPath,String company) throws IOException, InvalidFormatException, WriterException {
        List<Map<String,String>> excelList = (List<Map<String, String>>) ExcelUtil.obtainExcel(excelPath);
        //生成所有一维码
        for (Map<String,String> map:excelList){
            //生成文件名
            String imgName = map.get("tag");
            if (imgName.contains("/")){
                imgName = imgName.replace("/","-");
            }
            if (imgName.contains("'\'")){
                imgName = imgName.replace("'\'","-");
            }
            if (imgName.contains("~")){
                imgName = imgName.replace("~","-");
            }
            String name = map.get("name");
            if (name.contains("/")){
                name = name.replace("/","-");
            }
            String fileName = company+"-"+name+"-"+imgName+".png";

            System.out.println("------文件名-----"+fileName);
            //文件路径
            String filePath = "D:\\code\\"+company+"(设备)";
            //生成一维码
            File file = new File(filePath);
            if (!file.exists()) {
                file.mkdirs();
            }
            JbarcodeUtil.encode(map.get("tag"),filePath+"\\"+fileName,135,40,1);
            //生成对应图片
            String imgPath = "D:\\imgCode\\"+company+"(设备)"+"\\"+fileName;
            File file1 = new File("D:\\imgCode\\"+company+"(设备)");
            if (!file1.exists()) {
                file1.mkdirs();
            }
            ImageBuilderUtils.ImageBuilder(map.get("tag"),map.get("name").trim(),filePath+"\\"+fileName,company,imgPath);
            System.out.println(fileName);

        }
        return "ll/user";

    }


    //上传excel附件解析进行图片生成
    @PostMapping("toExcelAreaImg")
    public String toExcelAreaImg(String excelPath,String company) throws IOException, InvalidFormatException, WriterException {
        List<Map<String,String>> excelList = (List<Map<String, String>>) ExcelUtil.areaExcel(excelPath);
        //生成所有一维码
        for (Map<String,String> map:excelList){
            //生成文件名
            String imgName = map.get("tag");
            if (imgName.contains("/")){
                imgName = imgName.replace("/","-");
            }
            if (imgName.contains("'\'")){
                imgName = imgName.replace("'\'","-");
            }
            if (imgName.contains("~")){
                imgName = imgName.replace("~","-");
            }
            String name = map.get("name");
            if (name.contains("/")){
                name = name.replace("/","-");
            }
            String fileName = company+"-"+name+"-"+imgName+".png";
            System.out.println("------文件名-----"+fileName);
            //文件路径
            String filePath = "D:\\code\\"+company+"(区域)";
            //生成一维码
            File file = new File(filePath);
            if (!file.exists()) {
                file.mkdirs();
            }
            JbarcodeUtil.encode(map.get("tag"),filePath+"\\"+fileName,135,40,1);
            //生成对应图片
            String imgPath = "D:\\imgCode\\"+company+"(区域)"+"\\"+fileName;
            File file1 = new File("D:\\imgCode\\"+company+"(区域)");
            if (!file1.exists()) {
                file1.mkdirs();
            }
            ImageBuilderUtils.ImageBuilderArea(map.get("tag"),map.get("name").trim(),filePath+"\\"+fileName,company,imgPath);
            System.out.println(fileName);

        }
        return "ll/user";

    }




    @RequestMapping("goStock")
    public String goStock(String goodsSn, Model model){
        //获取全部仓库
        List<Wearhouse> wearhouses = wearhouseMapper.queryWhole();

        List<StockGoods> stockGoodsList = stockGoodsMapper.queryStock(goodsSn);

        model.addAttribute("stockGoods",stockGoodsList);
        model.addAttribute("wearhouses",wearhouses);
        model.addAttribute("goodsSn",goodsSn);

        return "ll/orderInfo";
    }

    @RequestMapping("goStockUpdate")
    public String goStockUpdate(int stockId,Model model){

        StockGoods stockGoods = stockGoodsMapper.queryStockGoodsById(stockId);

        model.addAttribute("stock",stockGoods);

        return "ll/couponSend";
    }

    @RequestMapping("toStock")
    public String toStock(int stockId,int number){


        stockGoodsMapper.updateStockGoodsById(stockId,number);

        return "redirect:/web/goStock";
    }

}
