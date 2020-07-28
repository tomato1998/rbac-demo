package com.tomato.security.dao;

import com.tomato.entity.po.User;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @author LiDaShan
 * @Version 1.0
 * @Date 2020/7/27
 * @Content:
 */

public interface IUserDao {

    void add(User user);
    void delete(User user);
    void update(User user);
    User seleteByUserName(String username);
}
