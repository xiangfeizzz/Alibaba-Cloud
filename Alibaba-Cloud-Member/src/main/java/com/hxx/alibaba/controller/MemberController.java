package com.hxx.alibaba.controller;

import com.hxx.alibaba.controller.fegin.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 使用说明： 使用了 yaml配置中心后我的请求一直访问不到资源是404  出现这个情况的话 在Controller类在加一个@RequestMapping("/alibaba")
 *
 * @author huangxiangxiang
 * @version 2.0.0
 * @createTime 2019年09月10日 13:25:00
 */

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    MemberService memberService;

    @RequestMapping("/getName")
    public String getNameList(String name) {
        System.out.println("生产者member");
        String returnName = memberService.getName(name);
        return returnName + "-生产者member";
    }


    /**
     * 基于Ribbon调用服务接口
     * @return
     */
    @GetMapping("/getIpAndPort")
    public String getIpAndPort() {
        return this.restTemplate.getForObject("http://alibaba-cloud-provder/provder/getIpAndPort", String.class);
    }

}
