-- CREATE DATABASE semesterproject;

USE semesterproject;
DROP TABLE if exists checkup;
DROP TABLE if exists buildings;
DROP TABLE if exists customer;
DROP TABLE if exists employee;
DROP TABLE if exists users;


CREATE TABLE users(
    uID INT(1) PRIMARY KEY,
    userName VARCHAR(10),
    upw INT(1),
    userRole ENUM('employee', 'customer')
);

CREATE TABLE employee(
    eID INT(2) PRIMARY KEY,
    eFname VARCHAR(20),
    eLname VARCHAR(20),
    epw INT(2),
    FK_uID INT(2),
    FOREIGN KEY (FK_uID) REFERENCES users(uID)
);

CREATE TABLE customer(
    cID INT(3) PRIMARY KEY,
    cFname VARCHAR(30),
    cLname VARCHAR(30),
    cpw INT(3),
    eID INT(3) UNIQUE KEY,
    FK_uID INT(3),
    FK_eID INT(3),
    FOREIGN KEY (FK_uID) REFERENCES users(uID),
    FOREIGN KEY (FK_eID) REFERENCES employee(eID)
);

CREATE TABLE buildings(
    bID INT(4) PRIMARY KEY,
    bName VARCHAR(40),
    bAddress VARCHAR(40),
    parcelNr INT(4),
    bSize DOUBLE(4,0),
    bfPlan INT(4),
    condLvl INT(4),
    FK_cID INT(4),
    FOREIGN KEY (FK_cID) REFERENCES customer(cID)
);

CREATE TABLE checkup(
    decay VARCHAR(50),
    FK_bID INT(5),
    FK_eID INT(5),
    FOREIGN KEY(FK_bID) REFERENCES buildings(bID),
    FOREIGN KEY(FK_eID) REFERENCES employee(eID)
);

SELECT * FROM users;
SELECT * FROM employee;
SELECT * FROM customer;
SELECT * FROM buildings;
SELECT * FROM checkup;