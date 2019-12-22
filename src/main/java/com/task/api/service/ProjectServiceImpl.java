package com.task.api.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.api.dao.ProjectRepository;
import com.task.api.entity.Project;
import com.task.api.model.ProjectUI;
import com.task.api.util.ProjectHelper;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectRepository projectRepository;
	
	ProjectHelper projectHelper = new ProjectHelper();
	
	@Override
	public ProjectUI viewProject(ProjectUI projectUI) {
		ProjectUI ui = null;
		Optional<Project> projectList = projectRepository.findById(projectUI.getProjectId());
		if (projectList.isPresent()) {
			ui = projectHelper.getProjectUI(projectList.get());
		}
		return ui;
	}

	@Override
	public ProjectUI updateProject(ProjectUI projectUI) {
		Project project = projectHelper.getProject(projectUI);
		return projectHelper.getProjectUI(projectRepository.save(project));
	}

	@Override
	public ProjectUI deleteProject(ProjectUI projectUI) {
		Project project = projectHelper.getProject(projectUI);
		return projectHelper.getProjectUI(projectRepository.save(project));
	}

	@Override
	public ProjectUI addProject(ProjectUI projectUI) {
		Project project = projectHelper.getProject(projectUI);
		return projectHelper.getProjectUI(projectRepository.save(project));
	}

	@Override
	public List<ProjectUI> listProject() {
		Iterable<Project> iterable = projectRepository.findAll();
		Iterator<Project> iterator = iterable.iterator();
		
		List<ProjectUI> projectUIList = new ArrayList<ProjectUI>();
		while (iterator.hasNext()) {
			Project project = iterator.next();
			projectUIList.add(projectHelper.getProjectUI(project));
		}
		return projectUIList;
	}

	@Override
	public List<ProjectUI> searchProject(ProjectUI projectUI) {
		Iterable<Project> iterable = projectRepository.findAll();
		Iterator<Project> iterator = iterable.iterator();
		
		List<ProjectUI> projectUIList = new ArrayList<ProjectUI>();
		while (iterator.hasNext()) {
			Project project = iterator.next();
			projectUIList.add(projectHelper.getProjectUI(project));
		}
		return projectUIList;
	}

	@Override
	public List<ProjectUI> searchProject(ProjectUI projectUI, String sort) {
		Iterable<Project> iterable = projectRepository.findAll();
		Iterator<Project> iterator = iterable.iterator();
		
		List<ProjectUI> projectUIList = new ArrayList<ProjectUI>();
		while (iterator.hasNext()) {
			Project project = iterator.next();
			projectUIList.add(projectHelper.getProjectUI(project));
		}
		return projectUIList;
	}

}
