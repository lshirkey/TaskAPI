package com.task.api.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.api.dao.UserRepository;
import com.task.api.entity.User;
import com.task.api.model.UserUI;
import com.task.api.util.UserHelper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	UserHelper userHelper = new UserHelper();
	
	@Override
	public UserUI viewUser(UserUI userUI) {
		UserUI ui = null;
		Optional<User> userList = userRepository.findById(userUI.getUserId());
		if (userList.isPresent()) {
			ui = userHelper.getUserUI(userList.get());
		}
		return ui;
	}

	@Override
	public UserUI updateUser(UserUI userUI) {
		User user = userHelper.getUser(userUI);
		return userHelper.getUserUI(userRepository.save(user));
	}

	@Override
	public UserUI deleteUser(UserUI userUI) {
		User user = userHelper.getUser(userUI);
		return userHelper.getUserUI(userRepository.save(user));
	}

	@Override
	public UserUI addUser(UserUI userUI) {
		User user = userHelper.getUser(userUI);
		return userHelper.getUserUI(userRepository.save(user));
	}

	@Override
	public List<UserUI> listUser() {
		Iterable<User> iterable = userRepository.findAll();
		Iterator<User> iterator = iterable.iterator();

		List<UserUI> userUIList = new ArrayList<UserUI>();
		while (iterator.hasNext()) {
			User User = iterator.next();
			userUIList.add(userHelper.getUserUI(User));
		}
		return userUIList;
	}

	@Override
	public List<UserUI> searchUser(UserUI userUI) {
		Iterable<User> iterable = userRepository.findAll();
		Iterator<User> iterator = iterable.iterator();

		List<UserUI> userUIList = new ArrayList<UserUI>();
		while (iterator.hasNext()) {
			User User = iterator.next();
			userUIList.add(userHelper.getUserUI(User));
		}
		return userUIList;
	}

	@Override
	public List<UserUI> searchUser(UserUI userUI, String sort) {
		Iterable<User> iterable = userRepository.findAll();
		Iterator<User> iterator = iterable.iterator();

		List<UserUI> userUIList = new ArrayList<UserUI>();
		while (iterator.hasNext()) {
			User User = iterator.next();
			userUIList.add(userHelper.getUserUI(User));
		}
		return userUIList;
	}

}
