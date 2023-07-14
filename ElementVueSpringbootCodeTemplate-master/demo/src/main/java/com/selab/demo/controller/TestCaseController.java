package com.selab.demo.controller;
import com.selab.demo.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/testcase")
public class TestCaseController {
    @Autowired
    TestCaseService testCaseService;
    @RequestMapping("/insert")
    public String insert(@RequestBody String postJson){return testCaseService.insert(postJson);}

    @RequestMapping("/find")
    public String find(@RequestBody String postJson){return testCaseService.select(postJson);}

    @RequestMapping("/update")
    public String update(@RequestBody String postJson){return testCaseService.update(postJson);}

    @RequestMapping("/delete")
    public String delete(@RequestBody String postJson){return testCaseService.delete(postJson);}
}
