
CREATE TABLE ACCOUNT (
  ACCOUNT NVARCHAR2(20) NOT NULL, 
  EMAIL NVARCHAR2(20), 
  FIRSTNAME NVARCHAR2(20), 
  LASTNAME NVARCHAR2(20),
  PRIMARY KEY (ACCOUNT)
);

CREATE TABLE CLASS (
  ID NVARCHAR2(20) NOT NULL, 
  HOTEN NVARCHAR2(20),
  EMAIL NVARCHAR2(20), 
  SDT NVARCHAR2(20), 
  LOP NVARCHAR2(20), 
  GHICHU NVARCHAR2(20), 
  ACCOUNT NVARCHAR2(20), 
  PRIMARY KEY (ID),
  CONSTRAINT FK_CL_AC_ACC
  FOREIGN KEY (ACCOUNT) REFERENCES ACCOUNT (ACCOUNT)
); 

UPDATE "ITSOL"."CLASS" SET HOTEN = 'Nguyễn Năm2', EMAIL = 'nam2@gmail.com', SDT = '099999999952', LOP = 'LH3', GHICHU = 'Không2', ACCOUNT = 'thai' WHERE ROWID = 'AAAE7YAABAAALHBAAE' AND ORA_ROWSCN = '580684';

SELECT ID, HOTEN, EMAIL, SDT, LOP, GHICHU, ACCOUNT FROM TUAN.CLASS;
SELECT ID, HOTEN, EMAIL, SDT, LOP, GHICHU, ACCOUNT FROM TUAN.CLASS WHERE LOP = 'LH2';
SELECT ID, HOTEN, EMAIL, SDT, LOP, GHICHU, ACCOUNT FROM TUAN.CLASS WHERE LOP = 'LH2';
DELETE FROM "TUAN"."CLASS" WHERE ROWID = 'AAAE7YAABAAALHBAAF' AND ORA_ROWSCN = '580931' and ( "ID" is null or "ID" is not null );
SELECT ID, HOTEN, EMAIL, SDT, LOP, GHICHU, ACCOUNT FROM TUAN.CLASS WHERE HOTEN LIKE '%ộ%';

