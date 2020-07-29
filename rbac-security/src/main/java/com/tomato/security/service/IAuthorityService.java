package com.tomato.security.service;

import org.apache.ibatis.annotations.Param;

/**
 * @author LiDaShan
 * @Version 1.0
 * @Date 2020/7/27
 * @Content:
 */

public interface IAuthorityService {

    /**
     * 给指定用户增加权限
     * @param userId
     * @param roleId
     * @return
     */
    int add( Long userId, Long roleId);

    /**
     * 删除指定用户的权限
     * @param userId
     * @param roleId
     * @return
     */
    int delete( Long userId, Long roleId);
}
