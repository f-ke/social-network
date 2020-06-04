package com.uwarterloorookie.controller;

import com.uwarterloorookie.bean.Topic;
import com.uwarterloorookie.bean.User;
import com.uwarterloorookie.bean.Userfollowers;

import com.uwarterloorookie.mapper.UserMapper;
import com.uwarterloorookie.mapper.UserfollowerMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Controller
public class FollowerController {


    @Autowired
    UserMapper userMapper;

    @Autowired
    UserfollowerMapper userfollowerMapper;

    @GetMapping("/mypeople/{id}")
    public String getpeople(Model model, @PathVariable("id") int id){
        User user1 = userMapper.gerUserById(id);

        model.addAttribute("user", user1);
        List<User> getallAnotherUsers = userMapper.getanotherusers(user1.getId());
        for (int i = 0; i < getallAnotherUsers.size();i++){
            int fid = getallAnotherUsers.get(i).getId();
            Userfollowers  userfollowers1 = userfollowerMapper.getUserfollowersbysuperkey(id, fid);
            getallAnotherUsers.get(i).setUserfollowers(userfollowers1);
        }

        model.addAttribute("followers",getallAnotherUsers);
        return"people";

    }

    @PostMapping("/pepolefollow")
    public String followeornot(Model model, @RequestParam("followerid") int followerid,
                               @RequestParam("userid") int userid){
        User user1 = userMapper.gerUserById(userid);
        model.addAttribute("user", user1);

        List<User> getallAnotherUsers = userMapper.getanotherusers(user1.getId());

        Userfollowers userfollowers = userfollowerMapper.getUserfollowersbysuperkey(userid, followerid);//if user is followr or not
//        model.addAttribute("utopic",usertopics); try to convert color

        if(userfollowers != null){
            userfollowerMapper.delfollowertouser(userfollowers.getUserfollowerid());//delete
        }else{
            userfollowerMapper.insertnewfollertouser(userid, followerid);
        }

        for (int i = 0; i < getallAnotherUsers.size();i++){
            int fid = getallAnotherUsers.get(i).getId();
            Userfollowers  userfollowers1 = userfollowerMapper.getUserfollowersbysuperkey(userid, fid);
            getallAnotherUsers.get(i).setUserfollowers(userfollowers1);
        }

        model.addAttribute("followers",getallAnotherUsers);

        return"people";

    }

}
