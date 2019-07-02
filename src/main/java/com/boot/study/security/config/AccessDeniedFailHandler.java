package com.boot.study.security.config;

import com.boot.study.security.model.RestCode;
import com.boot.study.security.model.RestResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Xingyu Sun
 * @date 2019/6/28 15:41
 */
@Slf4j
@Component
public class AccessDeniedFailHandler implements AccessDeniedHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        RestResult fail = RestResult.fail(RestCode.USER_FORBIDDEN);
        String s = objectMapper.writeValueAsString(fail);
        response.getWriter().write(s);
    }
}
