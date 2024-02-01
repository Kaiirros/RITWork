# Date updated:  07/10/2020

-- Drops the conman database if it exists

DROP DATABASE IF EXISTS conman;
CREATE DATABASE conman;
USE conman;


-- Creates the contactInfo table

/* Since the database is dropped if it exists,
   there is no reason to drop the table */

CREATE TABLE contactInfo(
contactID int                   Comment "This will be the Primary Key",
firstName varchar(15),
middleInitial char(1),
lastName varchar(25),
email varchar(40),
url varchar(55),
birthday date,
notes varchar(255),
CONSTRAINT contactInfo_pk PRIMARY KEY(contactID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;