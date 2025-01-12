
-- Daniel McKee

-- Task 1
SELECT title AS Title, length AS Length
FROM film
WHERE description LIKE '%fun%' AND length <= 120;

-- Task 2
SELECT title AS Title
FROM film
WHERE title LIKE '%a' OR title LIKE '%e' OR title LIKE '%i' OR title LIKE '%o' OR title LIKE '%u';

-- Task 3
SELECT title AS Title
FROM film
WHERE length >= 120 AND length <= 180 ;

-- Task 4
SELECT title AS Title, length AS Length
FROM film
WHERE title LIKE '%river%' AND (rating = 'PG' OR rating = 'PG-13');

-- Task 5
SELECT title AS Title
FROM film
WHERE releASeYear > 2012 AND length > 160;

--Task 6
SELECT title AS 'Title', replacementCost AS "Replacement Cost", rating AS Rating
FROM film
WHERE replacementCost = 19.99 AND title NOT LIKE '_a%';

-- Task 7
SELECT title AS Title
FROM film
WHERE description IS NULL;

--Task 8
SELECT replacementCost AS "Replacement Cost"
FROM film
WHERE title = 'Town Ark';

--Task 9
SELECT title AS Title
FROM film
WHERE (rating = 'G' AND releaseYear = 2006) OR (rating = 'PG' AND releaseYear = 2010);

--Task 10
SELECT filmID AS "Film ID", title AS Title, releaseYear AS "Release Year", length as Length, replacementCost AS "Replacement Cost", rating AS Rating
FROM film
WHERE releaseYear != 2006 OR releaseYear != 2010;

--Task 11
UPDATE film
SET replacementCost = 5.59
WHERE releaseYear = 2006;

--Task 12
UPDATE film
SET replacementCost = 10.00
WHERE releaseYear = 2006;

--Task 13
DELETE FROM film
WHERE length < 60 AND rating = 'PG';