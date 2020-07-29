package com.tomato.security.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author LiDaShan
 * @Version 1.0
 * @Date 2020/7/27
 * @Content: 成功登录处理器
 */
@Configuration
@Slf4j
public class MyLogoutSuccessHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        HttpSession session = httpServletRequest.getSession();
        log.info("用户:"+session.getAttribute("user")+"已经成功退出");
        session.removeAttribute("user");
        log.info("用户登录信息已清除,user:"+session.getAttribute("user")+"跳转至登陆界面");
        httpServletRequest.getRequestDispatcher("/login")
                .forward(httpServletRequest,httpServletResponse);
    }
}
