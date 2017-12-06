package org.books.exchange.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Exchange {

	@Id @GeneratedValue
	private Long id;
	@OneToOne
	private ExchangeRequest request;
	
	// status  :  Match , Sent, Recieved 
	private String statusA;
	private String statusB;
	
	public Exchange() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ExchangeRequest getRequest() {
		return request;
	}

	public void setRequest(ExchangeRequest request) {
		this.request = request;
	}

	public String getStatusA() {
		return statusA;
	}

	public void setStatusA(String statusA) {
		this.statusA = statusA;
	}

	public String getStatusB() {
		return statusB;
	}

	public void setStatusB(String statusB) {
		this.statusB = statusB;
	}

	/**
	 * @param request
	 * @param statusA
	 * @param statusB
	 */
	public Exchange(ExchangeRequest request, String statusA, String statusB) {
		this.request = request;
		this.statusA = statusA;
		this.statusB = statusB;
	}
	
	/**
	 * @param request
	 * @param statusA
	 * @param statusB
	 */
	public Exchange(ExchangeRequest request) {
		this.request = request;
		this.statusA = "Match";
		this.statusB = "Match";
	}
	
	

}
