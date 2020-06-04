package com.uwarterloorookie.controller;

import com.uwarterloorookie.bean.Shipin;
import com.uwarterloorookie.bean.User;
import com.uwarterloorookie.mapper.ShiPinDao;
import com.uwarterloorookie.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ViewtopicController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    private ShiPinDao shiPinDao;
    @GetMapping("/viewtopic/{userid}/{topicid}")
    private String viewHotTopic(Model model, @PathVariable("userid") int userid, @PathVariable("topicid") int topicid){
        User user1 = userMapper.gerUserById(userid);
        model.addAttribute("user", user1);
        List<Shipin> shipins=shiPinDao.selectHotShipinbytopic(topicid);
        model.addAttribute("Shipins",shipins);
        return "hotview";
    }
}
