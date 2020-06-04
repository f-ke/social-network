package com.uwarterloorookie.controller;

import com.uwarterloorookie.bean.Comment;
import com.uwarterloorookie.bean.Shipin;
import com.uwarterloorookie.bean.User;
import com.uwarterloorookie.mapper.CommentsMapper;
import com.uwarterloorookie.mapper.ShiPinDao;
import com.uwarterloorookie.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@Controller

public class PostCommentController {
    @Autowired
    private ShiPinDao shiPinDao;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private  CommentsMapper commentsMapper;

    @PostMapping("/postcomment")
    private String postcomment(Model model, @RequestParam("shipinid") int shipinid, @RequestParam("userid") int userid,
                               @RequestParam("text") String text
                               ){
        User user1 = userMapper.gerUserById(userid);

        model.addAttribute("user", user1);


        commentsMapper.insertComment(userid, shipinid, text);
        String username = userMapper.getUsernameById(userid);
        commentsMapper.updateUserNameByuserId(userid, username);

        List<Comment> commentsList = commentsMapper.selectCommentsbyShipinId(shipinid);
        int commentsnums = commentsList.size();
        shiPinDao.updateCommentsById(commentsnums,shipinid);
        Shipin shipin = shiPinDao.getSipinbyid(shipinid);
        model.addAttribute("Shipin", shipin);
        model.addAttribute("postcomments",commentsList);

        return "viewpost";
    }


}
