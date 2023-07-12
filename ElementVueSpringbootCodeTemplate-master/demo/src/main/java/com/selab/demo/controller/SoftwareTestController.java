package com.selab.demo.controller;
import com.selab.demo.model.SampleCheckModel;
import com.selab.demo.model.SoftwareTestModel;
import com.selab.demo.service.SoftwareTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/softwaretest")
public class SoftwareTestController {
    @Autowired
    SoftwareTestService softwareTestService;
    @RequestMapping("/insert")
    public String insert(@RequestBody String postJson){return softwareTestService.insert(postJson);}

    @RequestMapping("/find")
    public String find(@RequestBody String postJson){return softwareTestService.select(postJson);}

    @RequestMapping("/update")
    public String update(@RequestBody String postJson){return softwareTestService.update(postJson);}

    @RequestMapping("/delete")
    public String delete(@RequestBody String postJson){return softwareTestService.delete(postJson);}


}
