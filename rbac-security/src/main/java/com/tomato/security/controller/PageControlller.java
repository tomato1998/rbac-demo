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

    @GetMapping("/page/login")
    public String loginPage(){
        return "forward:/login";
    }

    @PostMapping("/page/index")
    public String indexPage(){
        log.info("登陆成功");
        return "index";
    }

    @PostMapping("/page/loginFail")
    public String loginFailPage(){
        return "loginFail";
    }

    @PostMapping("/page/deny")
    public String denyPage(){
        return "deny";
    }

}
