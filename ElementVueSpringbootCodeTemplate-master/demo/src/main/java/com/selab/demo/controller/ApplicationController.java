package com.selab.demo.controller;

import com.selab.demo.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/application")
public class ApplicationController {
    @Autowired
    ApplicationService applicationService;

    @RequestMapping("/insert")
    public String insert(@RequestBody String postJson){
        return applicationService.insert(postJson);
    }

    @RequestMapping("/checkbyapplicant")
    public String checkbyuserA(@RequestBody String postJson){
        return applicationService.checkbyuserA(postJson);
    }

    @RequestMapping("/checkbyprocess")
    public String checkbyprocess(@RequestBody String postJson){
        return applicationService.checkbyprocess(postJson);
    }

    @RequestMapping("/checkbyAID")
    public String checkbyAID(@RequestBody String postJson){
        return applicationService.checkbyAID(postJson);
    }
    @RequestMapping("/getallAID")
    public  String findAID(@RequestBody String postJson){return applicationService.findAID(postJson);}
    @RequestMapping("/updateapplication")
    public String updatrapplication(@RequestBody String postJson){
        return applicationService.updateapplication(postJson);
    }
    @RequestMapping("/deleteapplication")
    public String deleteapplication(@RequestBody String postJson){
        return applicationService.deleteapplication(postJson);
    }






}
