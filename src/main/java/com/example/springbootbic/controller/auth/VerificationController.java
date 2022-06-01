package com.example.springbootbic.controller.auth;

import com.example.springbootbic.util.RandomValidateCodeUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: VerificationController
 * @Description: 验证相关接口
 * @Author: CZJ
 * @Date: 2022/2/19
 */
@RestController
@RequestMapping("verify")
public class VerificationController {

    /**
     * 获取图形验证码
     */
    @GetMapping("/getGraphVerifyCode")
    public void getGraphVerifyCode(String uuid, HttpServletResponse response) throws IOException {
        System.out.println(uuid);
        String code = RandomValidateCodeUtil.getRandomCode(response);
        System.out.println(code);
    }

}
