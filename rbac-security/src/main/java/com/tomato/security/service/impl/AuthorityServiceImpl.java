package com.tomato.security.service.impl;

import com.tomato.security.dao.IAuthorityDao;
import com.tomato.security.service.IAuthorityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author LiDaShan
 * @Version 1.0
 * @Date 2020/7/27
 * @Content:
 */
@Service
@Slf4j
public class AuthorityServiceImpl implements IAuthorityService {

    @Resource
    private IAuthorityDao authorityDao;

    @Override
    public int add(Long userId, Long roleId) {
        try {
            authorityDao.add(userId,roleId);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            log.error("重复添加权限");
            return 0;
        }

    }

    @Override
    public int delete(Long userId, Long roleId) {
        authorityDao.delete(userId,roleId);
        return 1;
    }
}
