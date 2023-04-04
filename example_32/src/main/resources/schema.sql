
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