package com.tomato.security.service;

import com.tomato.entity.po.User;

/**
 * @author LiDaShan
 * @Version 1.0
 * @Date 2020/7/27
 * @Content:
 */
public interface IUserService {

    /**
     * 增添用户
     * @param user
     * @return
     */
    int add(User user);

    /**
     * 删除用户
     * @param user
     * @return
     */
    int delete(User user);

    /**
     * 更新用户
     * @param user
     * @return
     */
    int update(User user);

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    User seleteByUserName(String username);
}
