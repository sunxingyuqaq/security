package com.boot.study.security.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

/**
 * @author Xingyu Sun
 * @date 2019/6/25 14:07
 */
@Data
@TableName("sys_role")
public class SysRole {

    @TableId(type = IdType.ID_WORKER)
    private Long id;

    private String roleName;

    private List<SysPermission> permissions;
}
