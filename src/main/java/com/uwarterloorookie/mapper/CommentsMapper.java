package com.uwarterloorookie.mapper;

import com.uwarterloorookie.bean.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CommentsMapper {
    @Insert("insert into comments (userid,shipinid,text) values (#{userid},#{shipinid},#{text})")
    public void insertComment( int userid, int shipinid,  String text);

    @Select("select * from comments where shipinid = #{shipinid}")
    public List<Comment> selectCommentsbyShipinId(int shipinid);
    @Select("select count(*) from comments where id = #{shipinid}")
    public int getCommentsnumByid(int shipinid);
    @Update("update comments set username = #{username} where userid = #{userid}")
    public void updateUserNameByuserId(int userid, String username);


}
