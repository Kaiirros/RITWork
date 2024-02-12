-- Daniel McKee

-- Task 1
SELECT headOfState AS "Head of State"
FROM country
WHERE name = 'United States';

-- Task 2
UPDATE country
SET headOfState = 'Joseph R. Biden'
WHERE name = 'United States';

-- Task 3
SELECT name AS "Country Name"
FROM country
WHERE indepYear IS NULL;

-- Task 4
SELECT name AS Name, continent as Continent
FROM country
WHERE (population > 1000000000) AND (lifeExpectancy BETWEEN 70 AND 80);

-- Task 5
SELECT name AS NAME
FROM country
WHERE continent = 'North America' OR continent = 'South America';