package com.boot.study.security.config;

import com.boot.study.security.dao.UserDao;
import com.boot.study.security.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Xingyu Sun
 * @date 2019/6/25 14:11
 */
@Slf4j
@Component
public class SysUserDetailServiceImpl implements UserDetailsService {

    @Resource
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("【{}】 login in ...",username);
        SysUser user = userDao.selectByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username 【'%s'.】", username));
        }else {
            return user;
        }
    }
}
