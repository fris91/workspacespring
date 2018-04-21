package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.dao.RuoloDao;
import com.app.model.dao.UtenteDao;
import com.app.model.entity.Utente;

@Controller
public class RegistrationController {
	
	@Autowired
	private UtenteDao utentedao;
	@Autowired
	private RuoloDao ruoloDao;
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView registration() {
		ModelAndView modelAndView = new ModelAndView();
		Utente utente = new Utente();
		modelAndView.addObject("utente", utente);
		modelAndView.setViewName("registrazione");
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid Utente utente, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		Utente utenteEsiste = utentedao.returnUtenteByEmail(utente.getEmail());
		if (utenteEsiste != null) {
			bindingResult.rejectValue("email", "error.utente",
					"Email già utilizzata");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registrazione");
		} else {
			utente.setRuolo(ruoloDao.returnRuoloByName("USER"));
			utentedao.inserimento(utente);
			modelAndView.addObject("successMessage", "Utente salvato con successo");
			modelAndView.addObject("utente", new Utente());
			modelAndView.setViewName("registrazione");
		}
		return modelAndView;
	}
}
