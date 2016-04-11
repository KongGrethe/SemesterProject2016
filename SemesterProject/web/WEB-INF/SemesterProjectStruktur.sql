-- DROP DATABASE IF EXISTS semesterproject;
-- CREATE DATABASE semesterproject;

USE semesterproject;
DROP TABLE if exists notification;
DROP TABLE if exists checkup;
DROP TABLE if exists buildings;
DROP TABLE if exists users;


CREATE TABLE users(
    uID INT(7) PRIMARY KEY AUTO_INCREMENT,
    uFName VARCHAR(30),
    uLName VARCHAR(30),
    upw VARCHAR(30),
    email VARCHAR(15),
    userRole ENUM('employee', 'customer'),
    FK_cuID INT(7) NOT NULL,
    FOREIGN KEY (FK_cuID) REFERENCES users(uID)
);

CREATE TABLE buildings(
    bID INT(7) PRIMARY KEY AUTO_INCREMENT,
    bName VARCHAR(30),
    bAddress VARCHAR(30),
    parcelNr INT(7),
    bSize DOUBLE(7,2),
    bfPlan INT(7),
    condLvl INT(7),
    FK_uID INT(7),
    FOREIGN KEY (FK_uID) REFERENCES users(uID)
);

CREATE TABLE checkup(
    checkupid INT(7) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    decay VARCHAR(30),
    FK_uID INT(7),
    FK_bID INT(7),
    FOREIGN KEY(FK_uID) REFERENCES users(uID),
    FOREIGN KEY(FK_bID) REFERENCES buildings(bID)
);

CREATE TABLE notification(
    nID int(7) PRIMARY KEY AUTO_INCREMENT,
    content varchar(300),
    FK_bID int(7),
    FOREIGN KEY (FK_bID) REFERENCES buildings(bID)
);

SELECT * FROM users;

-- INSERT INTO `semesterproject`.`users` VALUES (0, 'Aron', 'Jensen', '124', 'a@b.dk', 'employee', '1');
-- insert into users values(0,'Kurt','Koben','1234','z@y.com','customer','1');
-- insert into users values(0,'Anette','Kodstrup','jsp','a@x.co.uk','customer','2');

-- insert into users values(0,'An','K','vnz','aa@x.co.uk','employee','2');


-- insert into buildings values(100,"a","b",1,2,3,4,1);

select * from buildings;

-- DELETE FROM buildings WHERE bID = 1;

SELECT * FROM checkup;
SELECT * FROM notification;