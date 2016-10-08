CREATE SCHEMA MBTOOWNER AUTHORIZATION SA;
CREATE SEQUENCE MBTOOWNER.CUSTOMER_SEQ START WITH 5;

CREATE TABLE MBTOOWNER.CUSTOMER (
	CUSTOMER_ID BIGINT PRIMARY KEY ,
	VERSION BIGINT ,
	NAME VARCHAR(45) ,
	CREDIT DECIMAL(10,2)
) ;