package org.books.exchange.services;

import java.util.List;
import org.books.exchange.entities.Book;
import org.springframework.data.domain.Page;;

public interface BooksService {
	
	
	public List<Book> findBooksByName(String name);
	
	public Book findBookById(Long id);
	
	public Page<Book> getAll(int page);

}
