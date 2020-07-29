package com.tomato.security.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.annotation.Resource;

/**
 * @author LiDaShan
 * @Version 1.0
 * @Date 2020/7/27
 * @Content:
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private BCryptPasswordEncoder passwordEncoder;
    @Resource
    private LogoutSuccessHandler logoutSuccessHandler;
    @Resource
    private AuthenticationFailureHandler authenticationFailureHandler;
    @Resource
    private UserDetailsService userService;
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }




    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //不需要身份认证
                .antMatchers("/", "/login", "/page/loginFail","/user/register","/register").permitAll()
                .antMatchers("/user/manager/select").hasAnyRole("GUEST","ADMIN")
                .antMatchers("/user/**").hasAnyRole("ADMIN")
                .antMatchers("/role/manager/select").hasAnyRole("GUEST","ADMIN")
                .antMatchers("/role/**").hasAnyRole("ADMIN")
                //此行使用注解配置，验证注解配置的可用
                //.antMatchers("/authority/**").hasAnyRole("ADMIN")
                .and().formLogin()
                    .successForwardUrl("/page/index")
                    .failureHandler(authenticationFailureHandler)
                    .failureForwardUrl("/page/loginFail")
                    .permitAll()
                .and().logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessHandler(logoutSuccessHandler)
                .and().exceptionHandling()
                    .accessDeniedPage("/page/deny")
                .and().httpBasic()
                .and().sessionManagement().invalidSessionUrl("/toLogin")
                .and().csrf().disable();
    }
}



