package org.books.exchange.dao;

import org.books.exchange.entities.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "exchange", path = "exchanges")
public interface ExchangeRepository 
	extends JpaRepository<Exchange,Long>{

}
