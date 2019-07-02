package com.boot.study.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.study.security.dao.RolePermissionDao;
import com.boot.study.security.entity.RolePermission;
import com.boot.study.security.service.RolePermissionService;
import org.springframework.stereotype.Service;

/**
 * @author sxy
 */
@Service
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionDao, RolePermission> implements RolePermissionService {

}