package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.model.dao.ListinoDao;
import com.app.model.entity.Listino;

@Controller
@RequestMapping(value="/")
public class ListinoController {
	
	@Autowired
	ListinoDao ld;
	
	
	// ********************* METODI GET ******************************************
	
	
	/**
	 * visualizza la jsp contenente tutti i listini presenti nel database
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/admin/visualizzaListini", method=RequestMethod.GET)
	public String visualizzaListinoAdmin(HttpServletRequest request, ModelMap model) {
		HttpSession session=request.getSession();
		session.setAttribute("listini", ld.visualizza());
		return "admin/listini";
	}
	
	@RequestMapping(value="/visualizzaListini", method=RequestMethod.GET)
	public String visualizzaListino(HttpServletRequest request, ModelMap model) {
		HttpSession session=request.getSession();
		session.setAttribute("listini", ld.visualizza());
		return "listini";
	}
	
	/**
	 * visualizza la jsp contenente la form di inserimento per i listini
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/admin/inserimentoListini", method=RequestMethod.GET)
	public String inserimentoListinoGet(HttpServletRequest request, ModelMap model) {
		model.addAttribute("listino", new Listino());
		return "admin/inserimentoListini";
	}
	
	/**
	 * visualizza la jsp contenente la form di modifica per i listini
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/admin/modificaListini", method=RequestMethod.GET)
	public String modificaListinoGet(HttpServletRequest request, ModelMap model) {
		Listino l=ld.returnListinoById(Integer.parseInt(request.getParameter("Id")));
		model.addAttribute("listino", l);
		return "admin/modificaListini";
	}
	
	/**
	 * visualizza la jsp contenente la form di cancelalzione per i listini
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/admin/eliminaListini", method=RequestMethod.GET)
	public String eliminaListinoGet(HttpServletRequest request, ModelMap model) {
		Listino l=ld.returnListinoById(Integer.parseInt(request.getParameter("Id")));
		model.addAttribute("listino",l);
		return "admin/eliminaListini";
	}
	
	
	// ********************* METODI POST ******************************************


	/**
	 * metodo post di inserimento dei listini
	 * 
	 * @param l
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/admin/inserimentoListini", method=RequestMethod.POST)
	public String inserimentoListinoPost(@Valid Listino l, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			return "admin/inserimentoListini";
		}else{
			ld.inserimento(l);
			return "redirect:/default";
		}
	}
	
	/**
	 * metodo post di modifica dei listini
	 * 
	 * @param l
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/admin/modificaListini", method=RequestMethod.POST)
	public String ModificaListinoPost(@Valid Listino l, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			return "admin/modificaListini";
		}else{
			ld.modifica(l);
			return "redirect:/default";
		}
	}
	
	/**
	 * metodo post di cancellazione dei listini
	 * 
	 * @param l
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/admin/eliminaListini", method=RequestMethod.POST)
	public String eliminaListinoPost(Listino l, ModelMap model) {
		ld.cancella(l);
		return "redirect:/default";
	}
	
}
