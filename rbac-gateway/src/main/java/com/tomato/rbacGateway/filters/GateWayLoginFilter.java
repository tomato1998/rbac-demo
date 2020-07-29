package com.tomato.rbacGateway.filters;

import com.tomato.entity.po.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
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

    @Resource
    private HttpSession session;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("*********come in MyLogGateWayFilter: "+new Date());
        User user = (User) session.getAttribute("user");
        if(user == null){
            log.info("*****用户名为Null 非法用户,(┬＿┬)\r");
            this.getInfo(exchange);
            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatus.SEE_OTHER);
            response.getHeaders().set("Location", "http://127.0.0.1:8001/login");
            return exchange.getResponse().setComplete();
        }
        log.info("*****用户:"+user.getUsername()+"\r");
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
