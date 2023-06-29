package com.selab.demo.controller;

import com.selab.demo.model.User;
import com.selab.demo.service.UserService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @CrossOrigin
    @RequestMapping("/insert")
    public String insert(@RequestBody String postJson){
        return userService.insert(postJson);
    }
    @CrossOrigin
    @RequestMapping("/login/staff")
    public User staffLogin(@RequestBody String postJson){
        return userService.staffLogin(postJson);
    }
    @CrossOrigin
    @RequestMapping("/login/customer")
    public User customerLogin(@RequestBody String postJson){
        return userService.customerLogin(postJson);
    }
    @CrossOrigin
    @RequestMapping("/selectAll")
    public List<User> selectAll(){
        return userService.selectAll();
    }
    @CrossOrigin
    @RequestMapping("/selectAll/customer")
    public List<User> selectAllCustomer(){
        return userService.selectAllCustomer();
    }
    @CrossOrigin
    @RequestMapping("/selectAll/staff")
    public List<User> selectAllStaff(){
        return userService.selectAllStaff();
    }

    @CrossOrigin
    @RequestMapping("/update")
    public String update(@RequestBody String postJson) {
        return userService.update(postJson);
    }
    @CrossOrigin
    @RequestMapping("/delete")
    public String delete(@RequestBody String postJson) {
        return userService.delete(postJson);
    }
}
