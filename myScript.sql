CREATE DATABASE libraryDB

CREATE TABLE libraryDB.books (
  id int NOT NULL serial,
  name varchar(100),
  author varchar(100),
  reader_id int,
  PRIMARY KEY (id)
);


CREATE TABLE libraryDB.message_table (
  id bigint NOT NULL serial,
  message varchar(255),
  PRIMARY KEY (id)
);

CREATE TABLE libraryDB.readers (
  id int NOT NULL serial,
  name varchar(100),
  email varchar(100),
  telegram varchar(100),
  PRIMARY KEY (id),
  FOREIGN KEY (book_id) REFERENCES libraryDB.books(id)
);
  
  
INSERT INTO books(id, name, author, reader_id) 
VALUES	(1, 'Гордость и предубеждение', 'Джейн Остин', NULL),
		(1, 'Тёмные начала', 'Филип Пулман', NULL),
		(3, 'Автостопом по галактике', 'Дуглас Адамс', NULL),
		(4, 'Гарри Поттер и Кубок огня', 'Джоан Роулинг', NULL);
	
INSERT INTO readers(id, name, email, telegram, book_id) 
VALUES	(1, 'Nina Lowe', 'emailAddress', '1739275216', NULL),
		(2, 'Eric James', 'emailAddress', '1739243', NULL),
		(3, 'Jon Jonson', 'emailAddress', '17312334', NULL);