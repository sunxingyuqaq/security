package com.boot.study.security.controller;

import com.boot.study.security.model.RestResult;
import com.boot.study.security.model.UserModel;
import com.boot.study.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Xingyu Sun
 * @date 2019/6/27 9:24
 */
@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/login",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public RestResult login(@Validated UserModel userModel){
        return userService.login(userModel.getUsername(),userModel.getPassword());
    }
}
