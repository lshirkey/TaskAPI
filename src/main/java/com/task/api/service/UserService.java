package com.task.api.service;

import java.util.List;

import com.task.api.model.UserUI;

public interface UserService {

	public UserUI viewUser(UserUI userUI);
	
	public UserUI updateUser(UserUI userUI);
	
	public UserUI deleteUser(UserUI userUI);
	
	public UserUI addUser(UserUI userUI);
	
	public List<UserUI> listUser();
}
