package com.hxx.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSONObject;
import com.hxx.alibaba.controller.fegin.MemberService;
import com.hxx.alibaba.repository.entity.VmTemplateEntity;
import com.hxx.alibaba.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("/member")
@RefreshScope
public class MemberController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    MemberService memberService;
    @Autowired
    ProviderService providerService;
    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${isNewBusi}")
    private String isNewBusi;

    int i=0;
    @RequestMapping("/index")
    public String index() {
        i++;
        if(i%2==0) {
            return "error";
        }
        return "index";
    }

    @RequestMapping("/list")
    public String list() {
//        try{Thread.sleep(100);}catch(Exception e){e.printStackTrace();}
        return "list";
    }


    /**
     * 测试sentinel链路规则
     * @return
     */
    @GetMapping("/link")
    public String link() {
        return providerService.link();
    }

    /**
     * 测试sentinel链路规则
     * @return
     */
    @GetMapping("/link2")
    public String link2() {
        return providerService.link();
    }


    /**
     * 测试sentinel热点规则
     * @param num1
     * @param num2
     * @return
     */
    @GetMapping("/hot")
    @SentinelResource("hot")
    public String hot(@RequestParam(value = "num1",required = false) Integer num1, @RequestParam(value = "num2",required = false) Integer num2) {
        return num1+"-"+num2;
    }

    /**
     * 获取注册中心配置
     */
    @RequestMapping("/getConfig")
    public String getConfig() {
        System.out.println("是否业务走新逻辑:" + isNewBusi);
        return isNewBusi.toString();
    }

    /**
     * getIpAndPort
     * @return
     */
    @GetMapping("/getIpAndPort")
    public String getIpAndPort() {
        String ipAndPort= memberService.getIpAndPort();
        return ipAndPort;
    }


    /**
     * 根据id查询
     *
     * @return
     */
    @GetMapping("/selectById")
    public VmTemplateEntity selectById(String id) {
        VmTemplateEntity entity = memberService.selectById(id);
        return entity;
    }

    /**
     * 获取列表
     *
     * @return
     */
    @GetMapping("/queryList")
    public String  queryList() {
        //feign调用
        List<VmTemplateEntity> entityList=memberService.queryList();

        for(VmTemplateEntity e:entityList){
            System.out.println("id->"+e.getId());
        }
        return JSONObject.toJSONString(entityList) ;
       }



    /**
     * 修改
     * @return
     */
    @GetMapping("/update")
    public VmTemplateEntity update(String id, String template) {
        VmTemplateEntity entity = new VmTemplateEntity();
        entity.setId(id);
        entity.setTemplate(template);
        HashMap<String,String> map=new HashMap<>();
        map.put("id",id);
        map.put("template",template);

        //feign调用
        entity= memberService.update(map);
        return entity;
    }

    /**
     * 新增
     *
     * @return
     */
    @GetMapping("/insert")
    public VmTemplateEntity insert() {
        VmTemplateEntity entity = new VmTemplateEntity();
        entity.setTemplate("测试");

        //feign调用
        entity= memberService.insert(entity);
        return entity;
    }

    /**
     * 根据id删除
     *
     * @return
     */
    @GetMapping("/deleteById")
    public String deleteById(String id) {
        int i = memberService.deleteById(id);
        return "删除成功";
    }


    @GetMapping("/getServiceList")
    public List<ServiceInstance> getServiceList() {
        List<ServiceInstance> serviceInstanceList =  discoveryClient.getInstances("alibaba-cloud-provder");
        return serviceInstanceList;
    }

}
