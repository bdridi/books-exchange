package org.books.exchange.dao;

import org.books.exchange.entities.ExchangeOffer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "offers", path = "offers")
public interface ExchangeOfferRepository 
	extends JpaRepository<ExchangeOffer,Long>{
	
	@Query("select offer from ExchangeOffer offer where offer.user.id = :userId and offer.isShowed =  true"  ) 
	public Page<ExchangeOffer> findUserOffers(@Param("userId") Long userId, Pageable pageable);
	
	@Query("select offer from ExchangeOffer offer where offer.isShowed = true" ) 
	public Page<ExchangeOffer> findPlainOffers(Pageable pageable);
	
}
