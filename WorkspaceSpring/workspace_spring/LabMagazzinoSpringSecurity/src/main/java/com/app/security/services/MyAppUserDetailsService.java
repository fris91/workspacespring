package com.app.security.services;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.app.model.dao.UtenteDao;
import com.app.model.entity.Utente;

@Service
public class MyAppUserDetailsService implements UserDetailsService {
	@Autowired
	private UtenteDao utenteDao;
	private static final Logger logger = LoggerFactory.getLogger(MyAppUserDetailsService.class);	

	@Override
	public UserDetails loadUserByUsername(String email) {

		UserDetails userDetails = null;
		try {
			Utente utente = utenteDao.returnUtenteByEmail(email);
			GrantedAuthority authority = new SimpleGrantedAuthority(utente.getRuolo().getRuolo());
			userDetails = (UserDetails) new User(utente.getEmail(), utente.getPassword(), Arrays.asList(authority));
		} catch (Exception e) {
			logger.warn("Utente non trovato");
		}
		return userDetails;
	}
} 