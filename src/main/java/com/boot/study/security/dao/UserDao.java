package com.boot.study.security.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.study.security.entity.SysUser;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Xingyu Sun
 * @date 2019/6/25 13:55
 */
@Transactional(rollbackFor = Exception.class)
public interface UserDao extends BaseMapper<SysUser> {
    /**
     * selectByUserName
     * @param name n
     * @return s
     */
    SysUser selectByUserName(String name);

    /**
     * selectPasswordByUsername
     * @param name n
     * @return s
     */
    String selectPasswordByUsername(String name);

    /**
     * selectUserByUsername
     * @param name n
     * @return s
     */
    SysUser selectUserByUsername(String name);

    /**
     * selectUserNameIsExist
     * @param name n
     * @return i
     */
    int selectUserNameIsExist(String name);

    /**
     * findAll
     * @return l
     */
    List<SysUser> findAll();
}
