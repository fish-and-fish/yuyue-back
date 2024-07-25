//package com.amrni.sport.shop.controller;
//
//import java.util.List;
//
//import javax.annotation.Resource;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.amrni.sport.shop.email.EmailService;
//import com.amrni.sport.shop.jpa.TestJpa;
//import com.amrni.sport.shop.model.Test;
//import com.amrni.sport.shop.service.TestService;
//import com.google.common.collect.Lists;
//
//@RestController
//@RequestMapping("")
//public class aCon {
//
//    @Resource
//    TestJpa testJpa;
//
//    @Resource
//    TestService testService;
//
//    @Resource
//    EmailService emailService;
//
//    @GetMapping("")
//    public String f(){
//        List<Test> tests = testService.listByIds(Lists.newArrayList(602931338261204992L));
//        tests.forEach(t -> t.setName("----"));
//        testService.saveOrUpdateBatch(tests);
//        return "all.toString();;";
//    }
//
//    @GetMapping("/email")
//    public String email(){
//        emailService.sendSimpleMail("","","");
//        return "all.toString();;";
//    }
//}
