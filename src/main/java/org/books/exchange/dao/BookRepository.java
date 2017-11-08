package org.books.exchange.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.books.exchange.entities.Book;
import java.util.*;

@RepositoryRestResource(collectionResourceRel = "books", path = "books")
public interface BookRepository 
	extends JpaRepository<Book,Long>{
	
}
