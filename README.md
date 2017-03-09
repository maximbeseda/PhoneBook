-- SQL Queries for creating database tables.

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fullName` varchar(255) NOT NULL,
  `login` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `userRole` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

CREATE TABLE `contacts` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `surname` varchar(255) NOT NULL,
  `patronymic` varchar(255) NOT NULL,
  `mobilePhone` varchar(255) NOT NULL,
  `homePhone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `customUser_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY (`customUser_id`),
  CONSTRAINT FOREIGN KEY (`customUser_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;