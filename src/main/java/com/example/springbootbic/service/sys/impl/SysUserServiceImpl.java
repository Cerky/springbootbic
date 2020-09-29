package com.example.springbootbic.service.sys.impl;

import com.example.springbootbic.entity.sys.SysUser;
import com.example.springbootbic.mapper.sys.SysUserMapper;
import com.example.springbootbic.service.sys.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName: SysUserServiceImpl
 * @Description: 用户信息表相关操作
 * @Author: CZJ
 * @Date: 2020/9/28
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser getUser(Long id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }



}
