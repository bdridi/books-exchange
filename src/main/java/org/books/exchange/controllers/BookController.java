package org.books.exchange.controllers;

import java.util.List;

import org.books.exchange.entities.Book;
import org.books.exchange.services.BooksServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	@Autowired
	private BooksServiceImp bookService;
	
	@RequestMapping(value="/")
	public String home() {
		
		return "Hello Spring REST !" ;
	}

}
	
	
