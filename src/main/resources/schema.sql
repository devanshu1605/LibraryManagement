DROP TABLE IF EXISTS Book;
  


DROP TABLE IF EXISTS Library;
  
CREATE TABLE Library(
  library_Id INT AUTO_INCREMENT  PRIMARY KEY,
  library_Name VARCHAR(250) NOT NULL
);

CREATE TABLE Book(
  book_Id INT AUTO_INCREMENT  PRIMARY KEY,
  book_Name VARCHAR(250) NOT NULL,
  library_Id INT 
);



ALTER TABLE Book
    ADD FOREIGN KEY (library_id) 
    REFERENCES Library(library_id);
  




