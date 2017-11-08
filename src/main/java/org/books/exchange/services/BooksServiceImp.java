package org.books.exchange.services;

import java.util.List;

import org.books.exchange.dao.BookRepository;
import org.books.exchange.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BooksServiceImp implements BooksService{
	
	@Autowired
	private BookRepository bookDAO;
	public BooksServiceImp(){
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Book> getAll() {
		// TODO Auto-generated method stub
		return bookDAO.findAll();
	}



}
