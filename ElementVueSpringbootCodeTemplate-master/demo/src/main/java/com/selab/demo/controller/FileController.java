package com.selab.demo.controller;

import com.selab.demo.service.FileService;
import com.selab.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    FileService fileService;
    @CrossOrigin
    @RequestMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file){
        return fileService.upload(file);
    }
}
