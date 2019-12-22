package com.task.api.service;

import java.util.List;

import com.task.api.model.ParentTaskUI;

public interface ParentTaskService {

	public ParentTaskUI viewParentTask(ParentTaskUI parentTaskUI);
	
	public ParentTaskUI updateParentTask(ParentTaskUI parentTaskUI);
	
	public ParentTaskUI deleteParentTask(ParentTaskUI parentTaskUI);
	
	public ParentTaskUI addParentTask(ParentTaskUI parentTaskUI);
	
	public List<ParentTaskUI> listParentTask();
	
	public List<ParentTaskUI> searchParentTask(ParentTaskUI parentTaskUI);
	
	public List<ParentTaskUI> searchParentTask(ParentTaskUI parentTaskUI, String sort);
}
