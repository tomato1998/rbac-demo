package com.tomato.security.dao;

import com.tomato.entity.po.Role;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * @author LiDaShan
 * @Version 1.0
 * @Date 2020/7/27
 * @Content:
 */

public interface IRoleDao {

    Role selectRoleByName(String roleName);
    void addeRole(Role role);
    void deleteRole(Role role);
    void updateRole(Role role);

}
