
DROP DATABASE IF EXISTS PE2;
CREATE DATABASE PE2;
USE PE2;

CREATE TABLE BOOK(
    title           VARCHAR(50),
    isbn13Number    CHAR(13),
    author          VARCHAR(255),
    numberOfPages   INT,
    releaseDate     DATE,
    CONSTRAINT BOOK_pk PRIMARY KEY(isbn13Number)
);