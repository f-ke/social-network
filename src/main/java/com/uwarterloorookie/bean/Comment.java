package com.uwarterloorookie.bean;

import java.sql.Date;

public class Comment {
    private int id;
    private String text;
    private Date time;
    private int userid;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private int shipinid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getShipinid() {
        return shipinid;
    }

    public void setShipinid(int shipinid) {
        this.shipinid = shipinid;
    }
}
