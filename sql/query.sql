-- CREATE TABLE USERS (ID INTEGER PRIMARY KEY, USERNAME TEXT, PASSWORD TEXT)

TRUNCATE USERS;

INSERT INTO USERS VALUES (1, 'vavin', '123');

INSERT INTO USERS VALUES (2, 'sus', '123');

COMMIT;

SELECT * FROM USERS;
