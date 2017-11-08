package org.books.exchange.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class ExchangeRequest {

	@Id @GeneratedValue
	private Long id;
	@OneToOne
	private ExchangeOffer exA; // seeker
	@OneToOne
	private ExchangeOffer exB; // desired
	private String message;
	private int status; 
	
	public ExchangeRequest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param exA
	 * @param exB
	 * @param message
	 */
	public ExchangeRequest(ExchangeOffer exA, ExchangeOffer exB, String message, int status) {
		
		this.exA = exA;
		this.exB = exB;
		this.message = message;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ExchangeOffer getexA() {
		return exA;
	}

	public void setexA(ExchangeOffer exA) {
		this.exA = exA;
	}

	public ExchangeOffer getexB() {
		return exB;
	}

	public void setexB(ExchangeOffer exB) {
		this.exB = exB;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	

}
