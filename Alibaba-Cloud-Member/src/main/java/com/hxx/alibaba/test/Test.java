package com.hxx.alibaba.test;

import org.springframework.web.client.RestTemplate;

import java.util.Random;

public class Test {

    public static void main(String[] args) throws Exception{
        RestTemplate template=new RestTemplate();
        for(int i=0;i<10;i++){
            String result = template.getForObject("http://localhost:8091/member/list", String.class);
            System.out.println("result------------------------------------->"+result);
            Thread.sleep(400);
        }
    }
}
