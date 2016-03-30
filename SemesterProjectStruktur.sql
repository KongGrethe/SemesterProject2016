USE semesterproject;
DROP TABLE if exists buildings;

CREATE TABLE buildings(
	bid INT(2),
    bname VARCHAR(20),
    baddress VARCHAR(20),
    parcelnumb INT(2),
    bsize DOUBLE(2,0),
    conditionlvl INT(2)
);

SELECT * FROM buildings;