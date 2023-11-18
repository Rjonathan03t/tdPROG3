CREATE TABLE IF NOT EXISTS subscriber(
    id_subscriber INT PRIMARY KEY,
    username varchar(30),
    password varchar (50)
);

INSERT INTO subscriber VALUES (1,'Jean','jeancode'),(2,'Jacque','jacquecode'),(3,'Luis','luiscode');