package com.hxx.alibaba;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = {"com.hxx.alibaba.repository.dao"})
public class ProvderApp {

    public static void main(String[] args) {
        SpringApplication.run(ProvderApp.class, args);
    }
}
