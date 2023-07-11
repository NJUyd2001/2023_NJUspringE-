package com.selab.demo.controller;
import com.selab.demo.service.AgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
@RequestMapping("/agreement")

public class AgreementController {
    @Autowired
    AgreementService agreementService;

    @RequestMapping("/insert")
    public String insert(@RequestBody String postJson){return agreementService.insert(postJson);}

    @RequestMapping("/find")
    public String find(@RequestBody String postJson){return agreementService.select(postJson);}

    @RequestMapping("/update")
    public String update(@RequestBody String postJson){return agreementService.update(postJson);}

    @RequestMapping("/delete")
    public String delete(@RequestBody String postJson){return agreementService.delete(postJson);}

    @RequestMapping("/findbyAgID")
    public String find_(@RequestBody String postJson){return agreementService.select_(postJson);}

    @RequestMapping("/updatebyAgID")
    public String update_(@RequestBody String postJson){return agreementService.update_(postJson);}

    @RequestMapping("/deletebyAgID")
    public String delete_(@RequestBody String postJson){return agreementService.delete_(postJson);}
}
