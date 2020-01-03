package com.task.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.task.api.model.TaskUI;
import com.task.api.service.TaskService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TaskController {
	
	@Autowired
	TaskService taskService;
	
	@PostMapping(path = "/viewTask", consumes = "application/json", produces = "application/json")
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	public ResponseEntity<TaskUI> viewTask(@RequestBody TaskUI taskUI) {
		TaskUI object = taskService.viewTask(taskUI);
		return ResponseEntity.ok(object);
	}

	@PostMapping(path = "/updateTask", consumes = "application/json", produces = "application/json")
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	public ResponseEntity<TaskUI> updateTask(@RequestBody TaskUI taskUI) {
		TaskUI object = taskService.updateTask(taskUI);
		return ResponseEntity.ok(object);
	}

	@PostMapping(path = "/deleteTask", consumes = "application/json", produces = "application/json")
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	public ResponseEntity<TaskUI> deleteTask(@RequestBody TaskUI taskUI) {
		TaskUI object = taskService.deleteTask(taskUI);
		return ResponseEntity.ok(object);
	}

	@PostMapping(path = "/addTask", consumes = "application/json", produces = "application/json")
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	public ResponseEntity<TaskUI> addTask(@RequestBody TaskUI taskUI) {
		TaskUI object = taskService.addTask(taskUI);
		return ResponseEntity.ok(object);
	}

	@PostMapping(path = "/listTask", consumes = "application/json", produces = "application/json")
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	public ResponseEntity<List<TaskUI>> listTask() {
		List<TaskUI> object = taskService.listTask();
		return ResponseEntity.ok(object);
	}
}