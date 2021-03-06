DROP SCHEMA mkyongdb;

CREATE SCHEMA mkyongdb;

CREATE TABLE mkyongdb.role (
  ROLE_ID INT(10) PRIMARY KEY AUTO_INCREMENT,
  ROLE_NAME VARCHAR(20) NOT NULL
);

CREATE TABLE mkyongdb.stock (
  STOCK_ID INT(10) PRIMARY KEY AUTO_INCREMENT,
  STOCK_CODE VARCHAR(10) NOT NULL,
  STOCK_NAME VARCHAR(20) NOT NULL
);

CREATE TABLE mkyongdb.category (
  CATEGORY_ID INT(10) PRIMARY KEY AUTO_INCREMENT,
  NAME VARCHAR(10) NOT NULL,
  DESCRIPTION VARCHAR(255) NOT NULL
);

CREATE TABLE  mkyongdb.stock_category (
  STOCK_CATEGORY_ID INT(10) PRIMARY KEY AUTO_INCREMENT,
  STOCK_ID INT(10) NOT NULL,
  CATEGORY_ID INT(10) NOT NULL,
  CREATED_DATE DATE,
  CREATED_BY VARCHAR(10) NOT NULL,
  CONSTRAINT FK_CATEGORY_ID FOREIGN KEY (CATEGORY_ID) 
             REFERENCES category (CATEGORY_ID),
  CONSTRAINT FK_STOCK_ID FOREIGN KEY (STOCK_ID) 
             REFERENCES stock (STOCK_ID)
);

CREATE TABLE  mkyongdb.stock_category_role (
  STOCK_CATEGORY_ID INT(10) NOT NULL,
  ROLE_ID INT(10) NOT NULL,
  PRIMARY KEY (ROLE_ID,STOCK_CATEGORY_ID),
  CONSTRAINT FK_STOCK_CATEGORY_ID FOREIGN KEY (STOCK_CATEGORY_ID) 
             REFERENCES STOCK_CATEGORY (STOCK_CATEGORY_ID),
  CONSTRAINT FK_ROLE_ID FOREIGN KEY (ROLE_ID) 
             REFERENCES role (ROLE_ID)
);
