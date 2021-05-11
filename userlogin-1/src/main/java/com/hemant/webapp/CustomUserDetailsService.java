package com.hemant.webapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByEmail(username);
		if (user == null) {
			logger.error("User not found - " + username);
			throw new UsernameNotFoundException("User not found" + username);
		}
		return new CustomUserDetails(user);
	}

}
