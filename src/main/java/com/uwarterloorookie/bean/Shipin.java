package com.uwarterloorookie.bean;

public class Shipin {

    private int id;
    private String url;
    private String content;
    private String topictext;
    private int userid;
    private String username;
    private int view;
    private int commentnums;
    private int likenums;

    public int getLikenums() {
        return likenums;
    }

    public void setLikenums(int likenums) {
        this.likenums = likenums;
    }

    public int getCommentnums() {
        return commentnums;
    }

    public void setCommentnums(int commentnums) {
        this.commentnums = commentnums;
    }

    private int likenum;



    public int getLikenum() {
        return likenum;
    }

    public void setLikenum(int likenum) {
        this.likenum = likenum;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }



    public String getTopictext() {
        return topictext;
    }

    public void setTopictext(String topictext) {
        this.topictext = topictext;
    }

    private int topicid;

    public int getTopicid() {
        return topicid;
    }

    public void setTopicid(int topicid) {
        this.topicid = topicid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
