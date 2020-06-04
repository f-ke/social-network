package com.uwarterloorookie.controller;

import com.uwarterloorookie.bean.Comment;
import com.uwarterloorookie.bean.Shipin;
import com.uwarterloorookie.bean.User;
import com.uwarterloorookie.bean.Userlike;
import com.uwarterloorookie.mapper.CommentsMapper;
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
public class LikeController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    ShiPinDao shiPinDao;
    @Autowired
    UserlikesMapper userlikesMapper;
    @Autowired
    CommentsMapper commentsMapper;
    @GetMapping("/likeorunlike/{userid}/{id}")
    public String likeornot(@PathVariable("id") int id, @PathVariable("userid") int userid, Model model){
        User user1 = userMapper.gerUserById(userid);
        model.addAttribute("user", user1);
        Userlike userlike = userlikesMapper.checkifLike(userid, id);
        if(userlike != null){
            shiPinDao.minuslikenumsbyid(id);
            userlikesMapper.deluserlike(userlike.getUserlikeid());

        }else{
            shiPinDao.addlikenumsbyid(id);
            userlikesMapper.insertuserlike(userid, id);

        }
        model.addAttribute("iuserlike",userlike);
        Shipin shipin = shiPinDao.getSipinbyid(id);
        model.addAttribute("Shipin", shipin);
        List<Comment> commentsList = commentsMapper.selectCommentsbyShipinId(id);
        model.addAttribute("postcomments",commentsList);
        return "viewpost";
    }
}
