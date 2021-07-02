package com.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/demo")
public class DemoController {

	@ResponseBody
    @RequestMapping("/index")
    public String index(){
        return "demo";
    }
    
    @ResponseBody
    @RequestMapping("/index2")
    @ApiOperation(value="获取index2", httpMethod="GET", notes="获取index2 test")
    public String index2(@ApiParam(required=true,name="url",value="请求路径")@RequestParam(value="url") String url){
        return "hello";
    }
}