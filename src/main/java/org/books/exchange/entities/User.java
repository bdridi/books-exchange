package org.books.exchange.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

	@Id 
	@GeneratedValue
	private Long   id;
	private String username;
	private String name;
	private String email;
	private String address;
	private String password;
		
	public User() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param username
	 * @param name
	 * @param email
	 * @param address
	 * @param password
	 */
	public User(String username, String name, String email, String address, String password) {
		this.username = username;
		this.name = name;
		this.email = email;
		this.address = address;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
