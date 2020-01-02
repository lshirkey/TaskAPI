package com.task.api.model;

public class UserUI {

	private Long  userId;
	
	private String firstName;
	
	private String lastName;
	
	private Long  employeeId;
	
	private String status;

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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long  getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long  employeeId) {
		this.employeeId = employeeId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "UserUI [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", employeeId="
				+ employeeId + ", status=" + status + "]";
	}
}
