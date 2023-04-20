
--CREATE DATABASE easyschool;

use easyschool;

CREATE TABLE IF NOT EXISTS `contact_msg` (
`contactId` int AUTO_INCREMENT PRIMARY KEY,
 `name` varchar(100) NOT NULL,
 `mobileNum` varchar(10) NOT NULL,
 `email` varchar(100) NOT NULL,
 `subject` varchar(100) NOT NULL,
 `message` varchar(500)  NOT NULL,
 `status` varchar(20)  NOT NULL,
 `createdAt` TIMESTAMP NOT NULL,
 `createdBy` varchar(50) NOT NULL,
 `updatedAt` TIMESTAMP DEFAULT NULL,
 `updatedBy` varchar(50) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS `holidays` (
  `day` varchar(20) NOT NULL,
  `reason` varchar(100) NOT NULL,
  `type` varchar(20) NOT NULL,
  `created_at` TIMESTAMP NOT NULL,
  `created_by` varchar(50) NOT NULL,
  `updated_at` TIMESTAMP DEFAULT NULL,
  `updated_by` varchar(50) DEFAULT NULL
);




--CREATE DATABASE easyschool;

--use easyschool;

CREATE TABLE IF NOT EXISTS contact_msg (
contactId serial PRIMARY KEY,
 name text NOT NULL,
 mobileNum int NOT NULL,
 email text NOT NULL,
 subject text NOT NULL,
 message text  NOT NULL,
 status text  NOT NULL,
 createdAt TIMESTAMP NOT NULL,
 createdBy text NOT NULL,
 updatedAt TIMESTAMP DEFAULT NULL,
 updatedBy text DEFAULT NULL
);

create table contact_msg (

contactId serial primary key,
	name text not null,
	email text not null,
	message text not null,
	mobile_num text not null,
	status text not null,
	subject text not null,
	updated_at TIMESTAMP DEFAULT NULL ,
	updated_by text default null,
	created_at TIMESTAMP DEFAULT NULL,
	created_by text DEFAULT null

);




CREATE TABLE IF NOT EXISTS holidays (
  day text NOT NULL,
  reason text NOT NULL,
  type text NOT NULL,
  created_at TIMESTAMP DEFAULT NULL,
  created_by text DEFAULT NULL,
  updated_at TIMESTAMP DEFAULT NULL,
  updated_by text DEFAULT NULL
);


CREATE TABLE IF NOT EXISTS roles (
  role_id serial primary key,
  role_name text NOT NULL,
  created_at TIMESTAMP DEFAULT NULL,
  created_by text DEFAULT NULL,
  updated_at TIMESTAMP DEFAULT NULL,
  updated_by text DEFAULT NULL,

);

CREATE TABLE IF NOT EXISTS address(
  address_id serial primary key,
  address1 text NOT NULL,
  address2 text DEFAULT NULL,
  city text NOT NULL,
  state text NOT NULL,
  zip_code int NOT NULL,
  created_at TIMESTAMP DEFAULT NULL,
  created_by text DEFAULT NULL,
  updated_at TIMESTAMP DEFAULT NULL,
  updated_by text DEFAULT NULL,

);

CREATE TABLE IF NOT EXISTS person (
  person_id serial primary key,
  name text NOT NULL,
  email text NOT NULL,
  mobile_num text NOT NULL,
  password text NOT NULL,
  role_id int NOT NULL,
  address_id int default NULL,
  created_at TIMESTAMP DEFAULT NULL,
  created_by text DEFAULT NULL,
  updated_at TIMESTAMP DEFAULT NULL,
  updated_by text DEFAULT NULL,
  CONSTRAINT fk_roles FOREIGN KEY (role_id) REFERENCES roles(role_id),
  CONSTRAINT fk_address FOREIGN KEY (address_id) REFERENCES address(address_id)
);


CREATE TABLE IF NOT EXISTS class (
  class_id serial primary key,
  name text NOT NULL,
  created_at TIMESTAMP default NULL,
  created_by text default NULL,
  updated_at TIMESTAMP DEFAULT NULL,
  updated_by text DEFAULT NULL,
 -- PRIMARY KEY (`class_id`)
);

ALTER TABLE person
ADD COLUMN class_id int default NULL AFTER address_id,
ADD CONSTRAINT FK_CLASS_CLASS_ID FOREIGN KEY (class_id) REFERENCES class(class_id);


CREATE TABLE IF NOT EXISTS courses (
  course_id serial primary key,
  name varchar(100) NOT NULL,
  fees varchar(10) NOT NULL,
  created_at TIMESTAMP DEFAULT NULL,
  created_by varchar(50) DEFAULT NULL,
  updated_at TIMESTAMP DEFAULT NULL,
  updated_by varchar(50) DEFAULT NULL
  --PRIMARY KEY (`course_id`)
);

CREATE TABLE IF NOT EXISTS person_courses (
  person_id int NOT NULL,
  course_id int NOT NULL,
  FOREIGN KEY (person_id) REFERENCES person(person_id),
  FOREIGN KEY (course_id) REFERENCES courses(course_id),
  PRIMARY KEY (person_id,course_id)
);