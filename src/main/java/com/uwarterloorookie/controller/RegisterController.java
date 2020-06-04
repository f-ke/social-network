package com.uwarterloorookie.controller;

import com.uwarterloorookie.bean.User;
import com.uwarterloorookie.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class RegisterController {
    @Autowired
    UserMapper userMapper;

    @GetMapping("/toregister")
    public String getRegister(){
        return "register";
    }

    @PostMapping("/user/register")
    public String register(@RequestParam("username") String userName, @RequestParam("password") String passWord, @RequestParam("password2") String passWord2, Map<String, Object> map,
                        Model model){
        User user1 =  userMapper.getUser(passWord, userName);
        User user2 = userMapper.getUserbyName(userName);
        if(user2 != null){
            map.put("msg","this name is registered");
            return "register";
        }

        if(!passWord2.equals(passWord)){
            map.put("msg","password should be same");
            return "register";
        }
        userMapper.rigisterUser(passWord, userName);
         map.put("msg2","register successed");
        return "login";

       }
}
