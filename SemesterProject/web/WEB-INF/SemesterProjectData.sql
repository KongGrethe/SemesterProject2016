USE semesterproject;

-- Hernede har jeg indsat nogle eksempelbrugere.
-- Da USERS cirkulært refererer til sig selv SKAL der være en begyndelsesbruger som alle kan henvise til, ellers virker det ikke.
-- Derfor skal i ikke slette Aron.
-- Den første værdi er 0, for AUTO_INCREMENT tager sig af den.
-- Lasse

INSERT INTO users VALUES(0, 'Aron', 'Jensen', '124', 'a@b.dk', 'employee', '1');
INSERT INTO users VALUES(0, 'Kurt', 'Koben', '1234', 'z@y.com', 'customer', '1');
INSERT INTO users VALUES(0, 'Anette', 'Kodstrup', 'jsp', 'a@x.co.uk', 'customer', '2');

SELECT * FROM users;