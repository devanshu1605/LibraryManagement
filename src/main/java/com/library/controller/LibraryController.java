package com.library.controller;

import com.library.model.Book;
import com.library.model.Library;
import com.library.repository.LibraryRepository;
import com.library.repository.BookRepository;
import com.library.model.ResponseModel;

import java.util.List;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
public class LibraryController {
	
	@Autowired
	LibraryRepository repository;
	
	@Autowired
	BookRepository bookrepository;

	@CrossOrigin
	@GetMapping("/getlibraries")
	public List<Library> getLibraries() {
		return (List<Library>)repository.findAll();
	}
	 
	@CrossOrigin
	@GetMapping("/getBooks")
	public List<Book> getBooks() {
	      return (List<Book>)bookrepository.findAll();
	}

	@CrossOrigin
	@PostMapping("/addOrUpdateBooks")
	public ResponseModel sayHello(@RequestParam String requestType, @RequestBody Book updatebook) {
		Book book=null;
		ResponseModel body= new ResponseModel();
		if(requestType.equals("addbook")) {
	    	  book= new Book();
	    	  book.setBookName(updatebook.getBookName());
	    	  book.setLibraryId(updatebook.getLibraryId());
	     }else {
	    	  book= bookrepository.findByBookId(updatebook.getBookId());
	    	  book.setBookName(updatebook.getBookName());
	     }
	      
	      final Book updatedorCreatedBook = bookrepository.save(book);
	      System.out.println("updated book "+updatedorCreatedBook.toString());
	      if(null!=updatedorCreatedBook) {
	    	  body.setMessage("success");
	      }
	      return body;
	   }
	
}
