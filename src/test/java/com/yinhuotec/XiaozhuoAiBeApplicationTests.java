package com.yinhuotec;

import net.sourceforge.tess4j.Tesseract;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest
class XiaozhuoAiBeApplicationTests {

    @Test
    public void contextLoads() {
        File imageFile = new File("D:\\ocr测试图\\test2.png");
        Tesseract instance = new Tesseract();
        instance.setLanguage("chi_sim");
        instance.setDatapath("D:\\Developers\\ocr\\tessdata");
        try {
            String result = instance.doOCR(imageFile);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
