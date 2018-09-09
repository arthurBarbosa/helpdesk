package com.arthurbarbosa.helpdesk.api.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.arthurbarbosa.helpdesk.api.entity.User;
import com.arthurbarbosa.helpdesk.api.security.jwt.JwtUserFactory;
import com.arthurbarbosa.helpdesk.api.service.UserService;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {
	/**
	 * Inject UserService.
	 */
	@Autowired
	private UserService userService;

	/**
	 * method that loads a user
	 */
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		User user = userService.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException(String.format("No user found with username '%s'.", email));
		} else {
			return JwtUserFactory.create(user);
		}
	}
}
