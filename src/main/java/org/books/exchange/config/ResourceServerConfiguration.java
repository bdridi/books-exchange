package org.books.exchange.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
	

	@Override
	public void configure(HttpSecurity http) throws Exception {
			
	  
		  http.authorizeRequests().antMatchers("/api/books").permitAll();	
		  http.authorizeRequests().antMatchers("/api/plainOffers").permitAll();	
		  http.authorizeRequests().antMatchers("/api/offers").permitAll();	
		  http.authorizeRequests().antMatchers("/api/public/*").permitAll();	
		  //http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
	}

	
	
}