package com.amrni.sport.shop.email;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class EmailService {

    @Resource
    private JavaMailSender javaMailSender;

//    @PostConstruct
    public void f(){
        sendSimpleMail("","","");
    }

    public void sendSimpleMail(String to, String subject, String content) {
        //创建SimpleMailMessage对象
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件发送人
        message.setFrom("djiaoguai@163.com");
        //邮件接收人
        message.setTo("838230972@qq.com");
        //邮件主题
        message.setSubject("subject");
        //邮件内容
        message.setText("content");
        //发送邮件
        javaMailSender.send(message);
    }

//
//    public void sendMail(String toEmail, String subject, String content) throws MessagingException {
//
//        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//        try {
//            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
//            messageHelper.setSubject("Thanks for signing up at SpeederSolutions");
//            messageHelper.setFrom("djiaoguai@163.com");
//            // 设置接收人，可以有多个supplier
//            messageHelper.setTo("838230972@qq.com");
//            // 设置发送日期
//            mimeMessage.setSubject(subject);
//            //邮件内容，html格式
//            messageHelper.setText(content, true);
//            //发送
//            messageHelper.send(mimeMessage);
//
//            // 调用邮件发送接口方法
//            javaMailSender.send(mimeMessage);
////            log.debug("邮件已经发送，{}",mimeMessage);
//        } catch (MessagingException e) {
////            log.error("exception -- error log, ", e);
////            log.error("邮件发送失败，{}",e.getMessage());
////            throw  new MyException("邮件发送失败");
//            throw e;
//        }
//    }
}
