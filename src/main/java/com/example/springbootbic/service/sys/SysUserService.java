package com.example.springbootbic.service.sys;

import com.example.springbootbic.entity.sys.SysUser;

/**
 * @ClassName : SysUserService
 * @Description : 用户信息表相关操作
 * @Author : CZJ
 * @Date: 2020/9/28
 */
public interface SysUserService {

    /**
     * 通过id获取用户信息
     * @param id            用户id
     * @return              对应的用户数据
     */
    SysUser getUser(Long id);

}
