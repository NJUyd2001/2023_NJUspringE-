package com.selab.demo.controller;
import com.selab.demo.model.TestEnvironmentModel;
import com.selab.demo.service.SoftwareTestService;
import com.selab.demo.service.TestEnvironmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/testenvironment")
public class TestEnvironmentController {
    @Autowired
    TestEnvironmentService testEnvironmentService;
    @RequestMapping("/insert")
    public String insert(@RequestBody String postJson){return testEnvironmentService.insert(postJson);}

    @RequestMapping("/find")
    public String find(@RequestBody String postJson){return testEnvironmentService.select(postJson);}

    @RequestMapping("/update")
    public String update(@RequestBody String postJson){return testEnvironmentService.update(postJson);}

    @RequestMapping("/delete")
    public String delete(@RequestBody String postJson){return testEnvironmentService.delete(postJson);}
}
