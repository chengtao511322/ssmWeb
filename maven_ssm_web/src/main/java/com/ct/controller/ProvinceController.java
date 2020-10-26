package com.ct.controller;

import com.ct.Province;
import com.ct.service.IProvinceService;
import com.ct.utils.JedisUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 省份
 */
@Controller
@RequestMapping(path = "/province")
public class ProvinceController {

    @Autowired
    private IProvinceService service;

    private String privonce_json ;


    //查询所有省份

    /**
     * 通过redis缓存来查，先从redis中查询数据，如果存在就从redis当中查询，不存在就从数据库查询并缓存到redis
     * @return
     */
    @RequestMapping(path = "/findAll.do")
    public @ResponseBody String findAllByRedis(){
        //从工具类中获取jedis连接
        Jedis jedis = JedisUtil.getJedis();
        privonce_json = jedis.get("privonce");

        //判断privonce是否为null
        if(privonce_json==null || privonce_json.length()==0){
            System.out.println("redis中没有数据");
            //从数据库中查询
            List<Province> provinceList = service.findAll();
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                //序列化json
                privonce_json = objectMapper.writeValueAsString(provinceList);
                //将json数据存入redis中
                jedis.set("privonce",privonce_json);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }finally {
                jedis.close();
                return privonce_json;
            }
        }else {
            System.out.println("redis中有数据，查询缓存");
            return privonce_json;
        }
    }

}
