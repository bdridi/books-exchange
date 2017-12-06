package org.books.exchange.services;

import java.util.List;

import org.books.exchange.entities.ExchangeRequest;
import org.springframework.data.domain.Page;

public interface RequestService {
	
	public Page<ExchangeRequest> authenticatedUserRecievedRequests(int page);
	
	public Page<ExchangeRequest> authenticatedUserSendedRequests(int page);
	
	public ExchangeRequest save(ExchangeRequest exRequest);
	
	public ExchangeRequest getOne(Long id); 
	
	public List<ExchangeRequest> getOthersToBeNonValid(Long id, Long exa, Long exb );
	

}
