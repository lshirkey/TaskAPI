package com.task.api.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.api.dao.ProjectRepository;
import com.task.api.dao.TaskRepository;
import com.task.api.entity.Project;
import com.task.api.entity.Task;
import com.task.api.model.TaskUI;
import com.task.api.util.TaskHelper;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskRepository taskRepository;
	
	@Autowired 
	ProjectRepository projectRespository;
	
	TaskHelper taskHelper = new TaskHelper();
	
	@Override
	public TaskUI viewTask(TaskUI taskUI) {
		TaskUI ui = null;
		Optional<Task> taskList = taskRepository.findById(taskUI.getTaskId());
		if (taskList.isPresent()) {
			ui = taskHelper.getTaskUI(taskList.get());
		}
		return ui;
	}

	@Override
	public TaskUI updateTask(TaskUI taskUI) {
		Task task = taskHelper.getTask(taskUI);
		TaskUI updatedTaskUI = taskHelper.getTaskUI(taskRepository.save(task));
		if (taskUI.getStatus() != null && "E".equalsIgnoreCase(taskUI.getStatus())) {
			if (task.getProject()!= null && task.getProject().getProjectId() !=null) {
				Optional<Project> projectOptionalList = projectRespository.findById(task.getProject().getProjectId());
				if (projectOptionalList.isPresent()) {
					Project project = projectOptionalList.get();
					int taskCompletedCount = project.getTaskCompleted() + 1;
					project.setTaskCompleted(taskCompletedCount);
					projectRespository.save(project);
				}
				
			}
		}
		return updatedTaskUI;
	}

	@Override
	public TaskUI deleteTask(TaskUI taskUI) {
		Task task = taskHelper.getTask(taskUI);
		return taskHelper.getTaskUI(taskRepository.save(task));
	}

	@Override
	public TaskUI addTask(TaskUI taskUI) {
		Task task = taskHelper.getTask(taskUI);
		TaskUI newTaskUI = taskHelper.getTaskUI(taskRepository.save(task));
		if (task.getProject()!= null && task.getProject().getProjectId() !=null) {
			Optional<Project> projectOptionalList = projectRespository.findById(task.getProject().getProjectId());
			if (projectOptionalList.isPresent()) {
				Project project = projectOptionalList.get();
				int taskCount = project.getTaskCount() + 1;
				project.setTaskCount(taskCount);
				projectRespository.save(project);
			}
			
		}
		return newTaskUI;
		
	}

	@Override
	public List<TaskUI> listTask() {
		Iterable<Task> iterable = taskRepository.findAll();
		Iterator<Task> iterator = iterable.iterator();

		List<TaskUI> taskUIList = new ArrayList<TaskUI>();
		while (iterator.hasNext()) {
			Task Task = iterator.next();
			taskUIList.add(taskHelper.getTaskUI(Task));
		}
		return taskUIList;
	}
}
