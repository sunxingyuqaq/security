package com.boot.study.security.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.study.security.entity.SysRole;

import java.util.List;

/**
 * @author Xingyu Sun
 * @date 2019/6/25 17:18
 */
public interface RoleDao extends BaseMapper<SysRole> {

    /**
     * findAll
     * @return l
     */
    List<SysRole> findAll();
}
