package com.tomato.security.dao;

import com.tomato.entity.po.Role;


/**
 * @author LiDaShan
 * @Version 1.0
 * @Date 2020/7/27
 * @Content:
 */

public interface IRoleDao {

    /**
     * 根据角色名查询角色信息
     * @param roleName
     * @return
     */
    Role selectRoleByName(String roleName);

    /**
     * 增添角色
     * @param role
     */
    void addeRole(Role role);

    /**
     * 删除角色
     * @param role
     */
    void deleteRole(Role role);

    /**
     * 更新角色信息
     * @param role
     */
    void updateRole(Role role);

}
