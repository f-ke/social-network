package com.uwarterloorookie.controller;

import com.uwarterloorookie.bean.Shipin;
import com.uwarterloorookie.bean.User;
import com.uwarterloorookie.mapper.ShiPinDao;
import com.uwarterloorookie.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchPeopleController {
    @Autowired
    ShiPinDao shiPinDao;
   @Autowired
   UserMapper userMapper;

   @GetMapping("/searchpeople")
    private String serachPeople(@RequestParam("username") String userName, @RequestParam("userid") int id, Model model){
        User user1 = userMapper.gerUserById(id);
        User user2 = userMapper.getUserbyName(userName);
        model.addAttribute("user", user1);
        List<Shipin> shipins= shiPinDao.selectShipin(user2.getId());
        model.addAttribute("Shipins",shipins);
        return "hotview";

    }
}
