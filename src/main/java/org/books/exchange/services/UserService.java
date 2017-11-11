package org.books.exchange.services;

import org.books.exchange.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service("userDetailsService")
public class UserService implements UserDetailsService{
	
	@Autowired
	UserRepository userDAO;
	
	public UserService() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Userdetails");
		return userDAO.findOneByUsername(username);
	}

}
