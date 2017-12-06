package org.books.exchange.dao;


import java.util.List;

import org.books.exchange.entities.ExchangeRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "requests", path = "requests")
public interface ExchangeRequestRepository 
	extends JpaRepository<ExchangeRequest,Long>{
	
	@Query("select req from ExchangeRequest req where req.exB.user.id = :userId and req.status = 0") 
	public Page<ExchangeRequest> findUserRecievedRequests(@Param("userId") Long userId, Pageable pageable);
	
	@Query("select req from ExchangeRequest req where req.exA.user.id = :userId and req.status = 0") 
	public Page<ExchangeRequest> findUserSendedRequests(@Param("userId") Long userId, Pageable pageable);
	
	// Set all requests to status after an exchange established ( all requests on these books should be disabled  )
	// status 0 : open request
	// status 1 : exchange established
	// status 2 : request non valid any more
	
	@Query("select req from ExchangeRequest req where ( req.exA.id = :exa or req.exB.id = :exb) and req.id <> :req_id") 
	public List<ExchangeRequest> listOfRequestsToUpdate(@Param("req_id") Long requestId,@Param("exa") Long exa, @Param("exb") Long exb );
}
