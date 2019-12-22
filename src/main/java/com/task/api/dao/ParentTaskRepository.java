package com.task.api.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.task.api.entity.ParentTask;

@Repository
public interface ParentTaskRepository extends CrudRepository<ParentTask, Integer> {

}