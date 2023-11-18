CREATE TABLE IF NOT EXISTS author(
   id_author INT PRIMARY KEY,
   name varchar(50),
   gender char (1) CHECK ( gender = 'M' or gender = 'F')
);

INSERT INTO author VALUES (1,'Rakoto','M'),(2,'Rabe','M'),(3,'Ravaka','F');