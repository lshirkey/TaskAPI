package com.task.api.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PROJECT")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROJECT_ID", nullable = false)
	private Long  projectId;
	
	@Column(name = "PROJECT_NAME", nullable = false)
	private String project;

	@Column(name = "START_DATE", nullable = true)
	private Date startDate;
	
	@Column(name = "END_DATE", nullable = true)
	private Date endDate;
	
	@Column(name = "PRIORITY", nullable = false)
	private int  priority;
	
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

	@Column(name = "TASK_COUNT", nullable = false)
	private int  taskCount;
	
	@Column(name = "TASK_COMPLETED", nullable = false)
	private int  taskCompleted;
	
	@Column(name = "STATUS", nullable = false)
	private String status;
    	
	public Long  getProjectId() {
		return projectId;
	}

	public void setProjectId(Long  projectId) {
		this.projectId = projectId;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int  getPriority() {
		return priority;
	}

	public void setPriority(int  priority) {
		this.priority = priority;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int  getTaskCount() {
		return taskCount;
	}

	public void setTaskCount(int  taskCount) {
		this.taskCount = taskCount;
	}

	public int  getTaskCompleted() {
		return taskCompleted;
	}

	public void setTaskCompleted(int  taskCompleted) {
		this.taskCompleted = taskCompleted;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
