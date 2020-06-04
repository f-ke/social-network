package com.uwarterloorookie.mapper;

import com.uwarterloorookie.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {
    @Insert("insert into users(userName, passWord) values(#{userName}, #{passWord})")
    public void rigisterUser(String passWord, String userName);
    @Select("select * from users where passWord = #{passWord} and userName = #{userName} ")
    public User getUser(String passWord, String userName);
    @Select("select * from users where userName = #{userName}")
    public User getUserbyName(String userName);
    @Select("SELECT * FROM users where id = #{id}")
    public User gerUserById(int id);
    @Select("select * from users where id <> #{userid}")
    public List<User> getanotherusers(int userid);
    @Select("SELECT userName FROM users where id = #{id}")
    public String getUsernameById(int id);
    @Update("update users set userName = #{userName} , passWord = #{passWord}, " +
            " vocation = #{vocation} , email = #{email} , birthyear=#{birthyear} , birthmonth=#{birthmonth}" +
            ", birthday = #{birthday} , gender = #{gender},religion = #{religion} where id = #{id}")
    public void saveUserbyId(int id, String userName, String passWord, String vocation, String email, String religion, int gender,
                         int birthyear, int birthmonth, int birthday);

}
