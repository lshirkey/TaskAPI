package com.task.api.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.task.api.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
