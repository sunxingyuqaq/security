package com.boot.study.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.study.security.dao.PermissionDao;
import com.boot.study.security.entity.SysPermission;
import com.boot.study.security.service.PermissionService;
import org.springframework.stereotype.Service;

/**
 * @author Xingyu Sun
 * @date 2019/6/25 17:26
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionDao, SysPermission> implements PermissionService {
}
