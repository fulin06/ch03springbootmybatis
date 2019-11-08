package com.fulin.controller;

import com.fulin.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Controller
public class MailController {

    @Autowired
    private SendEmailService sendEmailService;

    public SendEmailService getSendEmailService() {
        return sendEmailService;
    }

    public void setSendEmailService(SendEmailService sendEmailService) {
        this.sendEmailService = sendEmailService;
    }

    @RequestMapping("SendMail")
    public String sendmail(String toUser,String title,String context){

        System.out.println(context);
        sendEmailService.sendemail(toUser,title,context);

        return "redirect:index";

    }

    @Autowired
    private TemplateEngine templateEngine;


    @RequestMapping("getsendemail")
    public String getsendemail(){
        return "sendemail";
    }


    @RequestMapping("SendMail2")
    public String sendmail2(String toUser,String title,String context){
        Context context1 = new Context();

        context1.setVariable("id",123456);

        context = templateEngine.process("email",context1).toString();
        System.out.println(context);

        sendEmailService.sendemail2(toUser,title,context);

        return "redirect:index";
    }

}
