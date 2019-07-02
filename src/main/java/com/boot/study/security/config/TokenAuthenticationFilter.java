package com.boot.study.security.config;

import com.boot.study.security.model.RestCode;
import com.boot.study.security.model.RestResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Xingyu Sun
 * @date 2019/6/25 14:28
 */
@Component
@Slf4j
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtProperties jwtProperties;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private UserDetailsService sysUserDetailServiceImpl;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        final String requestHeader = request.getHeader(this.jwtProperties.getHeader());
        String username;
        String authToken;
        String blank = " ";
        if (requestHeader != null && requestHeader.startsWith(jwtProperties.getPrefix() + blank)) {
            authToken = requestHeader.substring(7);
            RestResult fail;
            try {
                username = jwtUtils.getUsernameFromToken(authToken);
            } catch (ExpiredJwtException e) {
                fail = RestResult.fail(RestCode.JWT_EXPIRED);
                String s = objectMapper.writeValueAsString(fail);
                response.getWriter().write(s);
                log.error("jwt is expired {}", e.getMessage());
                return;
            } catch (SignatureException e) {
                fail = RestResult.fail(RestCode.JWT_SIGNATURE_EXCEPTION);
                String s = objectMapper.writeValueAsString(fail);
                response.getWriter().write(s);
                log.error("jwt is not right {}", e.getMessage());
                return;
            } catch (UnsupportedJwtException e) {
                fail = RestResult.fail(RestCode.JWT_UNSUPPORTED_EXCEPTION);
                String s = objectMapper.writeValueAsString(fail);
                response.getWriter().write(s);
                log.error("UnsupportedJwtException {}", e.getMessage());
                return;
            } catch (JwtException e) {
                fail = RestResult.fail(RestCode.JWT_EXCEPTION);
                String s = objectMapper.writeValueAsString(fail);
                response.getWriter().write(s);
                log.error("JwtException {}", e.getMessage());
                return;
            }
            log.info("checking authentication " + username);
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = this.sysUserDetailServiceImpl.loadUserByUsername(username);
                if (jwtUtils.validateToken(authToken, userDetails)) {
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    log.info("checking authentication " + username);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        filterChain.doFilter(request, response);
    }
}
