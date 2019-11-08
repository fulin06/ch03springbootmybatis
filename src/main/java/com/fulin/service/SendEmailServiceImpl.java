package com.fulin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class SendEmailServiceImpl implements SendEmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    private String fromUser="m15066283823@163.com";

    @Override
    public void sendemail(String toUser, String title, String content) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject(title);
        simpleMailMessage.setFrom(fromUser);
        simpleMailMessage.setTo(toUser);
        simpleMailMessage.setText(content);

        try{
            javaMailSender.send(simpleMailMessage);
        }catch (Exception e){
            System.out.println("发送失败");
            e.printStackTrace();
        }

    }


    @Override
    public void sendemail2(String toUser, String title,String context) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = null;


        try {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
            mimeMessageHelper.setSubject(title);
            mimeMessageHelper.setFrom(fromUser);
            mimeMessageHelper.setTo(toUser);
            mimeMessageHelper.setText(context,true);
            javaMailSender.send(mimeMessage);

        } catch (MessagingException e) {
            System.out.println("发送失败");
            e.printStackTrace();
        }


    }
}
