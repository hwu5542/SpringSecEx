package com.wuho.SpringSecEx.controller;

import com.wuho.SpringSecEx.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
    @Autowired
    private KafkaService kafkaService;

    @GetMapping("/sendMsg")
    public String sendMsg(@RequestParam(value = "msg", defaultValue = "New student application.")String msg) {
        kafkaService.sendMsg(msg);
        return "Success";
    }
    // http://localhost:8080/sendMsg?msg=John%20sent%20application
}
