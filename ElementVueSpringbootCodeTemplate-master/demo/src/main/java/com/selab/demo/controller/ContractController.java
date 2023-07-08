package com.selab.demo.controller;
import com.selab.demo.model.ContractModel;
import com.selab.demo.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    ContractService contractService;

    @RequestMapping("/insert")
    public String insert(@RequestBody String postJson){return contractService.insert(postJson);}

    @RequestMapping("/find")
    public String find(@RequestBody String postJson){return contractService.select(postJson);}

    @RequestMapping("/update")
    public String update(@RequestBody String postJson){return contractService.update(postJson);}

    @RequestMapping("/delete")
    public String delete(@RequestBody String postJson){return contractService.delete(postJson);}

    @RequestMapping("/findbyCID")
    public String find_(@RequestBody String postJson){return contractService.select_(postJson);}

    @RequestMapping("/updatebyCID")
    public String update_(@RequestBody String postJson){return contractService.update_(postJson);}

    @RequestMapping("/deletebyCID")
    public String delete_(@RequestBody String postJson){return contractService.delete_(postJson);}
}
