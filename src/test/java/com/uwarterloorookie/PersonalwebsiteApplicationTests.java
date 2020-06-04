package com.uwarterloorookie;

import com.uwarterloorookie.bean.Shipin;
import com.uwarterloorookie.bean.User;
import com.uwarterloorookie.mapper.ShiPinDao;
import com.uwarterloorookie.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;


@SpringBootTest
class PersonalwebsiteApplicationTests {
//    @Autowired
//   private UserMapper userMapper;
//    @Autowired
//    private ShiPinDao shiPinDao;
   @Test
 void userRegistertest() {
//      userMapper.rigisterUser("12345","aaaaa");
//       User user1 = userMapper.getUser("122222","aaaa");
//        Assert.isNull(user1,"error: not registered");
//
   }
//
//    @Test
//    void userLogintest(){
//        User user2 = userMapper.getUser("12345","aaaaa");
//        Assert.isNull(user2,"error: no user login");
//    }
//    @Test
//    void userfollowersTest(){
//       List<User>userList = userMapper.getanotherusers(1);
//        Assertions.assertEquals(12, userList.size(),"get all followers");
//    }
//
//    @Test
//    void getshipinContexttest(){
//        List<Shipin> shipinList = shiPinDao.selectShipin(1);
//        Assert.noNullElements(shipinList,"userid is existed and has posted");
//
//    }
//    @Test
//    void getallusershiin(){
//        List<Shipin> shipinList = shiPinDao.selectShipin(1);
//        Assertions.assertEquals(4,shipinList.size(),"get all userposts");
//    }
//    @Test
//    void getshipipwithTopictext(){
//        Shipin shipin = shiPinDao.getSipinbyid(1);
//        Assert.isNull(shipin,"userid isnot existed  post is wrong");
//    }
//    @Test
//    void getShipincoments(){
//        List<Shipin> shipinList =  shiPinDao.selectfollowingShipinbyUserid(1);
//        Assertions.assertEquals(5,shipinList.size(),"get all followers");
//    }


}
