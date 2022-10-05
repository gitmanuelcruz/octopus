ALTER SESSION set "_ORACLE_SCRIPT"=TRUE;

/
CREATE USER SCOTT
  IDENTIFIED BY scott
  DEFAULT TABLESPACE USERS
  TEMPORARY TABLESPACE TEMP
  PROFILE DEFAULT
  ACCOUNT UNLOCK
 /
GRANT CONNECT TO SCOTT;
GRANT RESOURCE TO SCOTT;
ALTER USER SCOTT DEFAULT ROLE ALL;

-- 1 System Privilege for SCOTT 
GRANT UNLIMITED TABLESPACE TO SCOTT;

