package com.selab.demo.controller;

import com.selab.demo.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/application")
public class ApplicationController {
    @Autowired
    ApplicationService applicationService;

    @RequestMapping("/insert")
    public String insert(@RequestBody String postJson){
        return applicationService.insert(postJson);
    }

    @GetMapping("/checkbyapplicant")
    public String checkbyuserA(@RequestBody String postJson){
        return applicationService.checkbyuserA(postJson);
    }

    @GetMapping("/checkbyauditor")
    public String checkbyuserB(@RequestBody String postJson){
        return applicationService.checkbyuserB(postJson);
    }

    @GetMapping("/checkbyAID")
    public String checkbyAID(@RequestBody String postJson){
        return applicationService.checkbyAID(Integer.valueOf(postJson).intValue());
    }
    @GetMapping("/updateapplication")
    public String updatrapplication(@RequestBody String postJson){
        return applicationService.updateapplication(postJson);
    }
    @GetMapping("/deleteapplication")
    public String deleteapplication(@RequestBody String postJson){
        return applicationService.deleteapplication(Integer.valueOf(postJson).intValue());
    }






}
