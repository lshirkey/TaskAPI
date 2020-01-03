package com.task.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import com.task.api.entity.Project;
import com.task.api.entity.Task;
import com.task.api.model.ParentTaskUI;
import com.task.api.model.ProjectUI;
import com.task.api.model.TaskUI;
import com.task.api.model.UserUI;
import com.task.api.util.ProjectHelper;
import com.task.api.util.TaskHelper;

@SpringBootTest(classes = TaskApiApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application.properties")
class TaskApiApplicationTests {

	private String HOST_URL = "http://localhost:";

	private String USER_ADD_URI = "/addUser";
	private String USER_UPDATE_URI = "/updateUser";
	private String USER_VIEW_URI = "/viewUser";
	private String USER_LIST_URI = "/listUser";
	private String USER_DELETE_URI = "/deleteUser";

	private String PROJECT_ADD_URI = "/addProject";
	private String PROJECT_UPDATE_URI = "/updateProject";
	private String PROJECT_VIEW_URI = "/viewProject";
	private String PROJECT_LIST_URI = "/listProject";
	private String PROJECT_DELETE_URI = "/deleteProject";
	
	private String PARENT_TASK_ADD_URI = "/addParentTask";
	private String PARENT_TASK_VIEW_URI = "/viewParentTask";
	private String PARENT_TASK_LIST_URI = "/listParentTask";
	
	private String TASK_ADD_URI = "/addTask";
	private String TASK_UPDATE_URI = "/updateTask";
	private String TASK_VIEW_URI = "/viewTask";
	private String TASK_LIST_URI = "/listTask";
	private String TASK_DELETE_URI = "/deleteTask";

	@LocalServerPort
	private int PORT;

	@Autowired
	private TestRestTemplate restTemplate;

	@Sql({"classpath:schema.sql"})
	@Test
	public void test_User_Create_View() {
		final HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		UserUI userUI = getUserUIObject();
		HttpEntity<UserUI> entity = new HttpEntity<>(userUI, headers);

		String addUserURL = HOST_URL + PORT + USER_ADD_URI;
		ResponseEntity<UserUI> createTaskUI = restTemplate.exchange(addUserURL, HttpMethod.POST, entity, UserUI.class);
		assertEquals(200, createTaskUI.getStatusCodeValue());
		
		userUI = createTaskUI.getBody();
		entity = new HttpEntity<>(userUI, headers);
		String viewUserURL = HOST_URL + PORT + USER_VIEW_URI;
		ResponseEntity<UserUI> viewTaskUI = restTemplate.exchange(viewUserURL, HttpMethod.POST, entity, UserUI.class);
		assertEquals(200, viewTaskUI.getStatusCodeValue());
		
	}
	
	@Sql({"classpath:schema.sql"})
	@Test
	public void test_User_Create_Update() {
		final HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		UserUI userUI = getUserUIObject();
		HttpEntity<UserUI> entity = new HttpEntity<>(userUI, headers);
		
		String addUserURL = HOST_URL + PORT + USER_ADD_URI;
		ResponseEntity<UserUI> createTaskUI = restTemplate.exchange(addUserURL, HttpMethod.POST, entity, UserUI.class);
		assertEquals(200, createTaskUI.getStatusCodeValue());
		
		userUI = createTaskUI.getBody();
		entity = new HttpEntity<>(userUI, headers);
		String updateUserURL = HOST_URL + PORT + USER_UPDATE_URI;
		ResponseEntity<UserUI> updateTaskUI = restTemplate.exchange(updateUserURL, HttpMethod.POST, entity, UserUI.class);
		assertEquals(200, updateTaskUI.getStatusCodeValue());
	}
	
	@Sql({"classpath:schema.sql"})
	@Test
	public void test_User_Create_Delete() {
		final HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		UserUI userUI = getUserUIObject();
		HttpEntity<UserUI> entity = new HttpEntity<>(userUI, headers);
		
		String addUserURL = HOST_URL + PORT + USER_ADD_URI;
		ResponseEntity<UserUI> createTaskUI = restTemplate.exchange(addUserURL, HttpMethod.POST, entity, UserUI.class);
		assertEquals(200, createTaskUI.getStatusCodeValue());
		
		userUI = createTaskUI.getBody();
		entity = new HttpEntity<>(userUI, headers);
		String deleteUserURL = HOST_URL + PORT + USER_DELETE_URI;
		ResponseEntity<UserUI> deleteTaskUI = restTemplate.exchange(deleteUserURL, HttpMethod.POST, entity, UserUI.class);
		assertEquals(200, deleteTaskUI.getStatusCodeValue());
	}
	
	@Sql({"classpath:schema.sql"})
	@Test
	public void test_User_Create_List() {
		final HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		UserUI userUI = getUserUIObject();
		HttpEntity<UserUI> entity = new HttpEntity<>(userUI, headers);
		
		String addUserURL = HOST_URL + PORT + USER_ADD_URI;
		ResponseEntity<UserUI> createTaskUI = restTemplate.exchange(addUserURL, HttpMethod.POST, entity, UserUI.class);
		assertEquals(200, createTaskUI.getStatusCodeValue());
		
		HttpEntity<String> entityList = new HttpEntity<>(headers);
		String url = HOST_URL + PORT + USER_LIST_URI;
		assertEquals(true, !restTemplate.exchange(url, HttpMethod.POST, entityList, ArrayList.class).getBody().isEmpty());
	}

	@Sql({"classpath:schema.sql"})
	@Test
	public void test_Project_Create_View() {
		final HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		
		UserUI userUI = getUserUIObject();
		HttpEntity<UserUI> userHttpEntity = new HttpEntity<>(userUI, headers);

		String addUserURL = HOST_URL + PORT + USER_ADD_URI;
		ResponseEntity<UserUI> userResponseEntity = restTemplate.exchange(addUserURL, HttpMethod.POST, userHttpEntity, UserUI.class);
		assertEquals(200, userResponseEntity.getStatusCodeValue());
		
		userUI = userResponseEntity.getBody();
		ProjectUI projectUI = getProjectUIObject();
		projectUI.setUserId(userUI.getUserId());
		HttpEntity<ProjectUI> projectHttpEntity = new HttpEntity<>(projectUI, headers);

		String addProjectURL = HOST_URL + PORT + PROJECT_ADD_URI;
		ResponseEntity<ProjectUI> projectResponseEntity = restTemplate.exchange(addProjectURL, HttpMethod.POST, projectHttpEntity, ProjectUI.class);
		assertEquals(200, projectResponseEntity.getStatusCodeValue());
		
		projectUI = projectResponseEntity.getBody();
		projectHttpEntity = new HttpEntity<>(projectUI, headers);
		String viewProjectURL = HOST_URL + PORT + PROJECT_VIEW_URI;
		ResponseEntity<ProjectUI> viewProjectUI = restTemplate.exchange(viewProjectURL, HttpMethod.POST, projectHttpEntity, ProjectUI.class);
		assertEquals(200, viewProjectUI.getStatusCodeValue());
	}
	
	@Sql({"classpath:schema.sql"})
	@Test
	public void test_Project_Create_Update() {
		final HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		
		UserUI userUI = getUserUIObject();
		HttpEntity<UserUI> userHttpEntity = new HttpEntity<>(userUI, headers);

		String addUserURL = HOST_URL + PORT + USER_ADD_URI;
		ResponseEntity<UserUI> userResponseEntity = restTemplate.exchange(addUserURL, HttpMethod.POST, userHttpEntity, UserUI.class);
		assertEquals(200, userResponseEntity.getStatusCodeValue());
		
		userUI = userResponseEntity.getBody();
		ProjectUI projectUI = getProjectUIObject();
		projectUI.setUserId(userUI.getUserId());
		HttpEntity<ProjectUI> projectHttpEntity = new HttpEntity<>(projectUI, headers);

		String addProjectURL = HOST_URL + PORT + PROJECT_ADD_URI;
		ResponseEntity<ProjectUI> projectResponseEntity = restTemplate.exchange(addProjectURL, HttpMethod.POST, projectHttpEntity, ProjectUI.class);
		assertEquals(200, projectResponseEntity.getStatusCodeValue());
		
		projectUI = projectResponseEntity.getBody();
		projectHttpEntity = new HttpEntity<>(projectUI, headers);
		String updateProjectURL = HOST_URL + PORT + PROJECT_UPDATE_URI;
		ResponseEntity<ProjectUI> updateProjectUI = restTemplate.exchange(updateProjectURL, HttpMethod.POST, projectHttpEntity, ProjectUI.class);
		assertEquals(200, updateProjectUI.getStatusCodeValue());
	}
	
	@Sql({"classpath:schema.sql"})
	@Test
	public void test_Project_Create_Delete() {
		final HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		
		UserUI userUI = getUserUIObject();
		HttpEntity<UserUI> userHttpEntity = new HttpEntity<>(userUI, headers);

		String addUserURL = HOST_URL + PORT + USER_ADD_URI;
		ResponseEntity<UserUI> userResponseEntity = restTemplate.exchange(addUserURL, HttpMethod.POST, userHttpEntity, UserUI.class);
		assertEquals(200, userResponseEntity.getStatusCodeValue());
		
		userUI = userResponseEntity.getBody();
		ProjectUI projectUI = getProjectUIObject();
		projectUI.setUserId(userUI.getUserId());
		HttpEntity<ProjectUI> projectHttpEntity = new HttpEntity<>(projectUI, headers);

		String addProjectURL = HOST_URL + PORT + PROJECT_ADD_URI;
		ResponseEntity<ProjectUI> projectResponseEntity = restTemplate.exchange(addProjectURL, HttpMethod.POST, projectHttpEntity, ProjectUI.class);
		assertEquals(200, projectResponseEntity.getStatusCodeValue());
		
		projectUI = projectResponseEntity.getBody();
		projectHttpEntity = new HttpEntity<>(projectUI, headers);
		String deleteProjectURL = HOST_URL + PORT + PROJECT_DELETE_URI;
		ResponseEntity<ProjectUI> deleteProjectUI = restTemplate.exchange(deleteProjectURL, HttpMethod.POST, projectHttpEntity, ProjectUI.class);
		assertEquals(200, deleteProjectUI.getStatusCodeValue());
	}
	
	@Sql({"classpath:schema.sql"})
	@Test
	public void test_Project_Create_List() {
		final HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		
		UserUI userUI = getUserUIObject();
		HttpEntity<UserUI> userHttpEntity = new HttpEntity<>(userUI, headers);

		String addUserURL = HOST_URL + PORT + USER_ADD_URI;
		ResponseEntity<UserUI> userResponseEntity = restTemplate.exchange(addUserURL, HttpMethod.POST, userHttpEntity, UserUI.class);
		assertEquals(200, userResponseEntity.getStatusCodeValue());
		
		userUI = userResponseEntity.getBody();
		ProjectUI projectUI = getProjectUIObject();
		projectUI.setUserId(userUI.getUserId());
		HttpEntity<ProjectUI> projectHttpEntity = new HttpEntity<>(projectUI, headers);

		String addProjectURL = HOST_URL + PORT + PROJECT_ADD_URI;
		ResponseEntity<ProjectUI> projectResponseEntity = restTemplate.exchange(addProjectURL, HttpMethod.POST, projectHttpEntity, ProjectUI.class);
		assertEquals(200, projectResponseEntity.getStatusCodeValue());
		
		HttpEntity<String> entityList = new HttpEntity<>(headers);
		String url = HOST_URL + PORT + PROJECT_LIST_URI;
		assertEquals(true, !restTemplate.exchange(url, HttpMethod.POST, entityList, ArrayList.class).getBody().isEmpty());
	}
	
	@Sql({"classpath:schema.sql"})
	@Test
	public void test_Parent_Task_Create_View() {
		final HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		ParentTaskUI parentTaskUI = getParentTaskUIObject();
		HttpEntity<ParentTaskUI> entity = new HttpEntity<>(parentTaskUI, headers);

		String addParentTaskURL = HOST_URL + PORT + PARENT_TASK_ADD_URI;
		ResponseEntity<ParentTaskUI> createParentTaskUI = restTemplate.exchange(addParentTaskURL, HttpMethod.POST, entity, ParentTaskUI.class);
		assertEquals(200, createParentTaskUI.getStatusCodeValue());
		
		parentTaskUI = createParentTaskUI.getBody();
		entity = new HttpEntity<>(parentTaskUI, headers);
		String viewParentTaskURL = HOST_URL + PORT + PARENT_TASK_VIEW_URI;
		ResponseEntity<ParentTaskUI> viewParentTaskUI = restTemplate.exchange(viewParentTaskURL, HttpMethod.POST, entity, ParentTaskUI.class);
		assertEquals(200, viewParentTaskUI.getStatusCodeValue());
		
		HttpEntity<String> entityList = new HttpEntity<>(headers);
		String url = HOST_URL + PORT + PARENT_TASK_LIST_URI;
		assertEquals(true, !restTemplate.exchange(url, HttpMethod.POST, entityList, ArrayList.class).getBody().isEmpty());
	}
	
	@Sql({"classpath:schema.sql"})
	@Test
	public void test_Task_Create_View_No_Parent_Task() {
		final HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		
		UserUI userUI = getUserUIObject();
		HttpEntity<UserUI> userHttpEntity = new HttpEntity<>(userUI, headers);

		String addUserURL = HOST_URL + PORT + USER_ADD_URI;
		ResponseEntity<UserUI> userResponseEntity = restTemplate.exchange(addUserURL, HttpMethod.POST, userHttpEntity, UserUI.class);
		assertEquals(200, userResponseEntity.getStatusCodeValue());
		
		userUI = userResponseEntity.getBody();
		ProjectUI projectUI = getProjectUIObject();
		projectUI.setUserId(userUI.getUserId());
		HttpEntity<ProjectUI> projectHttpEntity = new HttpEntity<>(projectUI, headers);

		String addProjectURL = HOST_URL + PORT + PROJECT_ADD_URI;
		ResponseEntity<ProjectUI> projectResponseEntity = restTemplate.exchange(addProjectURL, HttpMethod.POST, projectHttpEntity, ProjectUI.class);
		assertEquals(200, projectResponseEntity.getStatusCodeValue());
		
		projectUI = projectResponseEntity.getBody();
				
		TaskUI taskUI = getTaskUIObject();
		taskUI.setProjectId(projectUI.getProjectId());
		taskUI.setProject(projectUI.getProject());
		taskUI.setUserId(userUI.getUserId());
		taskUI.setFirstName(userUI.getFirstName());
		taskUI.setParentId(null);
		taskUI.setParentTask(null);
		HttpEntity<TaskUI> taskHttpEntity = new HttpEntity<>(taskUI, headers);

		String addTaskURL = HOST_URL + PORT + TASK_ADD_URI;
		ResponseEntity<TaskUI> taskResponseEntity = restTemplate.exchange(addTaskURL, HttpMethod.POST, taskHttpEntity, TaskUI.class);
		assertEquals(200, taskResponseEntity.getStatusCodeValue());
		
	}
	
	
	@Sql({"classpath:schema.sql"})
	@Test
	public void test_Task_Create_View() {
		final HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		
		UserUI userUI = getUserUIObject();
		HttpEntity<UserUI> userHttpEntity = new HttpEntity<>(userUI, headers);

		String addUserURL = HOST_URL + PORT + USER_ADD_URI;
		ResponseEntity<UserUI> userResponseEntity = restTemplate.exchange(addUserURL, HttpMethod.POST, userHttpEntity, UserUI.class);
		assertEquals(200, userResponseEntity.getStatusCodeValue());
		
		userUI = userResponseEntity.getBody();
		ProjectUI projectUI = getProjectUIObject();
		projectUI.setUserId(userUI.getUserId());
		HttpEntity<ProjectUI> projectHttpEntity = new HttpEntity<>(projectUI, headers);

		String addProjectURL = HOST_URL + PORT + PROJECT_ADD_URI;
		ResponseEntity<ProjectUI> projectResponseEntity = restTemplate.exchange(addProjectURL, HttpMethod.POST, projectHttpEntity, ProjectUI.class);
		assertEquals(200, projectResponseEntity.getStatusCodeValue());
		
		projectUI = projectResponseEntity.getBody();
		
		ParentTaskUI parentTaskUI = getParentTaskUIObject();
		HttpEntity<ParentTaskUI> parentTaskHttpEntity = new HttpEntity<>(parentTaskUI, headers);

		String addParentTaskURL = HOST_URL + PORT + PARENT_TASK_ADD_URI;
		ResponseEntity<ParentTaskUI> createParentTaskUI = restTemplate.exchange(addParentTaskURL, HttpMethod.POST, parentTaskHttpEntity, ParentTaskUI.class);
		assertEquals(200, createParentTaskUI.getStatusCodeValue());
		
		parentTaskUI = createParentTaskUI.getBody();
		
		TaskUI taskUI = getTaskUIObject();
		taskUI.setProjectId(projectUI.getProjectId());
		taskUI.setProject(projectUI.getProject());
		taskUI.setUserId(userUI.getUserId());
		taskUI.setFirstName(userUI.getFirstName());
		taskUI.setParentId(parentTaskUI.getParentId());
		taskUI.setParentTask(parentTaskUI.getParentTask());
		
		HttpEntity<TaskUI> taskHttpEntity = new HttpEntity<>(taskUI, headers);

		String addTaskURL = HOST_URL + PORT + TASK_ADD_URI;
		ResponseEntity<TaskUI> taskResponseEntity = restTemplate.exchange(addTaskURL, HttpMethod.POST, taskHttpEntity, TaskUI.class);
		assertEquals(200, taskResponseEntity.getStatusCodeValue());
		
		Long taskId = taskResponseEntity.getBody().getTaskId();
		taskUI.setTaskId(taskId);
		taskHttpEntity = new HttpEntity<>(taskUI, headers);
		
		String updateTaskURL = HOST_URL + PORT + TASK_UPDATE_URI;
		ResponseEntity<TaskUI> updateTaskUI = restTemplate.exchange(updateTaskURL, HttpMethod.POST, taskHttpEntity, TaskUI.class);
		assertEquals(200, updateTaskUI.getStatusCodeValue());

		
		HttpEntity<String> entityList = new HttpEntity<>(headers);
		String url = HOST_URL + PORT + TASK_LIST_URI;
		assertEquals(true, !restTemplate.exchange(url, HttpMethod.POST, entityList, ArrayList.class).getBody().isEmpty());
		
		String viewTaskURL = HOST_URL + PORT + TASK_VIEW_URI;
		ResponseEntity<TaskUI> viewTaskUI = restTemplate.exchange(viewTaskURL, HttpMethod.POST, taskHttpEntity, TaskUI.class);
		assertEquals(200, viewTaskUI.getStatusCodeValue());
		
		taskUI.setStatus("E");
		taskHttpEntity = new HttpEntity<>(taskUI, headers);
		updateTaskUI = restTemplate.exchange(updateTaskURL, HttpMethod.POST, taskHttpEntity, TaskUI.class);
		assertEquals(200, updateTaskUI.getStatusCodeValue());
		
		String deleteTaskURL = HOST_URL + PORT + TASK_DELETE_URI;
		ResponseEntity<TaskUI> deleteTaskUI = restTemplate.exchange(deleteTaskURL, HttpMethod.POST, taskHttpEntity, TaskUI.class);
		assertEquals(200, deleteTaskUI.getStatusCodeValue());
	}

	private UserUI getUserUIObject() {
		UserUI userUI = new UserUI();
		userUI.setEmployeeId("1234");
		userUI.setFirstName("Test");
		userUI.setLastName("Test");
		userUI.setStatus("A");
		userUI.setUserId(100005l);
		userUI.toString();
		return userUI;
	}

	private ProjectUI getProjectUIObject() {
		ProjectUI projectUI = new ProjectUI();
		projectUI.setEndDate("2019-12-10");
		projectUI.setPriority(1);
		projectUI.setProject("Test");
		projectUI.setProjectId(100005l);
		projectUI.setStartDate("2019-12-20");
		projectUI.setStatus("A");
		projectUI.setTaskCompleted(5);
		projectUI.setTaskCount(10);
		projectUI.setUserId(100005l);
		projectUI.setUserName("Test");
		projectUI.toString();
		return projectUI;
	}

	private ParentTaskUI getParentTaskUIObject() {
		ParentTaskUI parentTaskUI = new ParentTaskUI();
		parentTaskUI.setParentId(100005l);
		parentTaskUI.setParentTask("Test");
		parentTaskUI.toString();
		return parentTaskUI;
	}

	private TaskUI getTaskUIObject() {
		TaskUI taskUI = new TaskUI();
		taskUI.setEndDate("2019-12-20");
		taskUI.setFirstName("Test");
		taskUI.setParentId(100005l);
		taskUI.setParentTask("Test");
		taskUI.setPriority(10);
		taskUI.setProject("Test");
		taskUI.setProjectId(100005l);
		taskUI.setStartDate("2019-12-10");
		taskUI.setStatus("A");
		taskUI.setTask("Test");
		taskUI.setTaskId(100005l);
		taskUI.setUserId(100005l);
		taskUI.toString();
		return taskUI;
	}
	
	@Test
	public void testObject() {
		ProjectHelper projectHelper = new ProjectHelper();
		ProjectUI projectUI = new ProjectUI();
		projectUI.setEndDate("");
		projectHelper.getProject(projectUI);
		projectHelper.getProjectUI(new Project());
		
		TaskHelper taskHelper = new TaskHelper();
		taskHelper.getTask(new TaskUI());
		taskHelper.getTaskUI(new Task());
		
	}
}