package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.model.dao.UtenteDao;

@Controller
@RequestMapping(value="/")
public class UtenteController {

	@Autowired
	UtenteDao utenteDao;

	/**
	 * visualizza la jsp contenente tutti i prodotti presenti nel database
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/god/visualizzaUtenti", method=RequestMethod.GET)
	public String visualizzaProdottiAdmin(HttpServletRequest request, ModelMap model) {
		HttpSession session=request.getSession();
		session.setAttribute("utenti", utenteDao.visualizza());
		return "god/utenti";
	}

}