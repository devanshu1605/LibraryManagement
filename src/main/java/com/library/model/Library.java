package com.library.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Library {

	@Id
    @GeneratedValue
	private long library_Id;
	
	private String library_Name;
	
	public long getLibraryId() {
		return library_Id;
	}
	public void setLibraryId(long libraryId) {
		this.library_Id = libraryId;
	}
	public String getLibraryName() {
		return library_Name;
	}
	public void setLibraryName(String libraryName) {
		this.library_Name = libraryName;
	}
	
}
