package com.mhh.hzpdd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/open")
public class homeController {

    @ResponseBody
    @RequestMapping("/home")
    public String home(){
        return "hello";
    }
}
