package com.selab.demo.controller;;
import com.selab.demo.service.SoftwareDocCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/softwaredoccheck")
public class SoftwareDocCheckController {
    @Autowired
    SoftwareDocCheckService softwareDocCheckService;
    @RequestMapping("/insert")
    public String insert(@RequestBody String postJson){return softwareDocCheckService.insert(postJson);}

    @RequestMapping("/find")
    public String find(@RequestBody String postJson){return softwareDocCheckService.select(postJson);}

    @RequestMapping("/update")
    public String update(@RequestBody String postJson){return softwareDocCheckService.update(postJson);}

    @RequestMapping("/delete")
    public String delete(@RequestBody String postJson){return softwareDocCheckService.delete(postJson);}
}
