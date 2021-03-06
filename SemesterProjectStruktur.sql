DROP DATABASE IF EXISTS semesterproject;
CREATE DATABASE semesterproject;

USE semesterproject;
DROP TABLE if exists files;
DROP TABLE if exists notification;
DROP TABLE if exists room;
DROP TABLE if exists checkup;
DROP TABLE if exists buildings;
DROP TABLE if exists users;


CREATE TABLE users(
    uID INT(7) PRIMARY KEY AUTO_INCREMENT,
    uFName VARCHAR(50),
    uLName VARCHAR(50),
    upw VARCHAR(50),
    email VARCHAR(50),
    userRole ENUM('employee', 'customer'),
    FK_cuID INT(7) NOT NULL,
    FOREIGN KEY (FK_cuID) REFERENCES users(uID)
);

CREATE TABLE buildings(
    bID INT(7) PRIMARY KEY AUTO_INCREMENT,
    bName VARCHAR(50),
    bAddress VARCHAR(50),
    parcelNr INT(7),
    bSize DOUBLE(7,2),
    bfPlan INT(7),
    condLvl INT(7),
    FK_uID INT(7),
    FOREIGN KEY (FK_uID) REFERENCES users(uID)
);

CREATE TABLE checkup(
    checkupid INT(7) PRIMARY KEY AUTO_INCREMENT NOT NULL,
    checkName VARCHAR(500),
    checkAddress VARCHAR(500),
    checkPostnr VARCHAR(500),
    checkDato VARCHAR(500),
    checkFileName VARCHAR(500),
    checkBygÅr VARCHAR(500),
    checkBygAreal VARCHAR(500),
    checkFormål VARCHAR(500),
    checkTag VARCHAR(500),
    checkYderVæg VARCHAR(500),
    TagFilNavn VARCHAR(500),
    yVægFilNavn VARCHAR(500),
    checkDecay VARCHAR(2),
    checkUdfør VARCHAR(500),
    checkAnsvar VARCHAR(500),
    FK_uID INT(7),
    FK_bID INT(7),
    FOREIGN KEY(FK_uID) REFERENCES users(uID),
    FOREIGN KEY(FK_bID) REFERENCES buildings(bID)
);

CREATE TABLE room(
    rName VARCHAR(50),
    rWhere VARCHAR(50),
    rHappened VARCHAR(50),
    rHasBeenDone VARCHAR(50),
    rDamageType VARCHAR(50),
    rWallNotes VARCHAR(50),
    rCeilingNotes VARCHAR(50),
    rFloorNotes VARCHAR(50),
    rWindowNotes VARCHAR(50),
    rWallName VARCHAR(50),
    rCeilingName VARCHAR(50),
    rFloorName VARCHAR(50),
    rWindowDoorName VARCHAR(50),
    rMoistScan VARCHAR(50),
    rMeasuringPoint VARCHAR(50),
    FK_bID INT(7),
    FOREIGN KEY (FK_bID) REFERENCES buildings(bID)
);

CREATE TABLE notification(
    nID int(7) PRIMARY KEY AUTO_INCREMENT,
    content varchar(500),
    FK_bID int(7),
    FK_uID int(7),
    FOREIGN KEY (FK_bID) REFERENCES buildings(bID),
    FOREIGN KEY (FK_uID) REFERENCES users(uID)
);

CREATE TABLE files(
    fName VARCHAR(50),
    FK_bID INT(7),
    FK_uID INT(7),
    FOREIGN KEY (FK_bID) REFERENCES buildings(bid),
    FOREIGN KEY (FK_uID) REFERENCES users(uID)
);

SELECT * FROM users;

-- INSERT INTO `semesterproject`.`users` VALUES (0, 'Aron', 'Jensen', '124', 'a@b.dk', 'employee', '1');
-- insert into users values(0,'Kurt','Koben','1234','z@y.com','customer','1');
-- insert into users values(0,'Anette','Kodstrup','jsp','a@x.co.uk','customer','2');

-- insert into users values(0,'An','K','vnz','aa@x.co.uk','employee','2');


-- insert into buildings values(100,"a","b",1,2,3,4,1);

SELECT * FROM buildings;

-- DELETE FROM buildings WHERE bID = 1;

SELECT * FROM checkup;
SELECT * FROM notification;
SELECT * FROM files;
SELECT * FROM room;