package org.books.exchange.services;

import java.util.List;

import org.books.exchange.entities.ExchangeOffer;
import org.springframework.data.domain.Page;

public interface OffersService {
	
	public Page<ExchangeOffer> getAllOffers(int page);

	public  ExchangeOffer save(ExchangeOffer exchangeOffer);
	
	public Page<ExchangeOffer> authenticatedUserExchangeOffers(int page);
	
	public ExchangeOffer getOffer(Long id);
		
}
