package com.task.api.service;

import java.util.List;

import com.task.api.model.ProjectUI;

public interface ProjectService {

	public ProjectUI viewProject(ProjectUI projectUI);
	
	public ProjectUI updateProject(ProjectUI projectUI);
	
	public ProjectUI deleteProject(ProjectUI projectUI);
	
	public ProjectUI addProject(ProjectUI projectUI);
	
	public List<ProjectUI> listProject();
	
	public List<ProjectUI> searchProject(ProjectUI projectUI);
	
	public List<ProjectUI> searchProject(ProjectUI projectUI, String sort);
}
