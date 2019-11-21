create table user905(id number(5)primary key,name varchar2(40),password varchar2(40),email varchar2(40),country varchar2(40));

create sequence user_seq start with 1;

CREATE OR REPLACE TRIGGER user_seq 
BEFORE INSERT ON user905 
FOR EACH ROW

BEGIN
  SELECT user_seq.NEXTVAL
  INTO   :new.id
  FROM   dual;
END;