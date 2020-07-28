package com.tomato.security.dao;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @author LiDaShan
 * @Version 1.0
 * @Date 2020/7/27
 * @Content:
 */

public interface IAuthorityDao {

    void add(@Param("userId") Long userId, @Param("roleId")Long roleId);
    void delete(@Param("userId") Long userId, @Param("roleId")Long roleId);
}
