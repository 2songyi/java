CREATE TABLE Sample10 (
	no			INT(11) 		DEFAULT NULL,
	name 		VARCHAR(20) 	DEFAULT NULL,
	birthday	DATE			DEFAULT NULL,
	adress		VARCHAR(40)		DEFAULT NULL
);

SELECT * FROM Sample10;

INSERT INTO Sample10 VALUES (1, '짱구', '1996-10-25', '대구 중구 반월당');
INSERT INTO Sample10 VALUES (2, '철수', '1996-8-10', '대구 달성군');
INSERT INTO Sample10 VALUES (3, '맹구', '1996-4-20', '대구 서구');

DROP TABLE Customer;
CREATE TABLE Customer (
	cid			BIGINT			PRIMARY KEY AUTO_INCREMENT,
	name		VARCHAR(20) 	NOT NULL,
	ssn 		VARCHAR(14) 	NOT NULL,
	phone		VARCHAR(20)	 	NOT NULL,
	customerId 	VARCHAR(16)		NOT NULL,
	passwd 		VARCHAR(16)		NOT NULL,
	regDate		TIMESTAMP		NOT NULL 	DEFAULT CURRENT_TIMESTAMP
) AUTO_INCREMENT = 1001;

SELECT * FROM Customer;

INSERT INTO Customer (name, ssn, phone, customerId, passwd) 
VALUES ('짱구', '961025-1234567', '010-1111-2222', 'abs1234', '1234');
INSERT INTO Customer (name, ssn, phone, customerId, passwd) 
VALUES ('철수', '960810-1234567', '010-3333-2222', 'fe1234', 'fe1234');
INSERT INTO Customer (name, ssn, phone, customerId, passwd) 
VALUES ('맹구', '960420-1234567', '010-1111-3333', 'mg1234', 'm1234');

UPDATE Customer SET ssn='961225-1111111', phone='010-3333-0000' WHERE cid=1001;

DELETE FROM Customer WHERE cid=1002;

DROP TABLE Account;
CREATE TABLE Account (
	aid				BIGINT			PRIMARY KEY AUTO_INCREMENT,
	accountNum		VARCHAR(11)		NOT NULL, 	-- 111-11-1111
	balance			DOUBLE			NOT NULL 	DEFAULT 0.0,
	interestRate	DOUBLE			NOT NULL	DEFAULT 0.0,
	overdraft		DOUBLE			NOT NULL	DEFAULT 0.0,
	accountType		CHAR			NOT NULL	DEFAULT 'S',
	customerId		BIGINT			NOT NULL,
	regDate			TIMESTAMP		NOT NULL 	DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT	Account_CustomerId_FK FOREIGN KEY (customerId) REFERENCES Customer(cid) -- 제약조건
) AUTO_INCREMENT = 3001;

SELECT * FROM Account;

INSERT INTO Account (accountNum, balance, interestRate, overdraft, accountType, customerId) 
VALUES ('111-11-1111', 30000, 1.5, 0, 'S', 1001 );
INSERT INTO Account (accountNum, balance, interestRate, overdraft, accountType, customerId) 
VALUES ('222-22-2222', 30000, 0, 1.2, 'C', 1002 );
INSERT INTO Account (accountNum, balance, interestRate, overdraft, accountType, customerId) 
VALUES ('333-33-3333', 30000, 1.5, 0, 'S', 1003 );	

SELECT a.aid, a.accountNum, a.balance, a.interestRate, a.overdraft, a.accountType, c.name, c.ssn, c.phone, a.regDate 
FROM Account a INNER JOIN Customer c 
ON a.customerId = c.cid 
WHERE c.ssn ='880123-1234568';

-- inner join
SELECT * FROM Account, Customer WHERE Account.customerId = Customer.cid;

SELECT * FROM Account a INNER JOIN Customer c ON a.customerId = c.cid;

SELECT * FROM Account a INNER JOIN Customer c ON a.customerId = c.cid WHERE c.ssn = "898989-1234567";



ALTER TABLE Customer CHANGE customerId userId VARCHAR(16) NOT NULL;

SELECT * FROM Customer;

SELECT a.aid, a.accountNum, a.balance, a.interestRate, a.overdraft, a.accountType, c.name, c.ssn, c.phone, a.regDate
FROM Account a INNER JOIN Customer c ON a.customerId = c.cid WHERE c.ssn = '800123-1234568';

SELECT balance FROM Account WHERE accountNum = '740-04-1524';


-- add User
CREATE TABLE MyUser (
	cid			BIGINT			PRIMARY KEY AUTO_INCREMENT,
	userId		VARCHAR(16)		NOT NULL,
	passwd		VARCHAR(16)		NOT NULL,
	userName	VARCHAR(20)		NOT NULL,	
	ssn			VARCHAR(14)		NOT NULL,
	email		VARCHAR(30)		NOT NULL,
	addr		VARCHAR(30)		NOT NULL
) AUTO_INCREMENT = 1001;

SELECT * FROM MyUser;
SELECT * FROM MyUser WHERE userId = 'sdf';




