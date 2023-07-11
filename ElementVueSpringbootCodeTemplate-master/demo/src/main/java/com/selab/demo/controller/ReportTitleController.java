package com.selab.demo.controller;
import com.selab.demo.model.ReportTitleModel;
import com.selab.demo.service.ReportTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/reporttitle")
public class ReportTitleController {
    @Autowired
    ReportTitleService reportTitleService;
    @RequestMapping("/insert")
    public String insert(@RequestBody String postJson){return reportTitleService.insert(postJson);}

    @RequestMapping("/find")
    public String find(@RequestBody String postJson){return reportTitleService.find(postJson);}

    @RequestMapping("/update")
    public String update(@RequestBody String postJson){return reportTitleService.update(postJson);}

    @RequestMapping("/delete")
    public String delete(@RequestBody String postJson){return reportTitleService.delete(postJson);}

    @RequestMapping("/findbyRTID")
    public String find_(@RequestBody String postJson){return reportTitleService.find_(postJson);}

    @RequestMapping("/updatebyRTID")
    public String update_(@RequestBody String postJson){return reportTitleService.update_(postJson);}

    @RequestMapping("/deletebyRTID")
    public String delete_(@RequestBody String postJson){return reportTitleService.delete_(postJson);}
}
