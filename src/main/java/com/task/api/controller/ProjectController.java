package com.task.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.task.api.model.ProjectUI;
import com.task.api.service.ProjectService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProjectController {

	@Autowired
	ProjectService projectService;
	
	@PostMapping(path = "/viewProject", consumes = "application/json", produces = "application/json")
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	public ResponseEntity<ProjectUI> viewProject(@RequestBody ProjectUI projectUI) {
		ProjectUI object = projectService.viewProject(projectUI);
		return ResponseEntity.ok(object);
	}

	@PostMapping(path = "/updateProject", consumes = "application/json", produces = "application/json")
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	public ResponseEntity<ProjectUI> updateProject(@RequestBody ProjectUI projectUI) {
		ProjectUI object = projectService.updateProject(projectUI);
		return ResponseEntity.ok(object);
	}

	@PostMapping(path = "/deleteProject", consumes = "application/json", produces = "application/json")
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	public ResponseEntity<ProjectUI> deleteProject(@RequestBody ProjectUI projectUI) {
		ProjectUI object = projectService.deleteProject(projectUI);
		return ResponseEntity.ok(object);
	}

	@PostMapping(path = "/addProject", consumes = "application/json", produces = "application/json")
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	public ResponseEntity<ProjectUI> addProject(@RequestBody ProjectUI projectUI) {
		ProjectUI object = projectService.addProject(projectUI);
		return ResponseEntity.ok(object);
	}

	@PostMapping(path = "/listProject", consumes = "application/json", produces = "application/json")
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	public ResponseEntity<List<ProjectUI>> listProject() {
		List<ProjectUI> object = projectService.listProject();
		return ResponseEntity.ok(object);
	}

	@PostMapping(path = "/searchProject", consumes = "application/json", produces = "application/json")
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	public ResponseEntity<List<ProjectUI>> searchProject(@RequestBody ProjectUI projectUI) {
		List<ProjectUI> object = projectService.searchProject(projectUI);
		return ResponseEntity.ok(object);
	}

	@PostMapping(path = "/searchSortProject", consumes = "application/json", produces = "application/json")
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	public ResponseEntity<List<ProjectUI>> searchSortProject(@RequestBody ProjectUI projectUI, @RequestBody String sort) {
		List<ProjectUI> object = projectService.searchProject(projectUI, sort);
		return ResponseEntity.ok(object);
	}
}
