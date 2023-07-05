package com.selab.demo.controller;
import com.selab.demo.model.ProcessModel;
import com.selab.demo.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/process")
public class ProcessController {
    @Autowired
    ProcessService processService;

    @RequestMapping("/insert")
    public Integer insert(@RequestBody String postJson){
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
    @RequestMapping("/byState/selectAID")
    public List<Integer> selectAIDsByState(@RequestBody String postJson){
        return processService.selectAIDsByState(postJson);
    }
    @RequestMapping("/byState/selectPID")
    public List<Integer> selectPIDsByState(@RequestBody String postJson){
        return processService.selectPIDsByState(postJson);
    }
    @RequestMapping("/findAll")
    public List<ProcessModel> findAll(){
        return processService.findAll();
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
