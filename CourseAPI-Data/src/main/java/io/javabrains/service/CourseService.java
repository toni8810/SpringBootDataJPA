package io.javabrains.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.javabrains.domain.Course;
import io.javabrains.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRep;
	
	public List<Course> getAllCourses(int id) {
		List<Course> allCourses = new ArrayList<>();
		courseRep.findByTopicId(id).forEach(allCourses::add);
		return allCourses;
	}
	public Course getCourse(int id) {
		return courseRep.findOne(id);
	}
	public Course addCourse(Course c) {
		return courseRep.save(c);
	}
	public Course updateCourse(Course c) {
		return courseRep.save(c);
	}
	public Course deleteCourse(int id) {
		Course c = courseRep.findOne(id);
		courseRep.delete(id);
		return c;
	}
}
