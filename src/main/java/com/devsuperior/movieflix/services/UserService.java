package com.devsuperior.movieflix.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.devsuperior.movieflix.dto.UserDTO;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repository.UserRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;

@Service
public class UserService implements UserDetailsService{

	
	@Autowired
	private UserRepository repository;

	@Autowired
	private AuthService  authService;
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Transactional
	public UserDTO findById(Long id) {
		authService.validateSelfOrAdmin(id);	
		Optional<User> optional = repository.findById(id);
		User entity = optional.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new UserDTO(entity);
	}
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User  user = repository.findByEmail(username);
		if(user == null) {
			logger.error("User not found: " + username);
			throw new UsernameNotFoundException("Email not found");
		}
		logger.info("User found: " + username);
		return user;
	}
	
	
	public UserDTO profileUserLogged() {
		User entity = authService.authenticated();
		
		return new UserDTO(entity);
	}
}
