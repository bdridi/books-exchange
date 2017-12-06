package org.books.exchange.controllers;

import java.util.List;

import org.books.exchange.entities.Exchange;
import org.books.exchange.entities.ExchangeOffer;
import org.books.exchange.services.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeController {
	
	@Autowired
	ExchangeService exchangeService;

	public ExchangeController() {
		
	}
	
	@RequestMapping(value="/userExchanges", method = RequestMethod.GET)
	public Page<Exchange> getUserExchanges(
			@RequestParam(value="page", defaultValue="0") int page) {
		
		return exchangeService.getAuthenticatedUserExchanges(page);
	}

}
