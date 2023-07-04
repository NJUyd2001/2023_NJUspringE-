package com.selab.demo.controller;
import com.selab.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/message")
public class MessageController {

    @Autowired
    MessageService messageService;

    @RequestMapping("/insert")
    public String insert(@RequestBody String postJson){return messageService.insert(postJson);}

    @RequestMapping("/findbyMID")
    public String findbyMID(@RequestBody String postJson){return messageService.findbyMID(postJson);}

    @RequestMapping("/findbysender")
    public String findbysender_id(@RequestBody String postJson){return messageService.findbysender_id((postJson));}

    @RequestMapping("/findbyreceiver")
    public String findbyreceiver_id(@RequestBody String postJson){return messageService.findbyreceiver_id(postJson);}

    @RequestMapping("/update")
    public String update(@RequestBody String postJson){return messageService.update(postJson);}

    @RequestMapping("/delete")
    public String delete(@RequestBody String postJson){return messageService.delete(postJson);}
}
