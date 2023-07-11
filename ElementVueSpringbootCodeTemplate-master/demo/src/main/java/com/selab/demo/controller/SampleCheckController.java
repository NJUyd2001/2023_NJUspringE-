package com.selab.demo.controller;
import com.selab.demo.model.SampleCheckModel;
import com.selab.demo.service.SampleCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/samplecheck")
public class SampleCheckController {
    @Autowired
    SampleCheckService sampleCheckService;
    @RequestMapping("/insert")
    public String insert(@RequestBody String postJson){return sampleCheckService.insert(postJson);}

    @RequestMapping("/find")
    public String find(@RequestBody String postJson){return sampleCheckService.find(postJson);}

    @RequestMapping("/update")
    public String update(@RequestBody String postJson){return sampleCheckService.update(postJson);}

    @RequestMapping("/delete")
    public String delete(@RequestBody String postJson){return sampleCheckService.delete(postJson);}


}
