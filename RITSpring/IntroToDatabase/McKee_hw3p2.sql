
-- Daniel McKee

-- Task 1
INSERT INTO contactInfo (contactID, firstName, middleInitial, lastName, email, url, birthday, notes)
VALUES ('3', 'Eli', 'T', 'Wallowby', 'etwallowby@concor.com', 'www.concor.com/~wallowby', '1956-03-26', 'All meetings must be scheduled through his assistant.');

INSERT INTO contactInfo (contactID, firstName, middleInitial, lastName, email, url, birthday, notes)
VALUES ('4', 'Eve', 'C', 'Sampson', 'esampson@concor.com', NULL, '1972-05-11', 'Very helpful.');

INSERT INTO contactInfo (contactID, firstName, middleInitial, lastName, email, url, birthday, notes)
VALUES ('5', 'Carson', 'B', 'Campbell', 'cbc232@mvch.org', NULL, '1955-01-05', 'Wife: Lisa Kids: Lucas, Lucy, and Lucinda.');

INSERT INTO contactInfo (contactID, firstName, middleInitial, lastName, email, url, birthday, notes)
VALUES ('6', 'Daniel', 'G', 'McKee', 'dgm6546@rit.edu', NULL, '2004-04-15', ':)');

-- Task 2
ALTER TABLE contactInfo
ADD nickname VARCHAR(20) DEFAULT 'To Be Determined';

-- Task 3
ALTER TABLE contactInfo
MODIFY COLUMN firstName VARCHAR(15) NOT NULL;

ALTER TABLE contactInfo
MODIFY COLUMN lastName VARCHAR(25) NOT NULL;

-- Task 4
UPDATE contactInfo
SET nickname = 'Dave'
WHERE lastName = 'Munson' AND firstname = 'David';

-- Task 5
DELETE FROM contactInfo
WHERE url = 'www.concor.com/~wallowby';