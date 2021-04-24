package com.hxx.alibaba.test;

import org.springframework.web.client.RestTemplate;

public class Test {

    public static void main(String[] args) throws Exception{
        RestTemplate template=new RestTemplate();
//        for(int i=0;i<100;i++){
//            String result = template.getForObject("http://localhost:8091/member/index", String.class);
//            System.out.println("result->"+result);
//            Thread.sleep(10);
//        }


//        for(int x=0;x<1000;x++){
//            for(int y=0;y<1000;y++){
//                if((x+y)==104 && (x-y)==52){
//                    System.out.println("x"+x);
//                    System.out.println("y"+y);
//                    System.out.println("x/y-->"+x/y);
//                }
//            }
//        }

        for(int i=0;i<100;i++){
            for(int j=0;j<100;j++){
                if(i+j==46 && 2*i+4*j==128){
                    System.out.println(i+"--"+j);
                }
            }
        }

    }
}
