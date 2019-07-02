package com.boot.study.security.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Xingyu Sun
 * @date 2019/6/25 17:33
 */
@Data
@TableName("user_role")
public class UserRole extends BaseEntity{
    @TableId(type = IdType.ID_WORKER)
    private Long id;
    @TableField(value = "user_id")
    private Long userId;
    @TableField(value = "role_id")
    private Long roleId;
}
