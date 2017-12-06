package org.books.exchange.services;

import java.util.List;

import org.books.exchange.dao.ExchangeOfferRepository;
import org.books.exchange.entities.ExchangeOffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class OffersServiceImp implements OffersService {
	
	
	private static final int ELEMENTS_PER_PAGE = 10;

	@Autowired
	private ExchangeOfferRepository offersDAO;
	@Autowired
	private UserService userService;
	
	public OffersServiceImp() {
	
	}

	@Override
	public Page<ExchangeOffer> getAllOffers(int page) {
		return offersDAO.findPlainOffers(new PageRequest(page, ELEMENTS_PER_PAGE));
	}

	@Override
	public ExchangeOffer save(ExchangeOffer exchangeOffer) {
		
		return offersDAO.save(exchangeOffer);
	}

	@Override
	public Page<ExchangeOffer> authenticatedUserExchangeOffers(int page) {
		
		return offersDAO.findUserOffers(userService.getAuthenticatedUserId(), new PageRequest(page, ELEMENTS_PER_PAGE));
	}

	@Override
	public ExchangeOffer getOffer(Long id) {
		
		return offersDAO.findOne(id);
	}

}
