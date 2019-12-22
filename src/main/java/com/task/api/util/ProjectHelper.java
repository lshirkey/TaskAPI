package com.task.api.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.task.api.entity.Project;
import com.task.api.entity.User;
import com.task.api.model.ProjectUI;

public class ProjectHelper {

	public Project getProject(ProjectUI projectUI) {
		Project project = new Project();
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			if (projectUI.getEndDate() != null) {
				project.setEndDate(dateFormat.parse(projectUI.getEndDate()));
			}
			project.setPriority(projectUI.getPriority());
			project.setProject(projectUI.getProject());
			project.setProjectId(projectUI.getProjectId());
			if (projectUI.getStartDate() != null) {
				project.setStartDate(dateFormat.parse(projectUI.getStartDate()));
			}
			User user = new User();
			user.setUserId(projectUI.getUserId());
			project.setUser(user);
			project.setStatus(projectUI.getStatus());
			project.setTaskCount(projectUI.getTaskCount());
			project.setTaskCompleted(projectUI.getTaskCompleted());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return project;
	}
	
	
	public ProjectUI getProjectUI(Project project) {
		ProjectUI projectUI = new ProjectUI();
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			if (project.getEndDate() != null) {
				projectUI.setEndDate(dateFormat.format(project.getEndDate()));
			}
			projectUI.setPriority(project.getPriority());
			projectUI.setProject(project.getProject());
			projectUI.setProjectId(project.getProjectId());
			if (project.getStartDate() != null) {
				projectUI.setStartDate(dateFormat.format(project.getStartDate()));
			}
			projectUI.setUserId(project.getUser().getUserId());
			projectUI.setUserName(project.getUser().getFirstName());
			projectUI.setStatus(project.getStatus());
			projectUI.setTaskCount(project.getTaskCount());
			projectUI.setTaskCompleted(project.getTaskCompleted());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return projectUI;
	}
}
