package com.task.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.task.api.model.UserUI;
import com.task.api.service.UserService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping(path = "/viewUser", consumes = "application/json", produces = "application/json")
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	public ResponseEntity<UserUI> viewUser(@RequestBody UserUI userUI) {
		UserUI object = userService.viewUser(userUI);
		return ResponseEntity.ok(object);
	}

	@PostMapping(path = "/updateUser", consumes = "application/json", produces = "application/json")
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	public ResponseEntity<UserUI> updateUser(@RequestBody UserUI userUI) {
		UserUI object = userService.updateUser(userUI);
		return ResponseEntity.ok(object);
	}

	@PostMapping(path = "/deleteUser", consumes = "application/json", produces = "application/json")
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	public ResponseEntity<UserUI> deleteUser(@RequestBody UserUI userUI) {
		UserUI object = userService.deleteUser(userUI);
		return ResponseEntity.ok(object);
	}

	@PostMapping(path = "/addUser", consumes = "application/json", produces = "application/json")
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	public ResponseEntity<UserUI> addUser(@RequestBody UserUI userUI) {
		UserUI object = userService.addUser(userUI);
		return ResponseEntity.ok(object);
	}

	@PostMapping(path = "/listUser", consumes = "application/json", produces = "application/json")
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	public ResponseEntity<List<UserUI>> listUser() {
		List<UserUI> object = userService.listUser();
		return ResponseEntity.ok(object);
	}
}