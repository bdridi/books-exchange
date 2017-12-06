package org.books.exchange.controllers;


import javax.servlet.http.HttpServletRequest;

import org.books.exchange.entities.Book;
import org.books.exchange.entities.ExchangeOffer;
import org.books.exchange.entities.User;
import org.books.exchange.services.BooksService;
import org.books.exchange.services.OffersService;
import org.books.exchange.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OffersController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OffersController.class);
	
	@Autowired
	private OffersService offersService;
	@Autowired 
	BooksService booksService;
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/plainOffers", method = RequestMethod.GET)
	public Page<ExchangeOffer>getPlainOffers(@RequestParam(value="page", defaultValue="0") int page) {
		
		return offersService.getAllOffers(page);
	}
	
	@SuppressWarnings("unused")
	@RequestMapping(value="/saveOffer", method = RequestMethod.POST)
	public ResponseEntity<?> saveOffer(HttpServletRequest request) {
		
		// Request verification 
		String preference = request.getParameter("preference");
		if(preference == null) {
			return ResponseEntity.badRequest().body("Parameter preference is missing");
		}
		
		
		if(request.getParameter("book") == null) {
			return ResponseEntity.badRequest().body("Parameter Book is missing");
		}
		Long bookId = Long.parseLong(request.getParameter("book"));
		
						
		Book book = booksService.findBookById(bookId);
		if(book == null) {
			return ResponseEntity.badRequest().body("Invalid book");		
		}
		// Get authenticated user
		
		return ResponseEntity.ok().body(offersService.save(new ExchangeOffer(userService.getAuthenticatedUser(),book,preference)));		

	}
	
	// 
	@RequestMapping(value="/userOffers", method = RequestMethod.GET)
	public Page<ExchangeOffer>getUserOffers(@RequestParam(value="page", defaultValue="0") int page) {
		
		return offersService.authenticatedUserExchangeOffers(page);
	}
	

}
