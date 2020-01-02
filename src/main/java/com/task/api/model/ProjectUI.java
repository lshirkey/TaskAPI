package com.task.api.model;

public class ProjectUI {

	private Long projectId;
	
	private String project;
	
	private String startDate;
	
	private String endDate;
	
	private int priority;

	private Long userId;
	
	private String userName;
	
	private int taskCount;
	
	private int taskCompleted;
	
	private String status;
	
	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getTaskCount() {
		return taskCount;
	}

	public void setTaskCount(int taskCount) {
		this.taskCount = taskCount;
	}

	public int getTaskCompleted() {
		return taskCompleted;
	}

	public void setTaskCompleted(int taskCompleted) {
		this.taskCompleted = taskCompleted;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ProjectUI [projectId=" + projectId + ", project=" + project + ", startDate=" + startDate + ", endDate="
				+ endDate + ", priority=" + priority + ", userId=" + userId + ", userName=" + userName + ", taskCount="
				+ taskCount + ", taskCompleted=" + taskCompleted + ", status=" + status + "]";
	}
}
