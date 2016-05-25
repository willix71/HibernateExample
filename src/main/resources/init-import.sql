
INSERT INTO accessright.users(user_id, name, description) VALUES(1, 'william', 'me');
INSERT INTO accessright.users(user_id, name, description) VALUES(2, 'ralph', 'a friend');

INSERT INTO accessright.application(application_id, application_code, application_name)  VALUES(10, 'LSA', 'Lausashop');
INSERT INTO accessright.application(application_id, application_code, application_name)  VALUES(20, 'COM', 'mon compte');

INSERT INTO accessright.role(role_id, role_name) VALUES(100, 'admin');
INSERT INTO accessright.role(role_id, role_name) VALUES(200, 'user');
INSERT INTO accessright.role(role_id, role_name) VALUES(300, 'guest');

INSERT INTO accessright.user_application_role(user_id, application_id, role_id, created_date, created_by) VALUES(1, 10, 100, null,null); // william - lsa -  admin
INSERT INTO accessright.user_application_role(user_id, application_id, role_id, created_date, created_by) VALUES(1, 20, 200, null,null); // william - com - user
INSERT INTO accessright.user_application_role(user_id, application_id, role_id, created_date, created_by) VALUES(2, 10, 300, null,null); // ralph - lsa - guest
