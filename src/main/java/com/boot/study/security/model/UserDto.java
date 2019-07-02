package com.boot.study.security.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Xingyu Sun
 * @date 2019/6/28 16:45
 */
@Data
public class UserDto implements Serializable {

    private String username;

    private String password;

    private Boolean enable;
}
