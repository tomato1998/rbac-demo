package com.tomato.security.controller;


import com.tomato.entity.po.Role;
import com.tomato.entity.po.User;
import com.tomato.entity.vo.CommonResult;
import com.tomato.security.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @author LiDaShan
 * @Version 1.0
 * @Date 2020/7/27
 * @Content:
 */
@RestController
@Slf4j
public class UserController {

    @Resource
    private IUserService userService;

    @RequestMapping("/user/register")
    public String register(User user){
        log.info("user:"+user);
        userService.add(user);
        return "forward:/login";
    }

    @PostMapping("/user/manager/add")
    public CommonResult add(@Validated User user){
        int result = userService.add(user);
        if(result == 1){
            return new CommonResult(200,"用户增添成功");
        }else {
            return new CommonResult(500,"用户增添失败");
        }
    }

    @GetMapping("/user/manager/delete")
    public CommonResult delete( User user){
        int result = userService.delete(user);
        if(result == 1){
            return new CommonResult(200,"用户删除成功");
        }else {
            return new CommonResult(500,"用户删除失败");
        }
    }


    @PostMapping("/user/manager/update")
    public CommonResult update(User user){
        int result = userService.update(user);
        if(result == 1){
            return new CommonResult(200,"用户修改成功");
        }else {
            return new CommonResult(500,"用户修改失败");
        }
    }


    @GetMapping("/user/manager/select")
    public CommonResult add(@RequestParam(required = true) String username){
        User result = userService.seleteByUserName(username);
        log.info("result:"+result);
        if(result != null){
            return new CommonResult(200,"用户查询成功",result);
        }else {
            return new CommonResult(500,"用户查询失败",result);
        }
    }


}
