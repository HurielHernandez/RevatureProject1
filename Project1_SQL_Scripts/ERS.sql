/*Drop database if exists*/

DROP USER ERS_User CASCADE;

/*Create the database*/
Create USER ERS_User
IDENTIFIED BY ERS_Password
Default TABLESPACE users 
TEMPORARY TABLESPACE temp
QUOTA 10M on users;

/*Create Grants*/
GRANT connect to ERS_User;
GRANT resource to ERS_User;
GRANT create session to ERS_User;
GRANT CREATE TABLE TO ERS_User;
GRANT CREATE view To ERS_User;

/*Connect as new user, otherwise will use current user*/
CONNECT ERS_User/ERS_Password;


/*Create the Tables*/
CREATE TABLE ERS_REIMBURSMENT_STATUS(
    RS_ID NUMBER(*, 0) ,
    RS_STATUS VARCHAR2(30) NOT NULL,
    Constraint PK_RS_ID Primary Key(RS_ID)
);

CREATE TABLE ERS_REIMBURSMENT_TYPE(
    RT_ID NUMBER(*,0),
    RT_TYPE VARCHAR2(30) NOT NULL,
     Constraint PK_RT_ID Primary Key(RT_ID)
);

CREATE TABLE ERS_REIMBURSMENTS(
    R_ID Number,
    R_AMOUNT Number(22,2) Not Null,
    R_DESCRIPTION VARCHAR2(100),
    R_RECIEPT BLOB,
    R_SUBMITTED TIMESTAMP NOT NULL,
    R_RESOLVED TIMESTAMP,
    U_ID_AUTHOR NUMBER NOT NULL,
    U_ID_RESOLVER NUMBER,
    RT_TYPE NUMBER NOT NULL,
    RT_STATUS NUMBER NOT NULL,
    Constraint PK_R_ID Primary Key(R_ID),
    Constraint FK_U_ID_A FOREIGN KEY(U_ID_AUTHOR) REFERENCES ERS_USERS(U_ID),
    Constraint FK_U_ID_R FOREIGN KEY(U_ID_RESOLVER) REFERENCES ERS_USERS(U_ID),
    Constraint FK_RT_TYPE FOREIGN KEY(RT_TYPE) REFERENCES ERS_REIMBURSMENT_TYPE(RT_ID),
    Constraint FK_RT_STATUS FOREIGN KEY(RT_STATUS) REFERENCES ERS_REIMBURSMENT_STATUS(RS_ID)
);

Create Table ERS_USERS(
    U_ID Number(*,0),
    U_USERNAME VARCHAR2(40) NOT NULL,
    U_PASSWORD VARCHAR2(40)NOT NULL,
    U_FIRSTNAME VARCHAR2(30),
    U_LASTNAME VARCHAR2(30),
    U_EMAIL VARCHAR2(100),
    UR_ID NUMBER(*, 0),
    Constraint PK_U_ID PRIMARY KEY(U_ID),
    Constraint FK_UR_ID FOREIGN KEY (UR_ID) REFERENCES ERS_USER_ROLES(UR_ID),
    Constraint U_USERNAME_un UNIQUE(U_USERNAME),
    Constraint U_EMAIL_un UNIQUE(U_EMAIL)
);

CREATE TABLE ERS_USER_ROLES(
    UR_ID NUMBER(*,0),
    UR_ROLE VARCHAR2(40),
    Constraint PK_UR_ID Primary Key(UR_ID)
);

/*Creating Sequences*/
/*Create Sequences*/
Create Sequence SQ_PK_ERS_USERS
START WITH 1
INCREMENT BY 1;
/
Create Sequence SQ_PK_ERS_USERS_ROLES
START WITH 1
INCREMENT BY 1;
/

Create Sequence SQ_PK_REIMBURSMENTS
START WITH 1
INCREMENT BY 1;
/

Create Sequence SQ_PK_REIMBURSMENTS_TYPES
START WITH 1
INCREMENT BY 1;
/

Create Sequence SQ_PK_REIMBURSMENTS_STATUS
START WITH 1
INCREMENT BY 1;
/

/*Create the Triggers*/
CREATE OR REPLACE TRIGGER TR_INSERT_USERS
BEFORE INSERT ON ERS_USERS
FOR EACH ROW 
BEGIN
    SELECT SQ_PK_ERS_USERS.NEXTVAL INTO :NEW.U_ID FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER TR_INSERT_USER_ROLES
BEFORE INSERT ON ERS_USER_ROLES
FOR EACH ROW 
BEGIN
    SELECT SQ_PK_ERS_USER_ROLES.NEXTVAL INTO :NEW.UR_ID FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER TR_INSERT_REIMBURSMENTS
BEFORE INSERT ON ERS_REIMBURSMENTS
FOR EACH ROW 
BEGIN
    SELECT SQ_PK_REIMBURSMENTS.NEXTVAL INTO :NEW.R_ID FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER TR_INSERT_REIMBURSMENT_TYPES
BEFORE INSERT ON ERS_REIMBURSMENT_TYPE
FOR EACH ROW 
BEGIN
    SELECT SQ_PK_REIMBURSMENTS_TYPES.NEXTVAL INTO :NEW.RT_ID FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER TR_INSERT_REIMBURSMENT_STATUS
BEFORE INSERT ON ERS_REIMBURSMENT_STATUS
FOR EACH ROW 
BEGIN
    SELECT SQ_PK_REIMBURSMENTS_STATUS.NEXTVAL INTO :NEW.RS_ID FROM DUAL;
END;
/