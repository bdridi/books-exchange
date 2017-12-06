package org.books.exchange.controllers;

import java.util.List;

import javax.servlet.ServletRequest;

import org.books.exchange.entities.Book;
import org.books.exchange.services.BooksServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
																																																
	@Autowired				
	private BooksServiceImp bookService;
	 private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);
	
	@RequestMapping(value="/public/findBooks", method=RequestMethod.GET)
	public  List<Book> findBooksByName(@RequestParam(value="name",required=false, defaultValue="") String name) {
		
		LOGGER.info("@Parameter : "+name);
		return bookService.findBooksByName(name);
	}

}
	
	
