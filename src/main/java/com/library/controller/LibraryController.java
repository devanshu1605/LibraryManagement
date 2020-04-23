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
import org.springframework.http.MediaType;
import javax.servlet.http.HttpServletResponse;


@RestController
public class LibraryController {
	
	@Autowired
	LibraryRepository repository;
	
	@Autowired
	BookRepository bookrepository;

	@CrossOrigin
	@GetMapping("/getlibraries")
	public List<Library> getLibraries() {
		if(((List<Library>)repository.findAll()).isEmpty()) {
			Library lib = new Library();
			lib.setLibraryName("Library 1");
			lib.setLibraryId(1000);
			repository.save(lib);
		}
		return (List<Library>)repository.findAll();
	}
	 
	@CrossOrigin
	@GetMapping("/getBooks")
	public List<Book> getBooks() {
	      return (List<Book>)bookrepository.findAll();
	}

	@CrossOrigin
	@GetMapping("/addOrUpdateBooks")
	public ResponseModel sayHello(@RequestParam long bookid,
			@RequestParam String bookname, @RequestParam long libid) {
		Book book=null;
		ResponseModel body= new ResponseModel();
		if(bookid==0) {
	    	  book= new Book();
	    	  book.setBookName(bookname);
	    	  book.setLibraryId(libid);
	     }else {
	    	  book= bookrepository.findByBookId(bookid);
	    	  book.setBookName(bookname);
	     }
	      
	      final Book updatedorCreatedBook = bookrepository.save(book);
	      System.out.println("updated book "+updatedorCreatedBook.toString());
	      if(null!=updatedorCreatedBook) {
	    	  body.setMessage("success");
	      }
	      
	      return body;
	   }
	
}
