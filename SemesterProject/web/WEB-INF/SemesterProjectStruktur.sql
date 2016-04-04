-- CREATE DATABASE semesterproject;

USE semesterproject;
DROP TABLE if exists checkup;
DROP TABLE if exists buildings;
DROP TABLE if exists customer;
DROP TABLE if exists employee;
DROP TABLE if exists users;


CREATE TABLE users(
    uID INT(7) PRIMARY KEY,
    userName VARCHAR(30),
    upw VARCHAR(30),
    userRole ENUM('employee', 'customer')
);

CREATE TABLE employee(
    eID INT(7) PRIMARY KEY,
    eFname VARCHAR(30),
    eLname VARCHAR(30),
    epw VARCHAR(30),
    FK_uID INT(7),
    FOREIGN KEY (FK_uID) REFERENCES users(uID)
);

CREATE TABLE customer(
    cID INT(7) PRIMARY KEY,
    cFname VARCHAR(30),
    cLname VARCHAR(30),
    cpw VARCHAR(7),
    FK_uID INT(7),
    FK_eID INT(7),
    FOREIGN KEY (FK_uID) REFERENCES users(uID),
    FOREIGN KEY (FK_eID) REFERENCES employee(eID)
);

CREATE TABLE buildings(
    bID INT(7) PRIMARY KEY,
    bName VARCHAR(30),
    bAddress VARCHAR(30),
    parcelNr INT(7),
    bSize DOUBLE(7,2),
    bfPlan INT(7),
    condLvl INT(7),
    FK_cID INT(7),
    FOREIGN KEY (FK_cID) REFERENCES customer(cID)
);

CREATE TABLE checkup(
    decay VARCHAR(30),
    FK_bID INT(7),
    FK_eID INT(7),
    FOREIGN KEY(FK_bID) REFERENCES buildings(bID),
    FOREIGN KEY(FK_eID) REFERENCES employee(eID)
);

SELECT * FROM users;
SELECT * FROM employee;
SELECT * FROM customer;
SELECT * FROM buildings;
SELECT * FROM checkup;