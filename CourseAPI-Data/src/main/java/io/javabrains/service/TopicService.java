package io.javabrains.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.javabrains.domain.Topic;
import io.javabrains.repository.TopicRepository;


@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRep;
	
	public List<Topic> getAllTopics() {
		List<Topic> returnList = new ArrayList<>();
		topicRep.findAll().forEach(returnList::add);
		return returnList;
	}
	
	public Topic getTopicById(int id) {
		return topicRep.findOne(id);
	}

	public int addTopic(Topic topic) {
		topicRep.save(topic);
		return topic.getId();
	}

	public Topic updateTopic(Topic topic) {
		topicRep.save(topic);
		return topic;
	}

	public Topic deleteTopic(int id) {
		Topic t = topicRep.findOne(id);
		topicRep.delete(id);
		return t;
	}
	
}
