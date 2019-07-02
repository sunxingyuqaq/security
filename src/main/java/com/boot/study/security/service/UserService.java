package com.boot.study.security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boot.study.security.entity.SysUser;
import com.boot.study.security.model.RestResult;

import java.util.List;

/**
 * @author sxy
 */
public interface UserService extends IService<SysUser> {

    void print();

    List<SysUser> findAll();

    RestResult login(String username, String password);
}