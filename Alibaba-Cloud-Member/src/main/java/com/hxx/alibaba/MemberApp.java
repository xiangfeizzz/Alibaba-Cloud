package com.hxx.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 使用说明：生产者生产东西
 *
 * @author huangxiangxiang
 * @version 2.0.0
 * @createTime 2019年09月10日 13:22:00
 */

@SpringBootApplication
@EnableDiscoveryClient
public class MemberApp {

    public static void main(String[] args) {
        SpringApplication.run(MemberApp.class, args);
    }
}
