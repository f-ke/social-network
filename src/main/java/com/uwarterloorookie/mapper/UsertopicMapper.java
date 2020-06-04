package com.uwarterloorookie.mapper;

import com.uwarterloorookie.bean.Usertopics;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UsertopicMapper {
@Select("select * from usertopics where userid = #{userid}")
  public List<Usertopics> SelecttopicsByuserid(int userid);
@Select("select topictext from usertopics where id = #{topid} and userid = #{userid}")
  public String Gettextbytopicid(int topid, int userid);
@Select("select * from usertopics where id = #{topicid} and userid = #{userid}")
  public Usertopics getUsertopicsbysuperkey(int topicid, int userid);
@Insert("insert into usertopics(id, userid) values(#{topicid},#{userid})")
public void insertnewtopictouser(int topicid, int userid);
@Update("update usertopics set topictext = #{topicname} where id = #{topicid}")
public void updateTopicnamebyTopicId(String topicname, int topicid);
@Delete("delete from usertopics where usertopicid = #{usertopicid}")
public void deltopictouser(int usertopicid);
}
