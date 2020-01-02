package com.task.api.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TASK_DETAILS")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TASK_ID", nullable = false)
	private Long  taskId;
	
	@Column(name = "TASK_NAME", nullable = false)
	private String task;
	
	@Column(name = "START_DATE", nullable = false)
	private Date startDate;
	
	@Column(name = "END_DATE", nullable = false)
	private Date endDate;
	
	@Column(name = "PRIORITY", nullable = false)
	private int  priority;
	
	@Column(name = "STATUS", nullable = false)
	private String status;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

	@ManyToOne
	@JoinColumn(name = "PARENT_ID", nullable = true)
    private ParentTask parentTask;
    
    @ManyToOne
    @JoinColumn(name = "PROJECT_ID", nullable = false)
    private Project project;
	
	public Long  getTaskId() {
		return taskId;
	}

	public void setTaskId(Long  taskId) {
		this.taskId = taskId;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ParentTask getParentTask() {
		return parentTask;
	}

	public void setParentTask(ParentTask parentTask) {
		this.parentTask = parentTask;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
}
