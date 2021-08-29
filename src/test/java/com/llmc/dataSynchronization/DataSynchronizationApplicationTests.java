package com.llmc.dataSynchronization;

import com.google.zxing.WriterException;
import com.llmc.dataSynchronization.util.ImageBuilderUtils;
import com.llmc.dataSynchronization.util.JbarcodeUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class DataSynchronizationApplicationTests {

    @Test
    void contextLoads() throws IOException, WriterException, InvalidFormatException {
        ImageBuilderUtils.ImageBuilder("w12","加热泵加R加热加","C:\\Users\\86188\\Desktop\\cnaidc.png","恒基达鑫","C:\\Users\\86188\\Desktop\\1.png");
        //JbarcodeUtil.encode("C001氮气增压机","C:\\Users\\86188\\Desktop\\cnaidc.png",135,40,1);

    }

}
