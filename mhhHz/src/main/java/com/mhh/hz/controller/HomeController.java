package com.mhh.hz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mhh.hz.entity.DouyinChild;

@Controller
public class HomeController {

    @ResponseBody
    @GetMapping("/")
    public DouyinChild home(){
        return new DouyinChild();
    }
}
