package com.boot.study.security;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.boot.study.security.config.JwtProperties;
import com.boot.study.security.entity.*;
import com.boot.study.security.service.*;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sxy
 */
@MapperScan("com.boot.study.security.dao")
@EnableConfigurationProperties(JwtProperties.class)
@SpringBootApplication
@RestController
public class SecApplication {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private RolePermissionService rolePermissionService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${init}")
    private boolean init;

    public static void main(String[] args) {
        SpringApplication.run(SecApplication.class, args);
    }

    @GetMapping("/api/test")
    public Map<String, Object> get() {
        Map<String, Object> map = new HashMap<>(16);
        map.put("key", "value");
        map.put("age", 11);
        map.put("sex", "man");
        map.put("mail", "wu11");
        return map;
    }

    @Bean
    public CommandLineRunner runner() {
        return args -> {
            if (init) {
                init();
            }
        };
    }

    private void init() {
        SysPermission permission = null;
        SysPermission permission2 = null;
        SysRole role = null;
        SysRole role2;
        SysUser user;
        SysUser user2;
        List<SysPermission> list2 = permissionService.list();
        if (list2.size() == 0) {
            permission = new SysPermission();
            permission.setPermissionName("USER:ADD");
            permission.setPermissionCode("10010");
            permissionService.getBaseMapper().insert(permission);
            permission2 = new SysPermission();
            permission2.setPermissionName("USER:DELETE");
            permission2.setPermissionCode("10011");
            permissionService.getBaseMapper().insert(permission2);
        }
        List<SysRole> list1 = roleService.findAll();
        if (list1.size() == 0) {
            role = new SysRole();
            role.setRoleName("ADMIN");
            roleService.getBaseMapper().insert(role);
            role2 = new SysRole();
            role2.setRoleName("TEST");
            roleService.getBaseMapper().insert(role2);
            QueryWrapper<RolePermission> wrapper = new QueryWrapper<>();
            wrapper.eq("role_id", role.getId()).eq("permission_id", permission.getId());
            List<RolePermission> list = rolePermissionService.list(wrapper);
            if (list.size() == 0) {
                RolePermission rolePermission = new RolePermission();
                rolePermission.setRoleId(role.getId());
                rolePermission.setPermissionId(permission.getId());
                rolePermissionService.getBaseMapper().insert(rolePermission);

                RolePermission rolePermission2 = new RolePermission();
                rolePermission2.setRoleId(role.getId());
                rolePermission2.setPermissionId(permission2.getId());
                rolePermissionService.getBaseMapper().insert(rolePermission2);
            }
        }
        List<SysUser> list = userService.findAll();
        if (list.size() == 0) {
            user = new SysUser();
            user.setEnable(true);
            user.setUsername("admin");
            user.setPassword(passwordEncoder.encode("123456"));
            user.setSex(0);
            userService.getBaseMapper().insert(user);
            user2 = new SysUser();
            user2.setEnable(true);
            user2.setUsername("test");
            user2.setPassword(passwordEncoder.encode("123456"));
            user2.setSex(1);
            userService.getBaseMapper().insert(user2);
            QueryWrapper<UserRole> wrapper = new QueryWrapper<>();
            wrapper.eq("user_id", user.getId()).eq("role_id", role.getId());
            List<UserRole> userRoles = userRoleService.list(wrapper);
            if (userRoles.size() == 0) {
                UserRole userRole = new UserRole();
                userRole.setUserId(user.getId());
                userRole.setRoleId(role.getId());
                userRoleService.getBaseMapper().insert(userRole);
            }
        }
    }

}
