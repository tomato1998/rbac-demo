package com.tomato.security.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/page/index")
    public String indexPage(){
        log.info("登陆成功");
        return "index";
    }

    @GetMapping("/page/userPage")
    public String userPage(){
        return "userPage";
    }

    @GetMapping("/page/rolePage")
    public String rolePage(){
        return "rolePage";
    }

    @GetMapping("/page/userPage")
    public String authorityPage(){
        return "authorityPage";
    }
}
