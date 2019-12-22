select * from user_details;
update user_details set status='A';
drop table user_details;

select * from project;

select * from parent_task_list;

INSERT INTO parent_task_list (parent_id, parent_task_name) VALUES  (1, 'Parent A');

select * from TASK_DETAILS where project_id_fk=2;

update TASK_DETAILS set status = 'E' where task_id = 1
commit;