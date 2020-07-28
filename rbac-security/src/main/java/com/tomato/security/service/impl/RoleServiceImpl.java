package com.tomato.security.service.impl;

import com.tomato.entity.po.Role;
import com.tomato.security.service.IRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author LiDaShan
 * @Version 1.0
 * @Date 2020/7/27
 * @Content:
 */
@Service
@Slf4j
public class RoleServiceImpl implements IRoleService {

    @Resource
    private IRoleService roleService;


    @Override
    public Role selectRoleByName(String roleName) {

        return roleService.selectRoleByName(roleName);
    }

    @Override
    public int addeRole(Role role) {
        if (role == null || role.getRoleName() == null || role.getRoleName() == "") {
            log.info("角色名不能为空");
            return 0;
        }
        if (this.selectRoleByName(role.getRoleName()) != null){
            log.info("此角色已经存在");
            return -1;
        }
        roleService.addeRole(role);
        return 1;
    }

    @Override
    public int deleteRole(Role role) {
        roleService.deleteRole(role);
        return 1;
    }

    @Override
    public int updateRole(Role role) {
        if (role == null ) {
            log.info("角色信息不能为空");
            return 0;
        }
        roleService.updateRole(role);
        return 1;

    }
}
