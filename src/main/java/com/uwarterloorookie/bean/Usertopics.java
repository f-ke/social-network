package com.uwarterloorookie.bean;

public class Usertopics {
    private int userid;
    private int id;
    private int usertopicid;

    public int getUsertopicid() {
        return usertopicid;
    }

    public void setUsertopicid(int usertopicid) {
        this.usertopicid = usertopicid;
    }

    private String topictext;
    public String getTopictext() {
        return topictext;
    }

    public void setTopictext(String topictext) {
        this.topictext = topictext;
    }


    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
