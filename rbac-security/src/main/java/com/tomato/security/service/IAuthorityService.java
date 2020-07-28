package com.tomato.security.service;

import org.apache.ibatis.annotations.Param;

/**
 * @author LiDaShan
 * @Version 1.0
 * @Date 2020/7/27
 * @Content:
 */

public interface IAuthorityService {

    int add( Long userId, Long roleId);
    int delete( Long userId, Long roleId);
}
