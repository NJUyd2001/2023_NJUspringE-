package com.selab.demo.controller;

import com.selab.demo.service.InsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// test insert
@RestController
@CrossOrigin
@RequestMapping("/test")
public class InsertController {
    @Autowired
    InsertService insertService;
    @CrossOrigin
    @RequestMapping("/insert")//  insert interface
    public String insert(@RequestParam String postJson){

        return insertService.insert(postJson);
        // insertService.insert(postJson);

    }
}
