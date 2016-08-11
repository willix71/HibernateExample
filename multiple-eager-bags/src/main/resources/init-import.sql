INSERT INTO multibag.parent(id, name) VALUES(1, 'william');
INSERT INTO multibag.parent(id, name) VALUES(2, 'karla');

INSERT INTO multibag.child1(id, name,parent_id,INDEX_COL) VALUES(11, 'shaun', 1,0); -- index starts with 0
INSERT INTO multibag.child1(id, name,parent_id,INDEX_COL) VALUES(21, 'allan', 1,1);

INSERT INTO multibag.child2(id, name,parent_id,INDEX_COL) VALUES(12, 'kim', 2,0); -- index starts with 0
INSERT INTO multibag.child2(id, name,parent_id,INDEX_COL) VALUES(22, 'sarah', 2,1);