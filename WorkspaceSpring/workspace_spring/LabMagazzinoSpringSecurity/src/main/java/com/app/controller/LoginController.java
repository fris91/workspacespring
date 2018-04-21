package com.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.dao.UtenteDao;
import com.app.model.entity.Utente;

@Controller
public class LoginController {

	@Autowired
	private UtenteDao utentedao;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@RequestMapping(value = "/")
	public ModelAndView goToHome(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Utente utente = utentedao.returnUtenteByEmail(auth.getName());
		modelAndView.addObject("utente",utente);
		if (auth.getAuthorities().contains(new SimpleGrantedAuthority("GOD"))) {
			modelAndView.setViewName("god/index");
		} else if (auth.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN"))) {
			modelAndView.setViewName("admin/index");
		} else {
			modelAndView.setViewName("indexUser");
		}
		return modelAndView;
	}
	
}
