package com.uwarterloorookie.bean;

public class Topic {
    int topicid;
    String topicname;
    String topicimage;
    Usertopics usertopics;

    public Usertopics getUsertopics() {
        return usertopics;
    }

    public void setUsertopics(Usertopics usertopics) {
        this.usertopics = usertopics;
    }

    public int getTopicid() {
        return topicid;
    }

    public void setTopicid(int topicid) {
        this.topicid = topicid;
    }

    public String getTopicname() {
        return topicname;
    }

    public void setTopicname(String topicname) {
        this.topicname = topicname;
    }

    public String getTopicimage() {
        return topicimage;
    }

    public void setTopicimage(String topicimage) {
        this.topicimage = topicimage;
    }
}
