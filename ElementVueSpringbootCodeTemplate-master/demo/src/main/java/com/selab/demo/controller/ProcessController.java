package com.selab.demo.controller;
import com.selab.demo.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/process")
public class ProcessController {
    @Autowired
    ProcessService processService;

    @RequestMapping("/insert")
    public String insert(@RequestBody String postJson){
        return processService.insert(postJson);
    }


    @RequestMapping("/findbyclientid")
    public String findbyclient_id(@RequestBody String postJson){
        return processService.findbyclient_id(postJson);
    }



    @RequestMapping("/findbyPID")
    public String findbyPID(@RequestBody String postJson){
        return processService.findbyPID(postJson);
    }

    @RequestMapping("/update")
    public String update(@RequestBody String postJson){return processService.update(postJson);}
    @RequestMapping("/delete")
    public String delete(@RequestBody String postJson){
        return processService.delete(postJson);
    }

}
