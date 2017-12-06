package org.books.exchange.config;

import org.books.exchange.entities.Book;
import org.books.exchange.entities.Exchange;
import org.books.exchange.entities.ExchangeOffer;
import org.books.exchange.entities.ExchangeRequest;
import org.books.exchange.entities.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class RepositoriesConfig extends RepositoryRestConfigurerAdapter {
    
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        
		config.exposeIdsFor(Book.class);
        config.exposeIdsFor(Exchange.class);
        config.exposeIdsFor(ExchangeOffer.class);
        config.exposeIdsFor(ExchangeRequest.class);
        config.exposeIdsFor(User.class);
        
    }
}