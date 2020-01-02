package com.task.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PARENT_TASK_LIST")
public class ParentTask {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PARENT_ID")
	private Long  parentId;
	
	@Column(name = "PARENT_TASK_NAME")
	private String parentTask;

	public Long  getParentId() {
		return parentId;
	}

	public void setParentId(Long  parentId) {
		this.parentId = parentId;
	}

	public String getParentTask() {
		return parentTask;
	}

	public void setParentTask(String parentTask) {
		this.parentTask = parentTask;
	}
}
