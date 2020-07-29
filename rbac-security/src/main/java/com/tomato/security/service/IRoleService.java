package com.tomato.security.service;

import com.tomato.entity.po.Role;

/**
 * @author LiDaShan
 * @Version 1.0
 * @Date 2020/7/27
 * @Content:
 */
public interface IRoleService {

    /**
     * 查询用户的角色
     * @param roleName
     * @return
     */
    Role selectRoleByName(String roleName);

    /**
     * 增添角色
     * @param role
     * @return
     */
    int addeRole(Role role);

    /**
     * 删除角色
     * @param role
     * @return
     */
    int deleteRole(Role role);

    /**
     * 更新角色信息
     * @param role
     * @return
     */
    int updateRole(Role role);
}
