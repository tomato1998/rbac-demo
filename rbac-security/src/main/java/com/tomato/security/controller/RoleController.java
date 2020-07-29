package com.tomato.security.controller;

import com.tomato.entity.po.Role;
import com.tomato.entity.vo.CommonResult;
import com.tomato.security.service.IRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
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
@Slf4j
public class RoleController {

    @Resource
    private IRoleService roleService;

    @PostMapping("/role/manager/add")
    public CommonResult add(@Validated Role role){
        int result = roleService.addeRole(role);
        if(result == 1){
            return new CommonResult(200,"角色增添成功");
        }else {
            return new CommonResult(500,"角色增添失败");
        }
    }

    @GetMapping("/role/manager/delete")
    public CommonResult delete(Role role){
        int result = roleService.deleteRole(role);
        if(result == 1){
            return new CommonResult(200,"角色删除成功");
        }else {
            return new CommonResult(500,"角色删除失败");
        }
    }

    @PostMapping("/role/manager/update")
    public CommonResult update(Role role){
        int result = roleService.updateRole(role);
        if(result == 1){
            return new CommonResult(200,"角色更新成功");
        }else {
            return new CommonResult(500,"操作错误，角色更新失败");
        }
    }

    @GetMapping("/role/manager/select")
    public CommonResult select(@RequestParam(required = true) String roleName){
        log.info("***************查询角色名:"+roleName);
        Role result = roleService.selectRoleByName(roleName);
        if(result == null){
            return new CommonResult(200,"无此角色");
        }else {
            return new CommonResult(500,"查询到角色信息",result);
        }
    }
}
