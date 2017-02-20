package io.javabrains.repository;

import org.springframework.data.repository.CrudRepository;

import io.javabrains.domain.Topic;

public interface TopicRepository extends CrudRepository<Topic, Integer> {

}
