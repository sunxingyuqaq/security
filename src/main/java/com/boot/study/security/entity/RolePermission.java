package com.boot.study.security.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Xingyu Sun
 * @date 2019/6/25 17:34
 */
@Data
@TableName("role_permission")
public class RolePermission extends BaseEntity{

    @TableId(type = IdType.ID_WORKER)
    private Long id;
    @TableField(value = "role_id")
    private Long roleId;
    @TableField(value = "permission_id")
    private Long permissionId;
}
