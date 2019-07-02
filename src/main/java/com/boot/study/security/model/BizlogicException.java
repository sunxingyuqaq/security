package com.boot.study.security.model;

/**
 * @author Xingyu Sun
 * @date 2019/6/27 13:44
 */
public class BizlogicException extends RuntimeException{

    private ErrorEnums errorEnums;

    public BizlogicException(ErrorEnums errorEnums) {
        super(errorEnums.getMsg());
        this.errorEnums = errorEnums;
    }

    public BizlogicException(String message, ErrorEnums errorEnums) {
        super(message);
        this.errorEnums = errorEnums;
    }
}
