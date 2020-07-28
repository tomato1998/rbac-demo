package com.tomato.rbacGateway.filters;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @author LiDaShan
 * @Version 1.0
 * @Date 2020/7/24
 * @Content:
 */
@Component
@Slf4j
public class GateWayLoginFilter implements GlobalFilter, Ordered {


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("*********come in MyLogGateWayFilter: "+new Date());
        String username = exchange.getRequest().getQueryParams().getFirst("username");
        if(StringUtils.isEmpty(username)){
            log.info("*****用户名为Null 非法用户,(┬＿┬)\r");
            this.getInfo(exchange);
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        log.info("*****用户:"+username+"\r");
        this.getInfo(exchange);
        return chain.filter(exchange);
    }

    public void getInfo(ServerWebExchange exchange){
        ServerHttpRequest request = exchange.getRequest();
        log.info("****访问信息{ 访问地址:"+request.getURI()+"\t用户访问地址："+request.getRemoteAddress()+
                "用户浏览器信息"+request.getHeaders().get("User-Agent"));

    }

    @Override
    public int getOrder() {
        return 0;
    }
}
