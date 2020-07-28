package com.tomato.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author LiDaShan
 * @Version 1.0
 * @Date 2020/7/27
 * @Content:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderMain8003 {

    public static void main(String[] args) {
        SpringApplication.run(ProviderMain8003.class);
    }
}
