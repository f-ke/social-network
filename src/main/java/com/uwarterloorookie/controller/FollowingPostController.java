package com.uwarterloorookie.controller;

import com.uwarterloorookie.bean.Shipin;
import com.uwarterloorookie.bean.User;
import com.uwarterloorookie.bean.Userlike;
import com.uwarterloorookie.mapper.ShiPinDao;
import com.uwarterloorookie.mapper.UserMapper;
import com.uwarterloorookie.mapper.UserlikesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller

public class FollowingPostController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    ShiPinDao shiPinDao;
    @Autowired
    UserlikesMapper userlikesMapper;
    @GetMapping("/followposts/{id}")
    private String tofollowr(@PathVariable("id") int userid, Model model){
        User user1 = userMapper.gerUserById(userid);
        model.addAttribute("user", user1);
        List<Shipin> shipins=shiPinDao.selectfollowingShipinbyUserid(userid);
        model.addAttribute("Shipins",shipins);
        return "followerposts";

    }
    //to likeposts
    @GetMapping ("/mylikes/{id}")
    private String tolikes(@PathVariable("id") int userid, Model model){
        User user1 = userMapper.gerUserById(userid);
        model.addAttribute("user", user1);
        List<Shipin> shipins=shiPinDao.selectlikeShipinbyUserid(userid);
        model.addAttribute("Shipins",shipins);

        return "likeposts";
    }
}
