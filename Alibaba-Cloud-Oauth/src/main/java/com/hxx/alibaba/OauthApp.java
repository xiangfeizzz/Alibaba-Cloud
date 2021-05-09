package com.hxx.alibaba;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description:
 * @Author: zhurongsheng
 * @Date: 2020/7/18 14:43
 */
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(basePackages = {"com.hxx.alibaba.mapper"})
public class OauthApp {

    public static void main(String[] args) {
        SpringApplication.run(OauthApp.class);
    }
}
