USE demo;

DROP TABLE IF EXISTS EMP;
CREATE TABLE EMP (
  id INT AUTO_INCREMENT,
  name VARCHAR(50),
  PRIMARY KEY(id)
);

SELECT * FROM emp;
INSERT INTO emp(name) values("펭수");
INSERT INTO emp(name) values("길동");
INSERT INTO emp(name) values("라이언");
INSERT INTO emp(name) values("실버");
INSERT INTO emp(name) values("마틸다");


DROP TABLE IF EXISTS comment;
CREATE TABLE comment (
  id INT NOT NULL AUTO_INCREMENT,
  comment TEXT DEFAULT NULL,
  email VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY(id)
);









