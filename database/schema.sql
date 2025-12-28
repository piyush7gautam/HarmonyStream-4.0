
CREATE DATABASE harmonystream;
USE harmonystream;
CREATE TABLE users(
 id INT AUTO_INCREMENT PRIMARY KEY,
 name VARCHAR(100),
 email VARCHAR(100),
 password VARCHAR(100),
 role ENUM('ADMIN','ARTIST','LISTENER')
);
CREATE TABLE music(
 id INT AUTO_INCREMENT PRIMARY KEY,
 title VARCHAR(100),
 album VARCHAR(100),
 genre VARCHAR(50),
 artist_id INT,
 status VARCHAR(20),
 streams INT DEFAULT 0
);
INSERT INTO users VALUES
(1,'Admin','admin@hs.com','admin','ADMIN'),
(2,'Artist','artist@hs.com','artist','ARTIST'),
(3,'Listener','listener@hs.com','listener','LISTENER');
