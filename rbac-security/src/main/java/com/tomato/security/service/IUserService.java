package com.tomato.security.service;

import com.tomato.entity.po.User;

/**
 * @author LiDaShan
 * @Version 1.0
 * @Date 2020/7/27
 * @Content:
 */
public interface IUserService {

    int add(User user);
    int delete(User user);
    int update(User user);
    User seleteByUserName(String username);
}
