package com.task.api.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.task.api.entity.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Integer> {

}
