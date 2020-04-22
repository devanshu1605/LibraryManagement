package com.library.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
public class Book {

	@Id
    @GeneratedValue
    @Column(name="book_id")
	private long bookId;
	private String book_Name;
	private long library_Id;
	
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return book_Name;
	}
	public void setBookName(String bookName) {
		this.book_Name = bookName;
	}
	public long getLibraryId() {
		return library_Id;
	}
	public void setLibraryId(long libraryId) {
		this.library_Id = libraryId;
	}
	
	public String toString() {
		return (bookId+" : "+book_Name+" : "+library_Id);
	}
}
