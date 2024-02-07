
CREATE DATABASE HW2;
USE HW2;

CREATE TABLE ITEM(
    itemID          VARCHAR(25),
    itemName        VARCHAR(25),
    name            VARCHAR(25),
    street          VARCHAR(25),
    city            VARCHAR(25),
    colors          VARCHAR(25),
    state           CHAR(2),
    zipcode         VARCHAR(10),
    cost            VARCHAR(10),
    retailPrice     VARCHAR(10),
    notes           VARCHAR(255),
    description     VARCHAR(255),
    returnable      CHAR(1),
    perishable      CHAR(1),
    shelfQty        INT,
    CONSTRAINT ITEM_pk PRIMARY KEY(itemID)
);