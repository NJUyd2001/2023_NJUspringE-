package com.selab.demo.controller;;
import com.selab.demo.service.TestRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/testrecord")
public class TestRecordController {
    @Autowired
    TestRecordService testRecordService;
    @RequestMapping("/insert")
    public String insert(@RequestBody String postJson){return testRecordService.insert(postJson);}

    @RequestMapping("/find")
    public String find(@RequestBody String postJson){return testRecordService.select(postJson);}

    @RequestMapping("/update")
    public String update(@RequestBody String postJson){return testRecordService.update(postJson);}

    @RequestMapping("/delete")
    public String delete(@RequestBody String postJson){return testRecordService.delete(postJson);}
}
