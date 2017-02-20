package io.javabrains.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.javabrains.domain.Course;

public interface CourseRepository extends CrudRepository<Course, Integer> {
	
	public List<Course> findByTopicId(int id); 
}
