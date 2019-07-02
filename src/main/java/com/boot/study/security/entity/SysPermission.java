package com.boot.study.security.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Xingyu Sun
 * @date 2019/6/25 17:01
 */
@Data
@TableName("sys_permission")
public class SysPermission extends BaseEntity{

    @TableId(type = IdType.ID_WORKER)
    private Long id;

    private String permissionName;

    private String permissionCode;
}
