package com.boot.study.security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boot.study.security.entity.SysRole;

import java.util.List;

/**
 * @author Xingyu Sun
 * @date 2019/6/25 17:18
 */
public interface RoleService extends IService<SysRole> {
    /**
     * findAll
     * @return
     */
    List<SysRole> findAll();
}
