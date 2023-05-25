package com.selab.demo;
 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class HomeController {
 
    @RequestMapping("/")
    public String home(){
        return "你好，欢迎使用测试中心在线服务平台!0.0";
    }
}
