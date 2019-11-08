package com.fulin.controller;

import com.fulin.pojo.User;
import com.fulin.service.SendEmailService;
import com.fulin.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityManager securityManager;

    public SecurityManager getSecurityManager() {
        return securityManager;
    }

    public void setSecurityManager(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }



    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("AddPage")
    public String getAddPage(){
        return "add";
    }

    @RequestMapping("AddUser")
    public String addUser(User user,String username,String password,String target){
//        System.out.println(username);
//        System.out.println(password);
//        System.out.println(target);
//        user.setUsername(username);
//        user.setPassword(password);
//        user.setTarget(target);
        User user1 = null;
        user1.toString();
        int i = userService.addUser(user);
        if(i>0){
            return "success";
        }
        return "add";
    }

    @RequestMapping("DeleteUser")
    public String getdelete(int uid){
        int i = userService.deleteUser(uid);

        if(i>0){
            return "success";
        }
        return "add";
    }


    @RequestMapping("index")
    public String index(@RequestParam(defaultValue = "1") int pageNum, Model model){
        PageHelper.startPage(pageNum,4);
        List<User> userList = userService.getUser();
        PageInfo<User> pageInfo = new PageInfo<User>(userList);
        model.addAttribute("pageInfo",pageInfo);
        return "index";

    }

    @RequestMapping("loginPage")
    public String getlogin(){
        return "login";
    }

    @RequestMapping("login")
    public String login(User user){

        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUsername(),user.getPassword());

        try{
            subject.login(usernamePasswordToken);
            if(subject.isAuthenticated()){
                return "redirect:index";
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return "redirect:/loginPage";
    }

    @RequestMapping("unauth")
    public String unauth(){
        return "unauth";
    }

    @RequestMapping("getregister")
    public String getregister(){
        return "register";
    }

    @Autowired
    private TemplateEngine templateEngine;
    @Autowired
    private SendEmailService sendEmailService;
    @RequestMapping("register")
    public String register(User user,@RequestParam(defaultValue = "0") int register, HttpServletRequest request){


        if(register==0){

            Context context1 = new Context();
            context1.setVariable("username",user.getUsername());
            context1.setVariable("password",user.getPassword());
            context1.setVariable("target",user.getTarget());
            context1.setVariable("email",user.getEmail());
            context1.setVariable("register",1);
            String context =null;
            context = templateEngine.process("email",context1);
            System.out.println(context);
            try{
                sendEmailService.sendemail2(user.getEmail(),"确认注册",context);

                while(register!=1){
                    String password =  userService.getPasswordByUsername(user.getUsername());
                    if(password!=null){
                        break;
                    }
                }

            }catch (Exception e){
                System.out.println("邮件发送失败");
                return "doregister";
            }

        }



        if(register==1){
            userService.addUser(user);
            return "redirect:/loginPage";
        }else {
            return "redirect:getregister";
        }

    }

    @ExceptionHandler(value = NullPointerException.class)
    public String nullpoint(){
        return "nullpoint";
    }
}
