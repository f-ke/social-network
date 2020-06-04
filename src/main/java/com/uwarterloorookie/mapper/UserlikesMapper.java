package com.uwarterloorookie.mapper;

import com.uwarterloorookie.bean.Userlike;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserlikesMapper {

    @Select("select * from userlikes where userid = #{userid} and shipinid = #{shipinid}")
    public Userlike checkifLike(int userid, int shipinid);


    @Insert("insert into userlikes(userid, shipinid) values(#{userid},#{shipinid})")
    public void insertuserlike(int userid, int shipinid) ;

    @Delete("delete from userlikes where userlikeid = #{userlikeid}")
    public void deluserlike(int userlikeid) ;


}
