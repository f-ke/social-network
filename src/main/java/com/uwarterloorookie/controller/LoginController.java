package com.uwarterloorookie.controller;

import com.uwarterloorookie.bean.Shipin;
import com.uwarterloorookie.bean.User;
import com.uwarterloorookie.bean.Usertopics;
import com.uwarterloorookie.mapper.UserMapper;
import com.uwarterloorookie.mapper.UsertopicMapper;
import com.uwarterloorookie.service.ShiPinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    private UsertopicMapper usertopicMapper;
    @Autowired
    private ShiPinService shiPinService;//use for test post
    @PostMapping("/user/login")

    public String login(@RequestParam("username") String userName, @RequestParam("password") String passWord, Map<String, Object> map,
                        HttpSession session, Model model) {


        User user1 =  userMapper.getUser(passWord, userName);


        if(user1 != null){
            List<Shipin> shipins=shiPinService.selectShipin(user1.getId());
            session.setAttribute("loginuser", userName);
            model.addAttribute("user",user1);
            model.addAttribute("Shipins",shipins);//use for test
            List<Usertopics> usertopicsList = usertopicMapper.SelecttopicsByuserid(user1.getId());
            model.addAttribute("mytopics",usertopicsList);
            System.out.println(user1);
           return "home";


        }else{
            map.put("msg", "Wrong password or Username");
            return "login";

        }

   }
   @GetMapping("/myhome/{id}")

   public String gethome(Model model,@PathVariable("id") int id){
       User user1 = userMapper.gerUserById(id);
       model.addAttribute("user", user1);
       List<Shipin> shipins=shiPinService.selectShipin(id);
       model.addAttribute("Shipins",shipins);
       List<Usertopics> usertopicsList = usertopicMapper.SelecttopicsByuserid(id);
       model.addAttribute("mytopics",usertopicsList);
       return "home";

   }
  @GetMapping("/mytest")

  public String gettest(){

      return "myhome/{id}";

  }
}
