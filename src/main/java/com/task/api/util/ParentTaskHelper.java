package com.task.api.util;

import com.task.api.entity.ParentTask;
import com.task.api.model.ParentTaskUI;

public class ParentTaskHelper {

	public ParentTask getParentTask(ParentTaskUI parentTaskUI) {
		ParentTask parentTask = new ParentTask();
		parentTask.setParentId(parentTaskUI.getParentId());
		parentTask.setParentTask(parentTaskUI.getParentTask());
		return parentTask;
	}
	
	public ParentTaskUI getParentTaskUI(ParentTask parentTask) {
		ParentTaskUI parentTaskUI = new ParentTaskUI();
		parentTaskUI.setParentId(parentTask.getParentId());
		parentTaskUI.setParentTask(parentTask.getParentTask());
		return parentTaskUI;
	}
}
