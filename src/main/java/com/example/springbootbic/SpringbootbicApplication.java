package com.example.springbootbic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName : SpringbootbicApplication
 * @Description : 项目启动类
 * @Author : CZJ
 * @Date: 2020/9/15
 */
@MapperScan("com.example.springbootbic.mapper")
@SpringBootApplication
public class SpringbootbicApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootbicApplication.class, args);
    }

}
