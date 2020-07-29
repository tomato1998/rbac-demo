package com.tomato.security.service.impl;

import com.tomato.entity.po.Role;
import com.tomato.entity.po.User;
import com.tomato.security.dao.IUserDao;
import com.tomato.security.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author LiDaShan
 * @Version 1.0
 * @Date 2020/7/27
 * @Content:
 */
@Service
@Slf4j
public class UserServcieImpl implements IUserService, UserDetailsService {

    @Resource
    private IUserDao userDao;

    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private HttpSession session;



    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        log.info("loadUserByUsername方法被调用");
        User user = userDao.seleteByUserName(s);
        if(user == null){
            log.error("用户没有找到");
            throw new UsernameNotFoundException("用户不存在");
        }
        //用户权限
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        if (user.getRoles()!=null) {
            List<Role> roles = user.getRoles();
            for (Role role : roles) {
                if (StringUtils.isNotBlank(role.getRoleName())) {
                    authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
                }
            }
        }
        log.info("user:"+user);
        session.setAttribute("user",user);
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                authorities);
    }


    @Override
    public int add(User user) {
        log.info("service============user:"+user);
//        if (this.seleteByUserName(user.getUsername()) != null){
//            log.info("用户已经存在");
//            return 0;
//        }
        String password = passwordEncoder.encode(user.getPassword());
        log.info("加密后密码为:"+password);
        user.setPassword(password);
        userDao.add(user);
        return 1;

    }

    @Override
    public int delete(User user) {
        userDao.delete(user);
        return 1;
    }

    @Override
    public int update(User user) {
        userDao.update(user);
        return 1;
    }

    @Override
    public User seleteByUserName(String username) {
        return userDao.seleteByUserName(username);
    }


}
