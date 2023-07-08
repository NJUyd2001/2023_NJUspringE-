package com.selab.demo.controller;
import com.selab.demo.model.QuoteModel;
import com.selab.demo.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/quote")
public class QuoteController {
    @Autowired
    QuoteService quoteService;

    @RequestMapping("/insert")
    public String insert(@RequestBody String postJson){return quoteService.insert(postJson);}

    @RequestMapping("/find")
    public String find(@RequestBody String postJson){return quoteService.findbyPID(postJson);}

    @RequestMapping("/update")
    public String update(@RequestBody String postJson){return quoteService.update(postJson);}

    @RequestMapping("/delete")
    public String delete(@RequestBody String postJson){return quoteService.delete(postJson);}

    @RequestMapping("/findbyQID")
    public String find_(@RequestBody String postJson){return quoteService.findbyQID(postJson);}

    @RequestMapping("/updatebyQID")
    public String update_(@RequestBody String postJson){return quoteService.update_(postJson);}

    @RequestMapping("/deletebyQID")
    public String delete_(@RequestBody String postJson){return quoteService.delete_(postJson);}
}
