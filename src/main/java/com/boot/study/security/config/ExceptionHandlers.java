package com.boot.study.security.config;

import com.boot.study.security.model.RestCode;
import com.boot.study.security.model.RestResult;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Xingyu Sun
 * @date 2019/6/28 15:35
 */
@RestControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(AccessDeniedException.class)
    public RestResult handle(AccessDeniedException e) {
        return RestResult.fail(RestCode.USER_FORBIDDEN, e.getMessage());
    }

    @ExceptionHandler(AuthenticationException.class)
    public RestResult handle(AuthenticationException e) {
        return RestResult.fail(RestCode.AUTH_EXCEPTION, e.getMessage());
    }
}
