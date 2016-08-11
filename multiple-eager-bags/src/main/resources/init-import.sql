INSERT INTO multibag.parent(id, name) VALUES(1, 'william');
INSERT INTO multibag.users(id, name) VALUES(2, 'karla');

INSERT INTO multibag.child1(id, name,parent_id) VALUES(11, 'shaun', 1);
INSERT INTO multibag.child1(id, name,parent_id) VALUES(21, 'allan', 1);

INSERT INTO multibag.child2(id, name,parent_id) VALUES(12, 'kim', 2);
INSERT INTO multibag.child2(id, name,parent_id) VALUES(22, 'sarah', 2);