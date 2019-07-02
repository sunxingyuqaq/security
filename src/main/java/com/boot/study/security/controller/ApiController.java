package com.boot.study.security.controller;

import com.boot.study.security.entity.SysUser;
import com.boot.study.security.model.RestResult;
import com.boot.study.security.model.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Xingyu Sun
 * @date 2019/6/28 15:23
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/admin")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public RestResult admin(Authentication authentication){
        UsernamePasswordAuthenticationToken u = (UsernamePasswordAuthenticationToken) authentication;
        SysUser user = (SysUser) u.getPrincipal();
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user,userDto);
        return RestResult.success(userDto.getUsername(),userDto.getPassword(),userDto.getEnable());
    }
}
