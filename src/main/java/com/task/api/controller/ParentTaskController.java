package com.task.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.task.api.model.ParentTaskUI;
import com.task.api.service.ParentTaskService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ParentTaskController {

	@Autowired
	ParentTaskService parentTaskService;
	
	@PostMapping(path = "/viewParentTask", consumes = "application/json", produces = "application/json")
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	public ResponseEntity<ParentTaskUI> viewParentTask(@RequestBody ParentTaskUI parentTaskUI) {
		ParentTaskUI object = parentTaskService.viewParentTask(parentTaskUI);
		return ResponseEntity.ok(object);
	}

	@PostMapping(path = "/updateParentTask", consumes = "application/json", produces = "application/json")
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	public ResponseEntity<ParentTaskUI> updateParentTask(@RequestBody ParentTaskUI parentTaskUI) {
		ParentTaskUI object = parentTaskService.updateParentTask(parentTaskUI);
		return ResponseEntity.ok(object);
	}

	@PostMapping(path = "/deleteParentTask", consumes = "application/json", produces = "application/json")
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	public ResponseEntity<ParentTaskUI> deleteParentTask(@RequestBody ParentTaskUI parentTaskUI) {
		ParentTaskUI object = parentTaskService.deleteParentTask(parentTaskUI);
		return ResponseEntity.ok(object);
	}

	@PostMapping(path = "/addParentTask", consumes = "application/json", produces = "application/json")
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	public ResponseEntity<ParentTaskUI> addParentTask(@RequestBody ParentTaskUI parentTaskUI) {
		ParentTaskUI object = parentTaskService.addParentTask(parentTaskUI);
		return ResponseEntity.ok(object);
	}

	@PostMapping(path = "/listParentTask", consumes = "application/json", produces = "application/json")
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	public ResponseEntity<List<ParentTaskUI>> listParentTask() {
		List<ParentTaskUI> object = parentTaskService.listParentTask();
		System.out.println(object);
		return ResponseEntity.ok(object);
	}

	@PostMapping(path = "/searchParentTask", consumes = "application/json", produces = "application/json")
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	public ResponseEntity<List<ParentTaskUI>> searchParentTask(@RequestBody ParentTaskUI parentTaskUI) {
		List<ParentTaskUI> object = parentTaskService.searchParentTask(parentTaskUI);
		return ResponseEntity.ok(object);
	}

	@PostMapping(path = "/searchSortParentTask", consumes = "application/json", produces = "application/json")
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	public ResponseEntity<List<ParentTaskUI>> searchSortParentTask(@RequestBody ParentTaskUI parentTaskUI, String sort) {
		List<ParentTaskUI> object = parentTaskService.searchParentTask(parentTaskUI, sort);
		return ResponseEntity.ok(object);
	}
}
