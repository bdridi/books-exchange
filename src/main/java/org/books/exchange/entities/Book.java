package org.books.exchange.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "book")
public class Book implements Serializable{
	@Id
	@GeneratedValue
	public Long id;
	@NotEmpty
	private String author;
	@NotEmpty
	private String title; 
	private int pages;
	 @Temporal(TemporalType.DATE)
	private Date publishDate;
	private String description;
	private String publisher;
	
	
	
	/**
	 * Default constructor
	 */
	public Book() {
		super();
	}
	

	/**
	 * @param author
	 * @param title
	 * @param pages
	 * @param publishDate
	 * @param description
	 * @param publisher
	 */
	public Book(String author, String title, int pages, Date publishDate, String description, String publisher) {
		this.author = author;
		this.title = title;
		this.pages = pages;
		this.publishDate = publishDate;
		description = description;
		this.publisher = publisher;
	}


	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}



	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}



	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}



	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}



	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}



	/**
	 * @return the pages
	 */
	public int getPages() {
		return pages;
	}



	/**
	 * @param pages the pages to set
	 */
	public void setPages(int pages) {
		this.pages = pages;
	}



	/**
	 * @return the publishDate
	 */
	public Date getPublishDate() {
		return publishDate;
	}



	/**
	 * @param publishDate the publishDate to set
	 */
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}


	/**
	 * @return the description
	 */
	public String getdescription() {
		return description;
	}



	/**
	 * @param description the description to set
	 */
	public void setdescription(String description) {
		this.description = description;
	}



	/**
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}



	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	

}