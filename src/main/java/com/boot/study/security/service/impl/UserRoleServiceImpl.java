package com.boot.study.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.study.security.dao.UserRoleDao;
import com.boot.study.security.entity.UserRole;
import com.boot.study.security.service.UserRoleService;
import org.springframework.stereotype.Service;

/**
 * @author sxy
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleDao, UserRole> implements UserRoleService {

}