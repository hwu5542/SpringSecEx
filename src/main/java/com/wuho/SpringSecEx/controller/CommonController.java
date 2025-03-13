package com.wuho.SpringSecEx.controller;

import com.wuho.SpringSecEx.service.CommonService;
import com.wuho.SpringSecEx.service.SerDeser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {
    @Autowired
    CommonService commonService;

    @Autowired
    SerDeser serDeser;

    @GetMapping("/common")
    public String getCommon() throws NoSuchMethodException {
        commonService.sayHello();
        serDeser.serDeser();
        return "Success";
    }
}
