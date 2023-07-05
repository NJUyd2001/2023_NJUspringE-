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
    @RequestMapping("/getall")
    public String findall(@RequestBody String postJson){return applicationService.findALL(postJson);}
    @RequestMapping("/updateapplication")
    public String updatrapplication(@RequestBody String postJson){
        return applicationService.updateapplication(postJson);
    }
    @RequestMapping("/deleteapplication")
    public String deleteapplication(@RequestBody String postJson){
        return applicationService.deleteapplication(postJson);
    }
    @RequestMapping("/inserttabledata")
    public String insertruleform(@RequestBody String postJson){
        return  applicationService.insertruleform(postJson);
    }

    @RequestMapping("/updatetabledata")
    public String updateruleform(@RequestBody String postJson){
        return  applicationService.updateruleform(postJson);
    }

    @RequestMapping("/gettabledata")
    public String getruleform(@RequestBody String postJson){
        return  applicationService.getruleform(postJson);
    }

    @RequestMapping("/deletetabledata")
    public String deleteruleform(@RequestBody String postJson){
        return  applicationService.deleteruleform(postJson);
    }
    @RequestMapping("/insertopinion")
    public String insertopinion(@RequestBody String postJson){
        return  applicationService.insertopinion(postJson);
    }

    @RequestMapping("/findopinion")
    public String findopinion(@RequestBody String postJson){
        return applicationService.findopinion(postJson);
    }

    @RequestMapping("/insertauditinformation")
    public String insertauditinformation(@RequestBody String postJson){
        return applicationService.insertauditinformation(postJson);
    }

    @RequestMapping("/findauditinformation")
    public String findauditinformation(@RequestBody String postJson){
        return applicationService.findauditinformation(postJson);
    }

    @RequestMapping("/deleteauditinformation")
    public String deleteauditinformation(@RequestBody String postJson){
        return applicationService.deleteauditinformation(postJson);
    }



}
