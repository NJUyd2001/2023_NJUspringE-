package com.selab.demo.controller;
import com.selab.demo.model.ProcessModel;
import com.selab.demo.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/process")
public class ProcessController {
    @Autowired
    ProcessService processService;

    @RequestMapping("/insert")
    public String insert(@RequestBody String postJson){
        return processService.insert(postJson);
    }


    @RequestMapping("/findByUID")
    public List<ProcessModel> findByUID(@RequestBody String postJson){
        return processService.findByUID(postJson);
    }

    @RequestMapping("/findByAID")
    public List<ProcessModel> findByAID(@RequestBody String postJson){
        return processService.findByAID(postJson);
    }


    @RequestMapping("/findByPID")
    public ProcessModel findByPID(@RequestBody String postJson){
        return processService.findByPID(postJson);
    }

    @RequestMapping("/update")
    public String update(@RequestBody String postJson){return processService.update(postJson);}
    @RequestMapping("/delete")
    public String delete(@RequestBody String postJson){
        return processService.delete(postJson);
    }

}
