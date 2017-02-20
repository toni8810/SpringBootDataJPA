package io.javabrains.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.domain.Topic;
import io.javabrains.service.TopicService;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;

	@RequestMapping(value="/topics", method=RequestMethod.GET)
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	@RequestMapping(value="/topics/{id}", method=RequestMethod.GET)
	public Topic getTopic(@PathVariable int id) {
		return topicService.getTopicById(id);
	}
	
	@RequestMapping(value="/topics", method=RequestMethod.POST)
	public int addTopic(@RequestBody Topic topic) {
		return topicService.addTopic(topic);
	}
	
	@RequestMapping(value="/topics", method=RequestMethod.PUT)
	public Topic updateTopic(@RequestBody Topic topic) {
		return topicService.updateTopic(topic);
	}
	@RequestMapping(value="/topics/{id}", method=RequestMethod.DELETE)
	public Topic deleteTopic(@PathVariable int id) {
		id--;
		return topicService.deleteTopic(id);
	}
	
}
