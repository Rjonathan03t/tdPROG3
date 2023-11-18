CREATE TABLE IF NOT EXISTS Book (
   id_book int  PRIMARY KEY,
   title varchar(50),
   topic Topic,
   id_author INT REFERENCES author(id_author) NOT NULL
);

INSERT INTO Book VALUES (1,'Parisien','OTHER',1),(2,'Dernier Americain','ROMANCE',2),(3,'Norman','COMEDY',3);