-- CREATE DATABASE semesterproject;
USE semesterproject;
DROP TABLE if exists buildings;
DROP TABLE if exists customer;


CREATE TABLE buildings(
    bID INT(2),
    bName VARCHAR(20),
    bAddress VARCHAR(20),
    parcelNr INT(2),
    bSize DOUBLE(2,0),
    bfPlan INT(2),
    condLvl INT(2)
);

CREATE TABLE customer(
    cID INT(3),
    cFname VARCHAR(30),
    cLname VARCHAR(30),
    cpw INT(3)
);

SELECT * FROM buildings;
SELECT * FROM customer;