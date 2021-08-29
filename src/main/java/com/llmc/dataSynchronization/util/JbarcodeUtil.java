package com.llmc.dataSynchronization.util;




import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class JbarcodeUtil {

    //输出的图片格式
    private static final String FORMAT="PNG";

    /**
     * 生成条形码<br>
     * <b>注意</b>条形码的宽度不能等于图片的宽度，否则解析不出来,如果解析不出来，请加大offset的值
     * @param contents 内容
     * @param dest 条形码图片地址
     * @param width 宽度
     * @param height 高度
     * @param offset 偏移量
     * @throws WriterException
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void encode(String contents,String dest,int width,int height,int offset)

            throws WriterException, FileNotFoundException, IOException {
        contents=new String(contents.getBytes("UTF-8"));

        BitMatrix matrix=new MultiFormatWriter().encode(contents, BarcodeFormat.CODE_128,

                width-offset, height);
        MatrixToImageWriter.writeToStream(matrix, FORMAT, new FileOutputStream(new File(dest)));
    }



}
