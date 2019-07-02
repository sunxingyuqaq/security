package com.boot.study.security.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Xingyu Sun
 * @date 2019/6/25 14:36
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {
    private String secret;

    private Long expiration;

    private String header;

    private Route route = new Route();

    private String prefix;

    @Data
    public static class Route {
        private String login;
        private String refresh;
        private String register;

    }

}
