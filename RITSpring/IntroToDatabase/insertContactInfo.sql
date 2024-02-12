-- Updated 07/10/2020
-- Inserts record into contactInfo
-- Please notice not every attribute/field listed has a value
-- Qty of attribute names is 8
-- Qty of values is 7

INSERT INTO contactInfo
(contactID,
firstName,
middleInitial,
lastName,
email,
url,
birthday,
notes)
VALUES
(1,
'David',
'C',
'Munson',
'munson@rit.edu',
'http://www.rit.edu/president',
NULL,
'Started as President of RIT on July 1, 2017.');
