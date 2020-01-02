CREATE TABLE IF NOT EXISTS user_details (
  user_id BIGINT(20) NOT NULL AUTO_INCREMENT,
  employee_id BIGINT(20) NOT NULL,
  first_name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  status VARCHAR(255) NOT NULL,
  PRIMARY KEY (user_id));
  
CREATE TABLE IF NOT EXISTS project (
  project_id BIGINT(20) NOT NULL AUTO_INCREMENT,
  end_date DATETIME NULL DEFAULT NULL,
  priority INT(11) NOT NULL,
  project_name VARCHAR(255) NOT NULL,
  start_date DATETIME NULL DEFAULT NULL,
  status VARCHAR(255) NOT NULL,
  task_completed INT(11) NOT NULL,
  task_count INT(11) NOT NULL,
  user_id BIGINT(20) NOT NULL,
  PRIMARY KEY (project_id),
    FOREIGN KEY (user_id)
    REFERENCES user_details (user_id));

CREATE TABLE IF NOT EXISTS parent_task_list (
  parent_id BIGINT(20) NOT NULL AUTO_INCREMENT,
  parent_task_name VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (parent_id));
  
CREATE TABLE IF NOT EXISTS TASK_DETAILS (
  task_id BIGINT(20) NOT NULL AUTO_INCREMENT,
  end_date DATETIME NOT NULL,
  priority INT(11) NOT NULL,
  start_date DATETIME NOT NULL,
  status VARCHAR(255) NOT NULL,
  task_name VARCHAR(255) NOT NULL,
  parent_id BIGINT(20) NULL DEFAULT NULL,
  project_id BIGINT(20) NOT NULL,
  user_id BIGINT(20) NOT NULL,
  PRIMARY KEY (task_id),
    constraint FKbb0rfvs0kjqifkq1stvflj9jv  FOREIGN KEY (user_id) REFERENCES user_details (user_id),
    FOREIGN KEY (parent_id)
    REFERENCES parent_task_list (parent_id),
    FOREIGN KEY (project_id)
    REFERENCES project (project_id));
    
--alter table task_details add constraint FKbb0rfvs0kjqifkq1stvflj9jv foreign key (user_id) references user_details (user_id);