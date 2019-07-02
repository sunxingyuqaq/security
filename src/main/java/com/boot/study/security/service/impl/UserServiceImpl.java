package com.boot.study.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.study.security.config.JwtUtils;
import com.boot.study.security.dao.UserDao;
import com.boot.study.security.entity.SysUser;
import com.boot.study.security.model.RestCode;
import com.boot.study.security.model.RestResult;
import com.boot.study.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sxy
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, SysUser> implements UserService {
    @Autowired
    private UserDetailsService sysUserDetailServiceImpl;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void print() {
        System.out.println("1111111");
    }

    @Override
    public List<SysUser> findAll() {
        return getBaseMapper().findAll();
    }

    @Override
    public RestResult login(String username, String password) {
        try {
            UserDetails userDetails = sysUserDetailServiceImpl.loadUserByUsername(username);
            if (userDetails != null) {
                String pwd = userDetails.getPassword();
                if (!passwordEncoder.matches(password, pwd)) {
                    return RestResult.fail(RestCode.USERNAME_OR_PASSWORD_WRONG);
                }
                String token = jwtUtils.generateToken(userDetails);
                return RestResult.success(token);
            }
        } catch (Exception e) {
            return RestResult.success(RestCode.USER_NOT_FOUND);
        }

        return RestResult.fail(RestCode.UNKNOWN_ERROR);
    }

}