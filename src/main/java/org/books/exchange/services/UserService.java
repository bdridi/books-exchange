package org.books.exchange.services;

import org.books.exchange.dao.UserRepository;
import org.books.exchange.entities.User;
import org.books.exchange.security.SimpleCORSFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service("userDetailsService")
public class UserService implements UserDetailsService{
	
	@Autowired
	UserRepository userDAO;
	private static final  Logger LOGGER = LoggerFactory.getLogger(SimpleCORSFilter.class);
	
	public UserService() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		LOGGER.info("loading UserByUsername ");
		return userDAO.findOneByUsername(username);
	}	
	
	// Return the authenticated user 
	public User getAuthenticatedUser() {
		
		User user = null;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			user = (User) auth.getPrincipal();
		}
		LOGGER.info("authenticated user : "+user.getUsername());
		return user;
	}
	
public Long getAuthenticatedUserId() {
		
		User user = null;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			user = (User) auth.getPrincipal();
		}
		LOGGER.info("authenticated user : "+user.getUsername());
		return user.getId();
	}
	
	

}
