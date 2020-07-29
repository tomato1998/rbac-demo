package com.tomato.rbacGateway.service.impl;

import com.tomato.rbacGateway.service.IRouteHandlerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * 对路由实现操作  https://www.cnblogs.com/jian0110/p/12862569.html
 */
@Slf4j
@Service
public class RouteHandlerServiceImpl implements IRouteHandlerService {

    @Autowired
    private RouteDefinitionWriter routeDefinitionWriter;

    @Override
    public String update(RouteDefinition definition) {
        try {
            log.info("gateway update route {}",definition);
            this.routeDefinitionWriter.delete(Mono.just(definition.getId()));
        } catch (Exception e) {
            return "update fail,not find route  routeId: "+definition.getId();
        }
        try {
            routeDefinitionWriter.save(Mono.just(definition)).subscribe();
            return "success";
        } catch (Exception e) {
            return "update route fail";
        }
    }


    @Override
    public String delete(String id) {
        try {
            log.info("gateway delete route id {}",id);
            this.routeDefinitionWriter.delete(Mono.just(id));
            return "delete success";
        } catch (Exception e) {
            return "delete fail";
        }
    }


    @Override
    public String add(RouteDefinition definition) {
        log.info("gateway add route {}",definition);
        routeDefinitionWriter.save(Mono.just(definition)).subscribe();
        return "success";
    }
}