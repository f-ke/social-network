package com.uwarterloorookie.mapper;


import com.uwarterloorookie.bean.Shipin;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ShiPinDao {

    //插入
    @Insert({"insert into shipins (name,lujing,url,content,topicid) values (#{name},#{lujing},#{url},#{content},#{topicid})"})
    public int insertUrl(@Param("name") String name, @Param("lujing") String lujing, @Param("url") String url,@Param("content") String content,int topicid);


    //查询
    @Select("select * from shipins where userid = #{userid} order by id desc ")
    public List<Shipin> selectShipin(int userid);

    @Select("select * from shipins where id = #{id}")
    public Shipin getSipinbyid(@Param("id") int id);
    @Select("select * from shipins order by view desc")
    public List<Shipin> selectHotShipin();
    @Select("select * from shipins where topicid = #{topicid} order by view desc")
    public List<Shipin> selectHotShipinbytopic(int topicid);
    @Select("SELECT * FROM Shipins INNER JOIN userlikes ON shipins.`id` = userlikes.`shipinid` WHERE userlikes.`userid`=#{userid}" +
            " ORDER BY shipins.`id` DESC")
    public List<Shipin> selectlikeShipinbyUserid(int userid);

    @Select("SELECT * FROM Shipins INNER JOIN userfollowers ON shipins.`userid` = userfollowers.`followerid` WHERE userfollowers.`userid`=#{userid}" +
            " ORDER BY shipins.`id` DESC")
    public List<Shipin> selectfollowingShipinbyUserid(int userid);

    @Update("update shipins set view  = view + 1 where id = #{id}")
    public void updateviewbyid(@Param("id") int id);
    @Update("update shipins set topictext = #{text} where url = #{url}")
    public void updatetextByurl(String url, String text);
    @Update("update shipins set userid = #{userid} where url = #{url}")
    public void updateuseridtByurl(int userid, String url);
    @Update("update shipins set username = #{username} where userid = #{userid}")
    public void updateusernametByuserid(String username, int userid);
    @Update("update shipins set commentnums = #{commentnums} where id = #{id}")
    public void updateCommentsById(int commentnums, int id);
    @Update("update shipins set likenums  = likenums + 1 where id = #{id}")
    public void addlikenumsbyid(@Param("id") int id);
    @Update("update shipins set likenums  = likenums - 1 where id = #{id}")
    public void minuslikenumsbyid(@Param("id") int id);

}
