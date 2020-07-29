package com.tomato.security.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author LiDaShan
 * @Version 1.0
 * @Date 2020/7/28
 * @Content:
 */
@Controller
@Slf4j
public class PageControlller {

    /**
     * 跳转至登陆页面
     * @return
     */
    @GetMapping("/page/login")
    public String loginPage(){
        return "forward:/login";
    }

    /**
     * 登陆成功跳转至首页
     * @return
     */
    @PostMapping("/page/index")
    public String indexPage(){
        return "index";
    }

    /**
     * 登录失败跳转页
     * @return
     */
    @PostMapping("/page/loginFail")
    public String loginFailPage(){
        return "loginFail";
    }

    /**
     * 权限不足拒绝访问页
     * @return
     */
    @PostMapping("/page/deny")
    public String denyPage(){
        return "deny";
    }

}
