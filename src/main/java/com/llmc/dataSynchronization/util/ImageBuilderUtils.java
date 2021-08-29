package com.llmc.dataSynchronization.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageBuilderUtils {

    /**
     *  热敏打印机纸张大约宽度（4cm*6cm）
     */
    private static final int width = 1000;
    /**
     *  热敏打印机纸张大约高度（4cm*6cm）
     */
    private static final int height = 1350;

    /**
     *
     * @param code 编码
     * @param path 二维码存放路劲
     * @return 最新图片生成路径
     */
    public static String ImageBuilder(String tag,String name,String path,String company,String savePath) {
        // 图片上传后的路径
        //得到图片缓冲区
        FileInputStream fileInputStream = null;
        try {
            BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            File file = new File(path);
            if(!file.exists()){
                System.out.println("一维码存放地址错误");
            }
            fileInputStream = new FileInputStream(file);
            BufferedImage image2 = ImageIO.read(fileInputStream);
            //得到它的绘制环境(这张图片的笔)
            Graphics2D g2 = (Graphics2D) bi.getGraphics();
            g2.fillRect(0, 0, width, height);
            //设置颜色
            g2.setColor(Color.WHITE);
            // 将图片大小设置为大约4cm*4cm 具体根据纸张大小设定
            g2.drawImage(image2, 60, 700, 900, 300,null);
            g2.drawRect(0, 0, width - 1, height - 1);

            int x = 50;
            if (name.length() == 1){
                x = 450;
            }
            if (name.length() == 2){
                x = 400;
            }else if (name.length() == 3){
                x = 350;
            }else if (name.length() == 4){
                x = 300;
            }else if (name.length() == 5){
                x = 250;
            }else if (name.length() == 6){
                x = 200;
            }else if (name.length() == 7){
                x = 150;
            }else if (name.length() == 8){
                x = 100;
            }

            //设备名
            //设置字体:字体、字号、大小
            g2.setFont(new Font("黑体", Font.BOLD, 100));
            //设置背景颜色
            g2.setColor(Color.BLACK);
            //向图片上写字符串
            if (name.contains("m³")){
                name = name.replace("m³","立方米");
            }
            name = name.replace(" ","");
            g2.drawString(name, x, 650);

            System.out.println("-----------------------");

            //公司名
            g2.setFont(new Font("黑体", Font.BOLD, 120));
            //四位
            g2.drawString(company, 240, 350);

            System.out.println("公司名:"+company);

            //设备巡检卡
            g2.setFont(new Font("黑体", Font.BOLD, 120));
            g2.drawString("设备巡检卡", 190, 500);
            //位号
            g2.setFont(new Font("黑体", Font.ITALIC, 60));
            g2.drawString(tag, 400, 1060);
            System.out.println("位号："+tag);
            System.out.println("-----------------------");

            ImageIO.write(bi, "PNG", new FileOutputStream(savePath));
            return savePath;
        }catch (Exception e){
            System.out.println("生成图片错误,"+e);
        }finally {
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return savePath;
    }


    public static String ImageBuilderArea(String tag,String name,String path,String company,String savePath) {
        // 图片上传后的路径
        //得到图片缓冲区
        FileInputStream fileInputStream = null;
        try {
            BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            File file = new File(path);
            if(!file.exists()){
                System.out.println("一维码存放地址错误");
            }
            fileInputStream = new FileInputStream(file);
            BufferedImage image2 = ImageIO.read(fileInputStream);
            //得到它的绘制环境(这张图片的笔)
            Graphics2D g2 = (Graphics2D) bi.getGraphics();
            g2.fillRect(0, 0, width, height);
            //设置颜色
            g2.setColor(Color.WHITE);
            // 将图片大小设置为大约4cm*4cm 具体根据纸张大小设定
            g2.drawImage(image2, 60, 700, 900, 300,null);
            g2.drawRect(0, 0, width - 1, height - 1);

            int x = 50;
            if (name.length() == 1){
                x = 450;
            }
            if (name.length() == 2){
                x = 400;
            }else if (name.length() == 3){
                x = 350;
            }else if (name.length() == 4){
                x = 300;
            }else if (name.length() == 5){
                x = 250;
            }else if (name.length() == 6){
                x = 200;
            }else if (name.length() == 7){
                x = 150;
            }else if (name.length() == 8){
                x = 100;
            }

            //设备名
            //设置字体:字体、字号、大小
            g2.setFont(new Font("黑体", Font.BOLD, 100));
            //设置背景颜色
            g2.setColor(Color.BLACK);
            //向图片上写字符串
            if (name.contains("m³")){
                name = name.replace("m³","立方米");
            }
            name = name.replace(" ","");
            g2.drawString(name, x, 650);

            System.out.println("-----------------------");

            //公司名
            g2.setFont(new Font("黑体", Font.BOLD, 120));
            //四位
            g2.drawString(company, 240, 350);
            System.out.println("公司名:"+company);

            //设备巡检卡
            g2.setFont(new Font("黑体", Font.BOLD, 120));
            g2.drawString("区域巡检卡", 190, 500);
            //位号
            g2.setFont(new Font("黑体", Font.ITALIC, 60));
            g2.drawString(tag, 400, 1060);
            System.out.println("位号："+tag);
            System.out.println("-----------------------");

            ImageIO.write(bi, "PNG", new FileOutputStream(savePath));
            return savePath;
        }catch (Exception e){
            System.out.println("生成图片错误,"+e);
        }finally {
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return savePath;
    }
}
