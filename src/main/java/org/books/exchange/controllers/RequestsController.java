package org.books.exchange.controllers;

import java.util.List;

import javax.servlet.ServletRequest;

import org.books.exchange.entities.Exchange;
import org.books.exchange.entities.ExchangeOffer;
import org.books.exchange.entities.ExchangeRequest;
import org.books.exchange.services.ExchangeService;
import org.books.exchange.services.OffersService;
import org.books.exchange.services.RequestService;
import org.books.exchange.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestsController {
	
	
	@Autowired
	RequestService requestService;
	@Autowired
	OffersService offerService;
	@Autowired
	UserService userService;
	@Autowired
	ExchangeService exchangeService;
	private static final Logger LOGGER = LoggerFactory.getLogger(RequestsController.class);
	
	
	public RequestsController() {
			
		
	}
		
	@RequestMapping(value="/recievedRequests") 
	public Page<ExchangeRequest> recievedRequests(@RequestParam(value="page", defaultValue="0") int page){
		
		return requestService.authenticatedUserRecievedRequests(page);
	}

	@RequestMapping(value="/sendedRequests") 
	public Page<ExchangeRequest> sendedRequests(@RequestParam(value="page", defaultValue="0") int page){
		
		return requestService.authenticatedUserSendedRequests(page);
	}
	
	/* - Send an exchange request 
	 * - Request a specefic book
	 * - Offer one of user's books
	 * 	 @Post Param : exA : book to give
	 *   @Post Param : exB : requested book
	 *   @Post Param: message
	 */
	
	
	@RequestMapping(value="requestABook", method = RequestMethod.POST)
	 public ResponseEntity<?> requestABook(ServletRequest request)  {
		
		
		String message = request.getParameter("message");
		if(message == null) {
			return ResponseEntity.badRequest().body("{error : 'Parameter message is missing'}");
		}
		
		
		if(request.getParameter("exA") == null) {
			return ResponseEntity.badRequest().body("{'error' : 'Parameter exA is missing'}");
		}
		
		if(request.getParameter("exB") == null) {
			return ResponseEntity.badRequest().body("{'error' : 'Parameter exB is missing'}");
		}
		
		ExchangeOffer offerA = offerService.getOffer(Long.parseLong(request.getParameter("exA")));
		ExchangeOffer offerB = offerService.getOffer(Long.parseLong(request.getParameter("exB")));
			
		// check if exA and exB are valid
		
		if(offerA == null || offerB == null) {
			return ResponseEntity.badRequest().body("{error : 'Invalid offer  !' }");
		}
		// check if the user is the owner of the book ( exA )
		if( offerA.getUser().getId() != userService.getAuthenticatedUserId()) {
			return ResponseEntity.badRequest().body("{error : ' Exchange offer not permitted  !' }");
		}
		
		// save the request
		return ResponseEntity.ok(requestService.save(new ExchangeRequest(offerA,offerB,message)));
		
	}
	
	@RequestMapping(value="/acceptRequest", method=RequestMethod.GET)
	public ResponseEntity<?> acceptRequest(@RequestParam(value="request_id", required=false) Long requestId, ServletRequest request){
		
		
		if( requestId == null ) {
			
			LOGGER.info(" Getting parameter from Servletrequest ");
			if(request.getParameter("request_id") != null ){
				requestId = Long.parseLong(request.getParameter("request_id"));
				LOGGER.info(" Parsing request_id parameter  : "+ requestId);

				
			}
		}
		ExchangeRequest exRequest = requestService.getOne(requestId);
		// Check if the exchange request belong to the authenticated user
		if(request != null) {
			if(exRequest.getexB().getUser().getId() != userService.getAuthenticatedUserId()) {
				return ResponseEntity.badRequest().body("{error : ' This request does not addressed for you !' }");
			}
			
			// Create a new exchange 
			Exchange exchange = exchangeService.save(new Exchange(exRequest));
			// update offers status 
			ExchangeOffer exA = exRequest.getexA();
			exA.setStatus(false);
			ExchangeOffer exB = exRequest.getexB();
			exB.setStatus(false);
			offerService.save(exA);
			offerService.save(exB);
			// update request Status 
			exRequest.setStatus(1);
			List<ExchangeRequest> nonValidRequests = requestService.getOthersToBeNonValid(exRequest.getId(), exA.getId(), exB.getId());
			nonValidRequests.forEach(item -> {
				item.setStatus(2);
				requestService.save(item);
			}
			);
			requestService.save(exRequest);
			return ResponseEntity.ok(exchange);
		} else {
			return ResponseEntity.badRequest().body("{error : ' Invalid request !' }");
		}
		
		
			

	}
	
	

}
