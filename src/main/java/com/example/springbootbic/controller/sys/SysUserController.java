package com.example.springbootbic.controller.sys;

import com.example.springbootbic.common.Result;
import com.example.springbootbic.service.sys.SysUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName: SysUserController
 * @Description: 用户信息相关操作
 * @Author: CZJ
 * @Date: 2020/9/28
 */
@RestController
@RequestMapping("user")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    /**
     * 根据用户id获取用户信息
     * @param id            用户id
     * @return              对应的用户信息
     */
    @RequestMapping(value = "getUser", method = {RequestMethod.GET, RequestMethod.POST})
    public Result getUser(Long id) {
        return Result.success(sysUserService.getUser(id));
    }

}
