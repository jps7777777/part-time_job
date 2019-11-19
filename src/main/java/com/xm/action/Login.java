package com.xm.action;

import com.xm.response.CommonResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller("login")
@RequestMapping("/lg")
@Api(tags = "用户登录界面",description = "登录接口及跳转界面")
public class Login {

    @PostMapping("/test")
    @ApiOperation(value = "登录测试接口")
    @ResponseBody
    public CommonResponse rest(){
        Map<String,String> map = new HashMap<>();
        map.put("name","jin");
        map.put("age","15");
        map.put("gender","男");
        map.put("email","841590610@qq.com");
        return CommonResponse.create(map);
    }

    @GetMapping("/index")
    public String index(){
        Object user = "jin";
        return "login/index";
    }




    @RequestMapping("/index2")
    public ModelAndView login(){
        ModelAndView model = new ModelAndView();
        Map<String,String> map = new HashMap<>();
        map.put("name","jin");
        map.put("age","15");
        model.addObject("user",map);
        model.setViewName("login/login");
        return model;
    }








}
