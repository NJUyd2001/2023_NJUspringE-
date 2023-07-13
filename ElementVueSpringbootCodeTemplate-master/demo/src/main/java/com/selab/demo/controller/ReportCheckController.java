package com.selab.demo.controller;
import com.selab.demo.service.RecordCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/reportcheck")
public class ReportCheckController {

    @Autowired
    RecordCheckService recordCheckService;
    @RequestMapping("/insert")
    public String insert(@RequestBody String postJson){return recordCheckService.insert(postJson);}

    @RequestMapping("/find")
    public String find(@RequestBody String postJson){return recordCheckService.select(postJson);}

    @RequestMapping("/update")
    public String update(@RequestBody String postJson){return recordCheckService.update(postJson);}

    @RequestMapping("/delete")
    public String delete(@RequestBody String postJson){return recordCheckService.delete(postJson);}
}
