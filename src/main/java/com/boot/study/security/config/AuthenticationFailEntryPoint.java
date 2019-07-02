package com.boot.study.security.config;

import com.boot.study.security.model.RestCode;
import com.boot.study.security.model.RestResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Xingyu Sun
 * @date 2019/6/28 11:30
 */
@Component
@Slf4j
public class AuthenticationFailEntryPoint implements AuthenticationEntryPoint {

    private ObjectMapper objectMapper;

    public AuthenticationFailEntryPoint(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        RestResult fail = RestResult.fail(RestCode.NOT_LOGIN);
        String s = objectMapper.writeValueAsString(fail);
        response.getWriter().write(s);
    }
}
