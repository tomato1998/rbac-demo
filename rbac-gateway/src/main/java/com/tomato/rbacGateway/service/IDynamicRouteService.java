package com.tomato.rbacGateway.service;

import com.alibaba.nacos.api.config.ConfigService;

/**
 * @author LiDaShan
 * @Version 1.0
 * @Date 2020/7/24
 * @Content:
 */
public interface IDynamicRouteService {

    /**
     * 初始化网关
     */
    void init();

    /**
     * 监听Nacos下发的动态路由配置
     * @param dataId
     * @param group
     */
    void dynamicRouteByNacosListener (String dataId, String group);

    /**
     * 初始化nacos configservice
     * @return
     */
    ConfigService initConfigService();
}
