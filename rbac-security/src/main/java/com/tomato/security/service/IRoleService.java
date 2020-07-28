package com.tomato.security.service;

import com.tomato.entity.po.Role;

/**
 * @author LiDaShan
 * @Version 1.0
 * @Date 2020/7/27
 * @Content:
 */
public interface IRoleService {

    Role selectRoleByName(String roleName);
    int addeRole(Role role);
    int deleteRole(Role role);
    int updateRole(Role role);
}
