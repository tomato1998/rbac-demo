package com.tomato.security.dao;

import org.apache.ibatis.annotations.Param;

/**
 * @author LiDaShan
 * @Version 1.0
 * @Date 2020/7/27
 * @Content:
 */

public interface IAuthorityDao {

    /**
     * 给指定用户增添指定权限
     * @param userId
     * @param roleId
     */
    void add(@Param("userId") Long userId, @Param("roleId")Long roleId);

    /**
     * 删除指定用户权限
     * @param userId
     * @param roleId
     */
    void delete(@Param("userId") Long userId, @Param("roleId")Long roleId);
}
