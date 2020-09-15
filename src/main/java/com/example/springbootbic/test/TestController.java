package com.example.springbootbic.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName : TestController
 * @Description : 用于简单的接口测试
 * @Author : CZJ
 * @Date: 2020/9/15
 */
@RestController
@RequestMapping("test")
public class TestController {

    /**
     * 用于简单测试
     * @return          测试结果
     */
    @RequestMapping(value = "test", method = {RequestMethod.POST, RequestMethod.GET})
    public String test() {
        return "successful test!";
    }

}
