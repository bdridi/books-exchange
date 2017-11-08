package org.books.exchange.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class ExchangeOffer {

	@Id
	@GeneratedValue
	private Long id;
	@OneToOne
	private User user;
	@OneToOne
	private Book book;
	private String preference;
	
	
	public ExchangeOffer() {
		
		
	}


	/**
	 * @param id
	 * @param user
	 * @param book
	 * @param preference
	 */
	public ExchangeOffer(Long id, User user, Book book, String preference) {
		this.id = id;
		this.user = user;
		this.book = book;
		this.preference = preference;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Book getBook() {
		return book;
	}


	public void setBook(Book book) {
		this.book = book;
	}


	public String getPreference() {
		return preference;
	}


	public void setPreference(String preference) {
		this.preference = preference;
	}
	
	

}
