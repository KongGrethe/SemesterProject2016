-- CREATE DATABASE semesterproject;
USE semesterproject;
DROP TABLE if exists buildings;
DROP TABLE if exists customer;


CREATE TABLE buildings(
    bid INT(2),
    bname VARCHAR(20),
    baddress VARCHAR(20),
    parcelnr INT(2),
    bsize DOUBLE(2,0),
    bfplan INT(2),
    condLvl INT(2)
);

CREATE TABLE customer(
    cid INT(3),
    cfname VARCHAR(30),
    clname VARCHAR(30),
    cpw INT(3)
);

SELECT * FROM buildings;
SELECT * FROM customer;