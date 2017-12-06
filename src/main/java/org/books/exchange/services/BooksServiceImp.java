package org.books.exchange.services;

import java.util.List;

import org.books.exchange.dao.BookRepository;
import org.books.exchange.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class BooksServiceImp implements BooksService{
	
	
	private static final int ELEMENTS_PER_PAGE = 10;
	@Autowired
	private BookRepository bookDAO;
	
	public BooksServiceImp(){
	}

	@Override
	public Page<Book> getAll(int page) {
		return bookDAO.findAll(new PageRequest(page, ELEMENTS_PER_PAGE));
	}

	@Override
	public List<Book> findBooksByName(String name) {
		return bookDAO.findBooksByName(name);
	}

	@Override
	public Book findBookById(Long id) {
		return bookDAO.findOne(id);
	}



}
