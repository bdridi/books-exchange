package org.books.exchange.services;

import java.util.List;

import org.books.exchange.dao.ExchangeRepository;
import org.books.exchange.entities.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class ExchangeServiceImp implements ExchangeService{

	@Autowired 
	ExchangeRepository exchangeDAO;
	@Autowired
	UserService userService;
	
	public ExchangeServiceImp() {
	}
	
	@Override
	public Page<Exchange> getAuthenticatedUserExchanges(int page) {
		
		return exchangeDAO.findUserExchanges(userService.getAuthenticatedUserId(), new PageRequest(page,10));

	}

	@Override
	public Exchange save(Exchange exchange) {
		
		return exchangeDAO.save(exchange);
	}
	
	
	
	

}
