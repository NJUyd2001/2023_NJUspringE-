package com.selab.demo.controller;
import com.selab.demo.model.ReportMainModel;
import com.selab.demo.service.ReportMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/reportmain")
public class ReportMainController {
    @Autowired ReportMainService reportMainService;

    @RequestMapping("/insert")
    public String insert(@RequestBody String postJson){return reportMainService.insert(postJson);}

    @RequestMapping("/find")
    public String find(@RequestBody String postJson){return reportMainService.find(postJson);}

    @RequestMapping("/update")
    public String update(@RequestBody String postJson){return reportMainService.update(postJson);}
    @RequestMapping("/delete")
    public String delete(@RequestBody String postJson){return reportMainService.delete(postJson);}

}
