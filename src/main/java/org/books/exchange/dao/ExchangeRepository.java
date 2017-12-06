package org.books.exchange.dao;


import org.books.exchange.entities.Exchange;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "exchange", path = "exchanges")
public interface ExchangeRepository 
	extends JpaRepository<Exchange,Long>{
	
	@Query("select ex from Exchange ex where ex.request.exA.user.id = :userId OR ex.request.exB.user.id = :userId" ) 
	public Page<Exchange> findUserExchanges(@Param("userId") Long userId, Pageable pageable);

}
