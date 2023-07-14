package com.selab.demo.controller;

import com.selab.demo.model.SoftwareDocReviewModel;
import com.selab.demo.model.TestReviewModel;
import com.selab.demo.service.SoftwareDocReviewService;
import com.selab.demo.service.TestReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/softwareDocReview")
public class SoftwareDocReviewController {
    @Autowired
    SoftwareDocReviewService softwareDocReviewService;

    @RequestMapping("/insert")
    public Integer insert(@RequestBody String postJson){
        return softwareDocReviewService.insert(postJson);
    }
    @RequestMapping("/update/main")
    public String updateMain(@RequestBody String postJson){
        return softwareDocReviewService.updateMain(postJson);
    }
    @RequestMapping("/update/item")
    public String updateItem(@RequestBody String postJson){
        return softwareDocReviewService.updateItem(postJson);
    }
    @RequestMapping("/select/bySDRID")
    public SoftwareDocReviewModel selectBySDRID(@RequestBody String postJson){
        return softwareDocReviewService.selectBySDRID(postJson);
    }
    @RequestMapping("/select/byPID")
    public SoftwareDocReviewModel selectByPID(@RequestBody String postJson){
        return softwareDocReviewService.selectByPID(postJson);
    }
    @RequestMapping("/delete")
    public String delete(@RequestBody String postJson){
        return softwareDocReviewService.delete(postJson);
    }
}
