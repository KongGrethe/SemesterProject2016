-- DROP DATABASE IF EXISTS semesterproject;
-- CREATE DATABASE semesterproject;

USE semesterproject;
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
    bID INT(7) PRIMARY KEY,
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
    decay VARCHAR(30),
    FK_uID INT(7),
    FK_bID INT(7),
    FOREIGN KEY(FK_uID) REFERENCES users(uID),
    FOREIGN KEY(FK_bID) REFERENCES buildings(bID)
);