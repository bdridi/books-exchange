package org.books.exchange.services;


import org.books.exchange.entities.Exchange;
import org.springframework.data.domain.Page;

public interface ExchangeService {

	public Exchange save(Exchange exchange);
	
	public Page<Exchange> getAuthenticatedUserExchanges(int page);
}
