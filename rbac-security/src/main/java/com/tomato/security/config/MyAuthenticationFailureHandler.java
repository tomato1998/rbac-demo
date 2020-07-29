package com.tomato.security.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author LiDaShan
 * @Version 1.0
 * @Date 2020/7/27
 * @Content: 认证失败处理
 */
@Configuration
@Slf4j
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {


    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {

        HttpSession session = httpServletRequest.getSession();
        log.info(session.getAttribute("user")+"无权限访问被拒绝");
        
    }
}
