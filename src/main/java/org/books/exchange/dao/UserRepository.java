package org.books.exchange.dao;

import org.books.exchange.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "user", path = "users")
public interface UserRepository 
	extends JpaRepository<User,Long>{
	
	public User findOneByUsername(String username);

}
