package com.selab.demo.controller;
import com.selab.demo.service.TestReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/testReview")
public class TestReviewController {
    @Autowired
    TestReviewService testReviewService;
    @RequestMapping("/insert")
    public Integer insert(@RequestBody String postJson){
        return testReviewService.insert(postJson);
    }
    @RequestMapping("/update")
    public String update(@RequestBody String postJson){
        return testReviewService.update(postJson);
    }
}
