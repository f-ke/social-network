package com.uwarterloorookie.controller;


import com.uwarterloorookie.bean.*;
import com.uwarterloorookie.mapper.CommentsMapper;
import com.uwarterloorookie.mapper.ShiPinDao;
import com.uwarterloorookie.mapper.UserMapper;
import com.uwarterloorookie.mapper.UsertopicMapper;
import com.uwarterloorookie.service.ShiPinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
//@RequestMapping("/file")
public class MyPostCOntroller {

    @Autowired
    private ShiPinService shiPinService;

    @Autowired
    private UsertopicMapper usertopicMapper;

    @Autowired
    private ShiPinDao shiPinDao;

    @Autowired
    UserMapper userMapper;
    @Autowired
    CommentsMapper commentsMapper;

    private String url;

    @RequestMapping(value="/uploadFile",produces="application/json;charset=UTF-8")
   // @ResponseBody
  // @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("fileName") MultipartFile file,@RequestParam("content") String content,@RequestParam("userid") int userid,
                             @RequestParam("topicid") int topicid,    Model model) {

        System.out.print("上传文件==="+"\n");
        //判断文件是否为空
        if (file.isEmpty()) {
//            return "上传文件不可为空";
        }


        // 获取文件名
        String fileName = file.getOriginalFilename();
//        System.out.print("上传的文件名为: "+fileName+"\n");

        fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + fileName;
        System.out.print("（加个时间戳，尽量避免文件名称重复）保存的文件名为: "+fileName+"\n");


        //加个时间戳，尽量避免文件名称重复
        String path = "C:/upload/" +fileName;
        //String path = "E:/fileUpload/" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + fileName;
        //文件绝对路径
        System.out.print("保存文件绝对路径"+path+"\n");

        //创建文件路径
        File dest = new File(path);

        //判断文件是否已经存在
        if (dest.exists()) {
//            return "文件已经存在";
        }

        //判断文件父目录是否存在
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }

        try {
            //上传文件
            file.transferTo(dest); //保存文件
            System.out.print("保存文件路径"+path+"\n");
            url="http://localhost:8080/images/"+fileName;
            int jieguo= shiPinService.insertUrl(fileName,path,url,content,topicid);
            System.out.print("插入结果"+jieguo+"\n");
            System.out.print("保存的完整url===="+url+"\n");

        } catch (IOException e) {
            System.out.println(e);
//            return "上传失败";
        }
        User user1 = userMapper.gerUserById(userid);
        String username = userMapper.getUsernameById(userid);
        model.addAttribute("user", user1);
        String topic = usertopicMapper.Gettextbytopicid(topicid,userid);
        shiPinDao.updatetextByurl(url,topic);
        shiPinDao.updateuseridtByurl(userid,url);

        shiPinDao.updateusernametByuserid(username,userid);
        List<Shipin> shipins=shiPinService.selectShipin(userid);
        model.addAttribute("Shipins", shipins);
        List<Usertopics> usertopicsList = usertopicMapper.SelecttopicsByuserid(userid);

        model.addAttribute("mytopics",usertopicsList);


        return "home";
    }

    //查询

    @GetMapping("/view/{userid}/{id}")
    public String viewfile(@PathVariable("id") int id, @PathVariable("userid") int userid, Model model){
        User user1 = userMapper.gerUserById(userid);
        model.addAttribute("user", user1);
        shiPinDao.updateviewbyid(id);
        Shipin shipin = shiPinDao.getSipinbyid(id);
        model.addAttribute("Shipin", shipin);
        List<Comment> commentsList = commentsMapper.selectCommentsbyShipinId(id);
        model.addAttribute("postcomments",commentsList);


        return "viewpost";
    }



}

