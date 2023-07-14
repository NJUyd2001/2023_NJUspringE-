package com.selab.demo.controller;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.util.TypeUtils;
import com.selab.demo.model.TestReviewModel;
import com.selab.demo.service.TestReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.util.TypeUtils;
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
    @RequestMapping("/select/byTRID")
    public TestReviewModel selectByTRID(@RequestBody String postJson){
        return testReviewService.selectByTRID(postJson);
    }
    @RequestMapping("/select/byPID")
    public TestReviewModel selectByPID(@RequestBody String postJson){
        return testReviewService.selectByPID(postJson);
    }
    @RequestMapping("/delete")
    public String delete(@RequestBody String postJson){
        return testReviewService.delete(postJson);
    }
}
