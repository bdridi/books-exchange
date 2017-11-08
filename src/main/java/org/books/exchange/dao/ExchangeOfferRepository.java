package org.books.exchange.dao;

import org.books.exchange.entities.ExchangeOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "offers", path = "offers")
public interface ExchangeOfferRepository 
	extends JpaRepository<ExchangeOffer,Long>{

}
