package com.task.api.service;

import java.util.List;

import com.task.api.model.TaskUI;

public interface TaskService {

	public TaskUI viewTask(TaskUI taskUI);
	
	public TaskUI updateTask(TaskUI taskUI);
	
	public TaskUI deleteTask(TaskUI taskUI);
	
	public TaskUI addTask(TaskUI taskUI);
	
	public List<TaskUI> listTask();
	
	//public List<TaskUI> searchTask(TaskUI taskUI);
	
	//public List<TaskUI> searchTask(TaskUI taskUI, String sort);
}
