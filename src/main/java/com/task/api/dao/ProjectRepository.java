package com.task.api.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.task.api.entity.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

}
