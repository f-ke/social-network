package com.uwarterloorookie.mapper;

import com.uwarterloorookie.bean.Userfollowers;
import com.uwarterloorookie.bean.Usertopics;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserfollowerMapper {
    @Select("select * from userfollowers where userid = #{userid} and followerid = #{followerid}")
    public Userfollowers getUserfollowersbysuperkey(int userid, int followerid);
    @Insert("insert into userfollowers(userid, followerid) values(#{userid},#{followerid})")
    public void insertnewfollertouser(int userid, int followerid) ;

    @Delete("delete from userfollowers where userfollowerid = #{userfollowerid}")
    public void delfollowertouser(int userfollowerid) ;
}
