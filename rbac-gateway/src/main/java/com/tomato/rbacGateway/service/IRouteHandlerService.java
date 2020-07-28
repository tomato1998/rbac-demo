package com.tomato.rbacGateway.service;

import org.springframework.cloud.gateway.route.RouteDefinition;

/**
 * @author LiDaShan
 * @Version 1.0
 * @Date 2020/7/24
 * @Content:    操作路由
 */
public interface IRouteHandlerService {

    /**
     * 更新路由
     * @param definition
     * @return
     */
    String update(RouteDefinition definition);

    /**
     * 删除路由
     * @param id
     * @return
     */
    String delete(String id);

    /**
     * 增加路由
     * @param definition
     * @return
     */
    public String add(RouteDefinition definition);
}
