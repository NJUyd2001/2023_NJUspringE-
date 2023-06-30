package com.selab.demo.controller;

import com.selab.demo.service.InsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// test insert
@RestController
@CrossOrigin
@RequestMapping("/test")
public class InsertController {
    @Autowired
    InsertService insertService;
    @CrossOrigin
    @RequestMapping("/insert")//  insert interface
    public String insert(@RequestBody String postJson){

        return insertService.insert(postJson);
        // insertService.insert(postJson);

    }
    @CrossOrigin
    @RequestMapping("/insertID")
    public String insertID(@RequestBody String postJson){
        return insertService.insertID(postJson);
    }

}
