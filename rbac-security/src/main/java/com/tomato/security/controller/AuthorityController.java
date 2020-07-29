package com.tomato.security.controller;

import com.tomato.entity.vo.CommonResult;
import com.tomato.security.service.IAuthorityService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author LiDaShan
 * @Version 1.0
 * @Date 2020/7/27
 * @Content:
 */
@RestController
@Secured("hasRole('ROLE_ADMIN')")
public class AuthorityController {

    @Resource
    private IAuthorityService authorityService;

    /**
     * 给指定用户增添权限
     * @param userId
     * @param roleId
     * @return
     */
    @PostMapping("/authority/manager/add")
    public CommonResult add(@RequestParam(required = true,name = "userId") Long userId,
                            @RequestParam(required = true,name = "userId") Long roleId){
        int result = authorityService.add(userId, roleId);
        if(result == 1){
            return new CommonResult(200,"用户权限增添成功");
        }else {
            return new CommonResult(500,"操作错误，用户已有此权限");
        }
    }


    /**
     * 删除指定用户权限
     * @param userId
     * @param roleId
     * @return
     */
    @GetMapping("/authority/manager/remove")
    public CommonResult remove(@RequestParam(required = true,name = "userId") Long userId,
                         @RequestParam(required = true,name = "userId") Long roleId){
        int result = authorityService.delete(userId, roleId);
        if(result == 1){
            return new CommonResult(200,"用户权限移除成功");
        }else {
            return new CommonResult(500,"操作错误，用户无此权限");
        }

    }
}
