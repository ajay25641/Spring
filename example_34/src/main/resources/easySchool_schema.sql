
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

CREATE TABLE IF NOT EXISTS holidays (
  day text NOT NULL,
  reason text NOT NULL,
  type text NOT NULL,
  created_at TIMESTAMP NOT NULL,
  created_by text NOT NULL,
  updated_at TIMESTAMP DEFAULT NULL,
  updated_by text DEFAULT NULL
);
