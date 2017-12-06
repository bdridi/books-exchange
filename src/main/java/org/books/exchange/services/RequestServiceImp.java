package org.books.exchange.services;

import java.util.List;

import org.books.exchange.controllers.BookController;
import org.books.exchange.dao.ExchangeRequestRepository;
import org.books.exchange.entities.ExchangeRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class RequestServiceImp implements RequestService {
	
	
	private static final int ELEMENTS_PER_PAGE = 10;

	@Autowired
	ExchangeRequestRepository requestDAO;
	@Autowired
	UserService userService;
	private static final Logger LOGGER = LoggerFactory.getLogger(RequestServiceImp.class);


	
	public RequestServiceImp() {
			
	}
	
	@Override
	public Page<ExchangeRequest> authenticatedUserRecievedRequests(int page)  {
		
		LOGGER.info("finding requests ....");
		return requestDAO.findUserRecievedRequests(userService.getAuthenticatedUserId(), new PageRequest(page,ELEMENTS_PER_PAGE));
	}
	
	@Override
	public Page<ExchangeRequest> authenticatedUserSendedRequests(int page) {
		
		LOGGER.info("finding requests ....");
		return requestDAO.findUserSendedRequests(userService.getAuthenticatedUserId(),  new PageRequest(page,ELEMENTS_PER_PAGE));
	}

	@Override
	public ExchangeRequest save(ExchangeRequest exRequest) {
		
		return requestDAO.save(exRequest);
	}

	@Override
	public ExchangeRequest getOne(Long id) {
		
		return requestDAO.findOne(id);
	}

	@Override
	public List<ExchangeRequest> getOthersToBeNonValid(Long id, Long exa, Long exb) {
		
		return requestDAO.listOfRequestsToUpdate(id, exa, exb);
		
	}

	

	
	

}
