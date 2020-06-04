package com.uwarterloorookie.controller;



import com.uwarterloorookie.bean.Topic;
import com.uwarterloorookie.bean.User;
import com.uwarterloorookie.bean.Usertopics;
import com.uwarterloorookie.mapper.TopicMapper;
import com.uwarterloorookie.mapper.UserMapper;
import com.uwarterloorookie.mapper.UsertopicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TopicController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    TopicMapper topicMapper;
    @Autowired
    UsertopicMapper usertopicMapper;
    int userid;
    @GetMapping("/topics/{id}")
    public String gettopic(Model model, @PathVariable("id") int id){
        User user1 = userMapper.gerUserById(id);
        userid = user1.getId();
        model.addAttribute("user", user1);
        List<Topic> getalltopics = topicMapper.getalltopics();
        for (int i = 0; i < getalltopics.size();i++){
            int tid = getalltopics.get(i).getTopicid();
            Usertopics usertopics1 = usertopicMapper.getUsertopicsbysuperkey(tid, userid);
            getalltopics.get(i).setUsertopics(usertopics1);
        }//usertopic update usertopics

        model.addAttribute("topics",getalltopics);
        return"topic";

    }

    @PostMapping("/follow")
    public String followeornot(Model model, @RequestParam("topicid") int topicid,
                               @RequestParam("userid") int userid){
        User user1 = userMapper.gerUserById(userid);
        model.addAttribute("user", user1);
        System.out.println("model = " + model + ", topicid = " + topicid + ", userid = " + userid);
        List<Topic> getalltopics = topicMapper.getalltopics();

        Usertopics usertopics = usertopicMapper.getUsertopicsbysuperkey(topicid, userid);//if user is followr or not
//        model.addAttribute("utopic",usertopics); try to convert color

        if(usertopics != null){
            usertopicMapper.deltopictouser(usertopics.getUsertopicid());//delete
        }else{
            usertopicMapper.insertnewtopictouser(topicid,userid);
            Topic topicById = topicMapper.getTopicById(topicid);
            usertopicMapper.updateTopicnamebyTopicId(topicById.getTopicname(),topicid);//add

        }

        for(int i = 0; i < getalltopics.size();i++){
            int tid = getalltopics.get(i).getTopicid();
            Usertopics usertopics1 = usertopicMapper.getUsertopicsbysuperkey(tid, userid);
            getalltopics.get(i).setUsertopics(usertopics1);
        }

        model.addAttribute("topics",getalltopics);

        return"topic";

    }

}
