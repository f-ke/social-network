package com.uwarterloorookie.mapper;

import com.uwarterloorookie.bean.Topic;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TopicMapper {
    @Select("select * from topics")
    public List<Topic> getalltopics();
    @Select("select * from topics where topicid = #{topicid}")
    public Topic getTopicById(int topicid);

}
