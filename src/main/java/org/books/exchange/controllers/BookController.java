package org.books.exchange.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	@RequestMapping(value="/")
	public String home() {
		
		return "Hello Spring REST !" ;
	}

	}
	
	
