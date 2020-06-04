package com.uwarterloorookie.bean;

public class User {
    private int id;
    private String userName;
    private String vocation;
    private String passWord;
    private String email;
    private int gender;
    private String religion;

    private int birthyear;
    private int birthmonth;
    private int birthday;
    private String userimage;
    private  Userfollowers userfollowers;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", vocation='" + vocation + '\'' +
                ", passWord='" + passWord + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", religion='" + religion + '\'' +
                ", birthyear=" + birthyear +
                ", birthmonth=" + birthmonth +
                ", birthday=" + birthday +
                ", userimage='" + userimage + '\'' +
                ", userfollowers=" + userfollowers +
                '}';
    }

    public Userfollowers getUserfollowers() {
        return userfollowers;
    }

    public void setUserfollowers(Userfollowers userfollowers) {
        this.userfollowers = userfollowers;
    }

    public String getUserimage() {
        return userimage;
    }

    public void setUserimage(String userimage) {
        this.userimage = userimage;
    }

    public int getBirthyear() {
        return birthyear;
    }

    public void setBirthyear(int birthyear) {
        this.birthyear = birthyear;
    }

    public int getBirthmonth() {
        return birthmonth;
    }

    public void setBirthmonth(int birthmonth) {
        this.birthmonth = birthmonth;
    }

    public int getBirthday() {
        return birthday;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getVocation() {
        return vocation;
    }

    public void setVocation(String vocation) {
        this.vocation = vocation;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}