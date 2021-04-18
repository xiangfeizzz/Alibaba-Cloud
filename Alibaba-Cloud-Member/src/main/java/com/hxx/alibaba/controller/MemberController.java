package com.hxx.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSONObject;
import com.hxx.alibaba.controller.fegin.MemberService;
import com.hxx.alibaba.repository.entity.DataReceiveRecordEntity;
import com.hxx.alibaba.service.ProviderService;
import io.netty.handler.codec.json.JsonObjectDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Arrays;
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



    @Value("${isNewBusi}")
    private Boolean isNewBusi;

    int i=0;
    @RequestMapping("/index")
    public String index() {
        i++;
        if(i%2==0)  return "error";
        return "index";
    }

    @RequestMapping("/list")
    public String list() {
        return "list";
    }

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
        return this.restTemplate.getForObject("http://alibaba-cloud-provder/provder/getIpAndPort", String.class);
    }


    /**
     * 根据id查询
     *
     * @return
     */
    @GetMapping("/selectById")
    public DataReceiveRecordEntity selectById(String id) {
        DataReceiveRecordEntity entity = memberService.selectById(id);
        return entity;
    }

    /**
     * 获取列表
     *
     * @return
     */
    @GetMapping("/queryList")
    public String  queryList() {
//        ribbon调用
//        DataReceiveRecordEntity[] entityArray=restTemplate.getForObject("http://alibaba-cloud-provder/provder/queryList", DataReceiveRecordEntity[].class);
//        List<DataReceiveRecordEntity> entityList= Arrays.asList(entityArray);

        //feign调用
        List<DataReceiveRecordEntity> entityList=memberService.queryList();

        for(DataReceiveRecordEntity e:entityList){
            System.out.println("id->"+e.getId());
        }
        return JSONObject.toJSONString(entityList) ;
       }



    /**
     * 修改
     * @return
     */
    @GetMapping("/update")
    public DataReceiveRecordEntity update(String id, String remark) {
        DataReceiveRecordEntity entity = new DataReceiveRecordEntity();
        entity.setId(id);
        entity.setDataRemark(remark);
        HashMap<String,String> map=new HashMap<>();
        map.put("id",id);
        map.put("remark",remark);
        //ribbon调用
//        ResponseEntity<DataReceiveRecordEntity> entityReturn = restTemplate.postForEntity("http://alibaba-cloud-provder/provder/update", entity, DataReceiveRecordEntity.class);
//        return entityReturn.getBody();

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
    public DataReceiveRecordEntity insert() {
        DataReceiveRecordEntity entity = new DataReceiveRecordEntity();
        entity.setDataType("1");
        entity.setDataRemark("测试");
        entity.setTotalNum("1");
        entity.setSuccNum("1");
        entity.setCreateTime(LocalDateTime.now().toString());

        //ribbon调用
//        ResponseEntity<DataReceiveRecordEntity> entityReturn = restTemplate.postForEntity("http://alibaba-cloud-provder/provder/insert", entity, DataReceiveRecordEntity.class);
//        return entityReturn.getBody();

        //feign调用
        entity= memberService.insert(entity);
        return entity;
    }


}
