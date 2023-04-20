INSERT INTO `holidays` (`day`,`reason`,`type`,`created_at`, `created_by`)
 VALUES (' Jan 1 ','New Year''s Day','FESTIVAL',CURDATE(),'DBA');

INSERT INTO `holidays` (`day`,`reason`,`type`,`created_at`, `created_by`)
 VALUES (' Oct 31 ','Halloween','FESTIVAL',CURDATE(),'DBA');

INSERT INTO `holidays` (`day`,`reason`,`type`,`created_at`, `created_by`)
 VALUES (' Nov 24 ','Thanksgiving Day','FESTIVAL',CURDATE(),'DBA');

INSERT INTO `holidays` (`day`,`reason`,`type`,`created_at`, `created_by`)
 VALUES (' Dec 25 ','Christmas','FESTIVAL',CURDATE(),'DBA');

INSERT INTO `holidays` (`day`,`reason`,`type`,`created_at`, `created_by`)
 VALUES (' Jan 17 ','Martin Luther King Jr. Day','FEDERAL',CURDATE(),'DBA');

INSERT INTO `holidays` (`day`,`reason`,`type`,`created_at`, `created_by`)
 VALUES (' July 4 ','Independence Day','FEDERAL',CURDATE(),'DBA');

INSERT INTO `holidays` (`day`,`reason`,`type`,`created_at`, `created_by`)
 VALUES (' Sep 5 ','Labor Day','FEDERAL',CURDATE(),'DBA');

INSERT INTO `holidays` (`day`,`reason`,`type`,`created_at`, `created_by`)
  VALUES (' Nov 11 ','Veterans Day','FEDERAL',CURDATE(),'DBA');



  INSERT INTO holidays (day,reason,type,created_at, created_by)
   VALUES (' Jan 1 ','New Year''s Day','FESTIVAL',CURRENT_DATE,'DBA');

  INSERT INTO holidays (day,reason,type,created_at, created_by)
   VALUES (' Oct 31 ','Halloween','FESTIVAL',CURRENT_DATE,'DBA');

  INSERT INTO holidays (day,reason,type,created_at, created_by)
   VALUES (' Nov 24 ','Thanksgiving Day','FESTIVAL',CURRENT_DATE,'DBA');

  INSERT INTO holidays (day,reason,type,created_at, created_by)
   VALUES (' Dec 25 ','Christmas','FESTIVAL',CURRENT_DATE,'DBA');

  INSERT INTO holidays (day,reason,type,created_at, created_by)
   VALUES (' Jan 17 ','Martin Luther King Jr. Day','FEDERAL',CURRENT_DATE,'DBA');

  INSERT INTO holidays (day,reason,type,created_at, created_by)
   VALUES (' July 4 ','Independence Day','FEDERAL',CURRENT_DATE,'DBA');

  INSERT INTO holidays (day,reason,type,created_at, created_by)
   VALUES (' Sep 5 ','Labor Day','FEDERAL',CURRENT_DATE,'DBA');

  INSERT INTO holidays (day,reason,type,created_at, created_by)
    VALUES (' Nov 11 ','Veterans Day','FEDERAL',CURRENT_DATE,'DBA');

  INSERT INTO roles (role_name,created_at, created_by)
    VALUES ('ADMIN',CURRENT_DATE,'DBA');

  INSERT INTO roles (role_name,created_at, created_by)
    VALUES ('STUDENT',CURRENT_DATE,'DBA');


INSERT INTO PERSON (name,email,mobile_num,password,role_id)
VALUES('Raj Aryan','ajay256410@gmail.com','9521409219','54321',1);

INSERT INTO PERSON (name,email,mobile_num,password,role_id)
VALUES('Ajay','ajay25641@gmail.com','8651789057','12345',2);