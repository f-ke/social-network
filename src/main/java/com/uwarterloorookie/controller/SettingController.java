package com.uwarterloorookie.controller;

import com.uwarterloorookie.bean.User;
import com.uwarterloorookie.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SettingController {
    @Autowired
    UserMapper userMapper;
    @GetMapping("/mysetting/{id}")
    public String getsetting(Model model, @PathVariable("id") int id){
        User user1 = userMapper.gerUserById(id);
        model.addAttribute("user", user1);
        return "setting";

    }
    @PutMapping("/editsetting")
    public String updateSetting(Model model, @RequestParam("id") int id,  @RequestParam("userName") String userName,
                                @RequestParam("passWord") String passWord, @RequestParam("email") String email,
                                @RequestParam("gender") int gender,  @RequestParam("vocation") String vocation,
                                @RequestParam("religion") String religion, @RequestParam("birthyear") int birthyear,
                                @RequestParam("birthmonth") int birthmonth, @RequestParam("birthday") int birthday){
                                userMapper.saveUserbyId(id,userName,passWord,vocation, email, religion,gender,birthyear,birthmonth,birthday);
                                 User user1 = userMapper.gerUserById(id);
                                 model.addAttribute("user",user1);
                                 return "setting";

    }

}
