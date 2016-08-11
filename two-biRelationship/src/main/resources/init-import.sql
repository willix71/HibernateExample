INSERT INTO mkyongdb.stock(STOCK_ID,STOCK_CODE,STOCK_NAME) VALUES(1, 'A', 'SOMETHING');
INSERT INTO mkyongdb.stock(STOCK_ID,STOCK_CODE,STOCK_NAME) VALUES(2, 'B', 'SOMETHING ELSE');

INSERT INTO mkyongdb.category(CATEGORY_ID,NAME,DESCRIPTION) VALUES(10, 'CAT10', 'CATEGORY twenty');
INSERT INTO mkyongdb.category(CATEGORY_ID,NAME,DESCRIPTION) VALUES(20, 'CAT20', 'zorglub');

INSERT INTO mkyongdb.stock_category(STOCK_CATEGORY_ID,STOCK_ID,CATEGORY_ID,CREATED_BY) VALUES(100, 1, 10, 'system');
INSERT INTO mkyongdb.stock_category(STOCK_CATEGORY_ID,STOCK_ID,CATEGORY_ID,CREATED_BY) VALUES(101, 1, 20, 'system');
INSERT INTO mkyongdb.stock_category(STOCK_CATEGORY_ID,STOCK_ID,CATEGORY_ID,CREATED_BY) VALUES(102, 2, 20, 'system');

INSERT INTO mkyongdb.role(ROLE_ID,ROLE_NAME) VALUES(1,	'role1');
INSERT INTO mkyongdb.role(ROLE_ID,ROLE_NAME) VALUES(2, 'role2');
INSERT INTO mkyongdb.role(ROLE_ID,ROLE_NAME) VALUES(3, 'role3');

INSERT INTO mkyongdb.stock_category_role VALUES(100, 1);
INSERT INTO mkyongdb.stock_category_role VALUES(100, 2);
INSERT INTO mkyongdb.stock_category_role VALUES(101, 1);
