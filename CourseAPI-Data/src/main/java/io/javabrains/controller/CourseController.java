package io.javabrains.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.domain.Course;
import io.javabrains.domain.Topic;
import io.javabrains.service.CourseService;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService cs;
	
	@RequestMapping(value="/topics/{topicId}/courses", method=RequestMethod.GET)
	public List<Course> getAllCourses(@PathVariable int topicId) {
		return cs.getAllCourses(topicId);
	}
	@RequestMapping(value="/topics/{topicId}/courses/{courseId}", method=RequestMethod.GET)
	public Course getCourse(@PathVariable int courseId) {
		return cs.getCourse(courseId);
	}
	@RequestMapping(value="/topics/{topicId}/courses", method=RequestMethod.POST)
	public Course addCourse(@RequestBody Course c, @PathVariable int topicId) {
		c.setTopic(new Topic(topicId,"",""));
		return cs.addCourse(c);
	}
	@RequestMapping(value="/topics/{topicId}/courses", method=RequestMethod.PUT)
	public Course updateCourse(@RequestBody Course c, @PathVariable int topicId) {
		c.setTopic(new Topic(topicId,"",""));
		return cs.updateCourse(c);
	}
	@RequestMapping(value="/topics/{topicId}/courses/{courseId}", method=RequestMethod.DELETE)
	public Course deleteCourse(@PathVariable int courseId) {
		return cs.deleteCourse(courseId);
	}
}
