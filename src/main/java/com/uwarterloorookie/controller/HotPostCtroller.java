package com.uwarterloorookie.controller;

import com.uwarterloorookie.bean.Shipin;
import com.uwarterloorookie.bean.User;
import com.uwarterloorookie.bean.Usertopics;
import com.uwarterloorookie.mapper.ShiPinDao;
import com.uwarterloorookie.mapper.UserMapper;
import com.uwarterloorookie.mapper.UsertopicMapper;
import com.uwarterloorookie.service.ShiPinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller

public class HotPostCtroller {
    @Autowired
    UserMapper userMapper;
    @Autowired
    private ShiPinDao shiPinDao;

    @GetMapping("hotview/{id}")

    public String gethotview(Model model, @PathVariable("id") int id){
        User user1 = userMapper.gerUserById(id);
        model.addAttribute("user", user1);
        List<Shipin> shipins=shiPinDao.selectHotShipin();
        model.addAttribute("Shipins",shipins);
        return "hotview";

    }

}
