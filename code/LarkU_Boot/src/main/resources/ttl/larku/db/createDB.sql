set schema larku;

DROP TABLE STUDENT_SCHEDULEDCLASS;

DROP TABLE SCHEDULEDCLASS;

DROP TABLE COURSE;

DROP TABLE STUDENT;

DROP SCHEMA larku RESTRICT;

create schema larku;

set schema larku;

CREATE TABLE STUDENT (
		ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ,
		NAME VARCHAR(255),
		PHONENUMBER VARCHAR(20),
		STATUS VARCHAR(20)
	);

CREATE TABLE COURSE (
		ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
		CODE VARCHAR(20),
		CREDITS DOUBLE NOT NULL,
		TITLE VARCHAR(255)
	);

CREATE TABLE SCHEDULEDCLASS (
		ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
		ENDDATE VARCHAR(20),
		STARTDATE VARCHAR(20),
		COURSE_ID INTEGER
	);

CREATE TABLE STUDENT_SCHEDULEDCLASS (
		STUDENTS_ID INTEGER NOT NULL,
		CLASSES_ID INTEGER NOT NULL
	);

CREATE UNIQUE INDEX SQL150211090953900 ON COURSE (ID ASC);

CREATE INDEX SQL150211090954080 ON STUDENT_SCHEDULEDCLASS (CLASSES_ID ASC);

CREATE INDEX SQL150211090953990 ON SCHEDULEDCLASS (COURSE_ID ASC);

CREATE UNIQUE INDEX SQL150211090953920 ON SCHEDULEDCLASS (ID ASC);

CREATE UNIQUE INDEX SQL150211090953950 ON STUDENT (ID ASC);

CREATE INDEX SQL150211090954040 ON STUDENT_SCHEDULEDCLASS (STUDENTS_ID ASC);

ALTER TABLE COURSE ADD CONSTRAINT SQL150211090953900 PRIMARY KEY (ID);

ALTER TABLE SCHEDULEDCLASS ADD CONSTRAINT SQL150211090953920 PRIMARY KEY (ID);

ALTER TABLE STUDENT ADD CONSTRAINT SQL150211090953950 PRIMARY KEY (ID);

ALTER TABLE STUDENT_SCHEDULEDCLASS ADD CONSTRAINT FK318CA38F83AAB40 FOREIGN KEY (CLASSES_ID)
	REFERENCES SCHEDULEDCLASS (ID);

ALTER TABLE STUDENT_SCHEDULEDCLASS ADD CONSTRAINT FK318CA38F5E4D1BDC FOREIGN KEY (STUDENTS_ID)
	REFERENCES STUDENT (ID);

ALTER TABLE SCHEDULEDCLASS ADD CONSTRAINT FKE64C28EBD735B77B FOREIGN KEY (COURSE_ID)
	REFERENCES COURSE (ID);


	