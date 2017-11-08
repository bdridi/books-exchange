package org.books.exchange.dao;

import org.books.exchange.entities.ExchangeRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "requests", path = "requests")
public interface ExchangeRequestRepository 
	extends JpaRepository<ExchangeRequest,Long>{

}
