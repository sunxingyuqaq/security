package com.boot.study.security.model;

import lombok.Getter;

/**
 * @author Xingyu Sun
 * @date 2019/6/27 13:44
 */
@Getter
public enum RestCode implements ErrorEnums{
    /**
     * user not found
     */
    AUTH_EXCEPTION("400400","auth error"),
    USER_FORBIDDEN("400403","user not allow operate"),
    USER_NOT_FOUND("400404","user not found"),
    USERNAME_OR_PASSWORD_WRONG("400405","username or password not right"),
    UNKNOWN_ERROR("500500","unknown error"),
    NOT_LOGIN("500501","user not login"),
    JWT_EXCEPTION("500200","token exception"),
    JWT_EXPIRED("500201","token expired"),
    JWT_SIGNATURE_EXCEPTION("500202","signature not right"),
    JWT_UNSUPPORTED_EXCEPTION("500203","token unsupported");

    private String code;
    private String msg;

    RestCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
