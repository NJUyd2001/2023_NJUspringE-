package com.selab.demo.controller;
import com.selab.demo.service.TesttheContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/testcontent")
public class TesttheContentController {
    @Autowired
    TesttheContentService testtheContentService;
    @RequestMapping("/insert")
    public String insert(@RequestBody String postJson){return testtheContentService.insert(postJson);}

    @RequestMapping("/find")
    public String find(@RequestBody String postJson){return testtheContentService.select(postJson);}

    @RequestMapping("/update")
    public String update(@RequestBody String postJson){return testtheContentService.update(postJson);}

    @RequestMapping("/delete")
    public String delete(@RequestBody String postJson){return testtheContentService.delete(postJson);}
}
