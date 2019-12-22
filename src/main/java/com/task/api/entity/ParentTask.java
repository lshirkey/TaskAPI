package com.task.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PARENT_TASK_LIST")
public class ParentTask {

	@Id
	@Column(name = "PARENT_ID")
	private int parentId;
	
	@Column(name = "PARENT_TASK_NAME")
	private String parentTask;

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getParentTask() {
		return parentTask;
	}

	public void setParentTask(String parentTask) {
		this.parentTask = parentTask;
	}
}
