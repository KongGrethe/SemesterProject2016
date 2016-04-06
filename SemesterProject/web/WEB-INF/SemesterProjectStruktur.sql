DROP DATABASE IF EXISTS semesterproject;
CREATE DATABASE semesterproject;

USE semesterproject;
DROP TABLE if exists checkup;
DROP TABLE if exists buildings;
DROP TABLE if exists users;


CREATE TABLE users(
    uID INT(7) PRIMARY KEY AUTO_INCREMENT,
    uFName VARCHAR(30),
    uLName VARCHAR(30),
    upw VARCHAR(7),
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

-- Hernede har jeg indsat nogle eksempelbrugere.
-- Da USERS cirkulært refererer til sig selv SKAL der være en begyndelsesbruger som alle kan henvise til, ellers virker det ikke.
-- Derfor skal i ikke slette Aron.
-- Den første værdi er 0, for AUTO_INCREMENT tager sig af den.
-- Lasse

INSERT INTO users VALUES (0, 'Aron', 'Jensen', '124', 'a@b.dk', 'employee', '1');
insert into users values(0,'Kurt','Koben','1234','z@y.com','customer','1');
insert into users values(0,'Anette','Kodstrup','jsp','a@x.co.uk','customer','2');

SELECT * FROM users;