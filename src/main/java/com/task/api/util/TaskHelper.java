package com.task.api.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.task.api.entity.ParentTask;
import com.task.api.entity.Project;
import com.task.api.entity.Task;
import com.task.api.entity.User;
import com.task.api.model.TaskUI;

public class TaskHelper {

	public Task getTask(TaskUI taskUI) {
		Task task = new Task();
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			task.setEndDate(dateFormat.parse(taskUI.getEndDate()));
			task.setPriority(taskUI.getPriority());
			task.setStartDate(dateFormat.parse(taskUI.getStartDate()));
			task.setStatus(taskUI.getStatus());
			task.setTask(taskUI.getTask());
			task.setTaskId(taskUI.getTaskId());
			
			User user = new User();
			user.setUserId(taskUI.getUserId());
			user.setFirstName(taskUI.getFirstName());
			task.setUser(user);
			
			ParentTask parentTask = new ParentTask();
			parentTask.setParentId(taskUI.getParentId());
			parentTask.setParentTask(taskUI.getParentTask());
			task.setParentTask(parentTask);
			
			Project project = new Project();
			project.setProjectId(taskUI.getProjectId());
			project.setProject(taskUI.getProject());
			task.setProject(project);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return task;
	}
	
	public TaskUI getTaskUI(Task task) {
		TaskUI taskUI = new TaskUI();
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			taskUI.setEndDate(dateFormat.format(task.getEndDate()));
			taskUI.setPriority(task.getPriority());
			taskUI.setStartDate(dateFormat.format(task.getStartDate()));
			taskUI.setStatus(task.getStatus());
			taskUI.setTask(task.getTask());
			taskUI.setTaskId(task.getTaskId());
			
			taskUI.setUserId(task.getUser().getUserId());
			taskUI.setFirstName(task.getUser().getFirstName());
			
			taskUI.setParentId(task.getParentTask().getParentId());
			taskUI.setParentTask(task.getParentTask().getParentTask());
			
			taskUI.setProjectId(task.getProject().getProjectId());
			taskUI.setProject(task.getProject().getProject());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return taskUI;
	}
}
