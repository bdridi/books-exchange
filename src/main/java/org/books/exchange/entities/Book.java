package org.books.exchange.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Book implements Serializable{
	@Id
	@GeneratedValue
	public Long id;
	@NotEmpty
	private String author;
	@NotEmpty
	private String title; 
	private int pages;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date publishDate;
	private String ISBN;
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
	 * @param iSBN
	 * @param publisher
	 */
	public Book(String author, String title, int pages, Date publishDate, String iSBN, String publisher) {
		this.author = author;
		this.title = title;
		this.pages = pages;
		this.publishDate = publishDate;
		ISBN = iSBN;
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
	 * @return the iSBN
	 */
	public String getISBN() {
		return ISBN;
	}



	/**
	 * @param iSBN the iSBN to set
	 */
	public void setISBN(String iSBN) {
		ISBN = iSBN;
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