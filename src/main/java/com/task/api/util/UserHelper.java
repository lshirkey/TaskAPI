package com.task.api.util;

import com.task.api.entity.User;
import com.task.api.model.UserUI;

public class UserHelper {

	public User getUser(UserUI userUI) {
		User user = new User();
		user.setEmployeeId(userUI.getEmployeeId());
		user.setFirstName(userUI.getFirstName());
		user.setLastName(userUI.getLastName());
		user.setUserId(userUI.getUserId());
		user.setStatus(userUI.getStatus());
		return user;
	}
	
	public UserUI getUserUI(User user) {
		UserUI userUI = new UserUI();
		userUI.setEmployeeId(user.getEmployeeId());
		userUI.setFirstName(user.getFirstName());
		userUI.setLastName(user.getLastName());
		userUI.setUserId(user.getUserId());
		userUI.setStatus(user.getStatus());
		return userUI;
	}
}
