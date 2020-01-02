package com.task.api.model;

public class TaskUI {

	private Long  projectId;

	private String project;

	private Long  taskId;

	private String task;

	private int  priority;

	private Long  parentId;

	private String parentTask;

	private String startDate;

	private String endDate;

	private Long  userId;

	private String firstName;

	private String status;

	public Long  getTaskId() {
		return taskId;
	}

	public void setTaskId(Long  taskId) {
		this.taskId = taskId;
	}

	public Long  getParentId() {
		return parentId;
	}

	public void setParentId(Long  parentId) {
		this.parentId = parentId;
	}

	public Long  getProjectId() {
		return projectId;
	}

	public void setProjectId(Long  projectId) {
		this.projectId = projectId;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
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

	public int  getPriority() {
		return priority;
	}

	public void setPriority(int  priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getParentTask() {
		return parentTask;
	}

	public void setParentTask(String parentTask) {
		this.parentTask = parentTask;
	}

	public Long  getUserId() {
		return userId;
	}

	public void setUserId(Long  userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String toString() {
		return "TaskUI [projectId=" + projectId + ", project=" + project + ", taskId=" + taskId + ", task=" + task
				+ ", priority=" + priority + ", parentId=" + parentId + ", parentTask=" + parentTask + ", startDate="
				+ startDate + ", endDate=" + endDate + ", userId=" + userId + ", firstName=" + firstName + ", status="
				+ status + "]";
	}
}
