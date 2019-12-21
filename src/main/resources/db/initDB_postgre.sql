DROP TABLE IF EXISTS "elements" ;
DROP SEQUENCE IF EXISTS global_seq ;

CREATE SEQUENCE GLOBAL_SEQ START WITH 100000;

CREATE TABLE "elements"
(
    id              INTEGER PRIMARY KEY DEFAULT nextval('GLOBAL_SEQ'),
    parent          VARCHAR(255),
    text            VARCHAR(255)    NOT NULL,
    children        BOOLEAN,
    type            VARCHAR(255)
);