package com.tomato.security.dao;

import com.tomato.entity.po.User;


/**
 * @author LiDaShan
 * @Version 1.0
 * @Date 2020/7/27
 * @Content:
 */

public interface IUserDao {

    /**
     * 增添用户
     * @param user
     */
    void add(User user);

    /**
     * 删除用户
     * @param user
     */
    void delete(User user);

    /**
     * 更新用户
     * @param user
     */
    void update(User user);

    /**
     * 根据用户名查询用户所有信息
     * @param username
     * @return
     */
    User seleteByUserName(String username);
}
