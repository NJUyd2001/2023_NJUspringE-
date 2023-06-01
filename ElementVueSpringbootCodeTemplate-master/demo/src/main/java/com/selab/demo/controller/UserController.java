package com.selab.demo.controller;

import com.selab.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/insert")
    public String insert(@RequestBody String postJson){
        return userService.insert(postJson);
    }
    @RequestMapping("/login")
    public String login(@RequestBody String postJson){
        return userService.login(postJson);
    }
}
