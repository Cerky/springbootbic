package com.example.test;

import com.example.springbootbic.SpringbootbicApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName: ExcelImputTest
 * @Description: excel导入测试
 * @Author: CZJ
 * @Date: 2021/1/20
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
@SpringBootTest(classes = SpringbootbicApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ExcelImportTest {

    @Test
    public void testImport(){
        System.out.println("eeeeeeeeeeeeeeeeeeee");
    }

}
