package com.boot.study.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.study.security.dao.RoleDao;
import com.boot.study.security.entity.SysRole;
import com.boot.study.security.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sxy
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleDao, SysRole> implements RoleService {

    @Override
    public List<SysRole> findAll() {
        return getBaseMapper().findAll();
    }
}