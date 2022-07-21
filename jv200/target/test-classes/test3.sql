1)
use jv250;

2)
show tables;

3)
select * from Customer;

4)
CREATE INDEX CustomerIndex ON Customer(ssn);

5)
SELECT a.aid, a.accountNum, a.accountType, a.balance, c.cid
FROM Account a INNER JOIN Customer c ON a.customerId = c.cid WHERE c.ssn = '840104-1234567';
