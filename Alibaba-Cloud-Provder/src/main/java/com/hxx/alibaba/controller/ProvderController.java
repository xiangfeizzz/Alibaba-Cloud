package com.hxx.alibaba.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 使用说明： 使用了 yaml配置中心后我的请求一直访问不到资源是404  出现这个情况的话 在Controller类在加一个@RequestMapping("/alibaba")
 *
 * @author huangxiangxiang
 * @version 2.0.0
 * @createTime 2019年09月10日 13:25:00
 */

@RestController
@RequestMapping("/provder")
public class ProvderController {


    @RequestMapping("/getName")
    public String getNameList(String name) {
        System.out.println("生产者");
        return name + "生产者";
    }
}
