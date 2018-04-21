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
import com.app.model.dao.CategoriaDao;
import com.app.model.entity.Categoria;

@Controller
@RequestMapping(value="/")
public class CategoriaController {

	@Autowired
	CategoriaDao cd;

	
	// ********************* METODI GET ******************************************
	
	
	/**
	 * visualizza la jsp contenente tutte le categorie presenti nel database
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/visualizzaCategorie", method=RequestMethod.GET)
	public String visualizzaCategoria(HttpServletRequest request, ModelMap model) {
		HttpSession session=request.getSession();
		session.setAttribute("categorie", cd.visualizza());
		return "categorie";
	}
	
	@RequestMapping(value="/admin/visualizzaCategorie", method=RequestMethod.GET)
	public String visualizzaCategorieAdmin(HttpServletRequest request, ModelMap model) {
		HttpSession session=request.getSession();
		session.setAttribute("categorie", cd.visualizza());
		return "admin/categorie";
	}

	/**
	 * visualizza la jsp contenente la form di inserimento per le categorie
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/admin/inserimentoCategorie", method=RequestMethod.GET)
	public String inserimentoCategoriaGet(HttpServletRequest request, ModelMap model) {
		model.addAttribute("categoria", new Categoria());
		return "admin/inserimentoCategorie";
	}

	/**
	 * visualizza la jsp contenente la form di modifica per le categorie
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/admin/modificaCategorie", method=RequestMethod.GET)
	public String modificaCategoriaGet(HttpServletRequest request, ModelMap model) {
		model.addAttribute("categoria", cd.returnCategoriaById(Integer.parseInt(request.getParameter("id"))));
		return "admin/modificaCategorie";
	}

	/**
	 * visualizza la jsp contenente la form di cancellazione per le categorie
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/admin/eliminaCategorie", method=RequestMethod.GET)
	public String eliminaCategoriaGet(HttpServletRequest request, ModelMap model) {
		model.addAttribute("categoria", cd.returnCategoriaById(Integer.parseInt(request.getParameter("id"))));
		return "admin/eliminaCategorie";
	}

	
	// ********************* METODI POST ******************************************
	
	
	/**
	 * metodo post di inserimento delle categorie
	 * 
	 * @param c
	 * @param result
	 * @return
	 */
	@RequestMapping(value="/admin/inserimentoCategorie", method=RequestMethod.POST)
	public String inserimentoCategoriaPost(@Valid Categoria c, BindingResult result) {
		if(result.hasErrors()) {
			return "admin/inserimentoCategorie";
		}
		else {
			cd.inserimento(c);
			return "redirect:/default";
		}
	}

	/**
	 * metodo post di modifica delle categorie
	 * 
	 * @param c
	 * @param result
	 * @return
	 */
	@RequestMapping(value="/admin/modificaCategorie", method=RequestMethod.POST)
	public String modificaCategoriaPost(@Valid Categoria c, BindingResult result) {
		if(result.hasErrors()) {
			return "admin/modificaCategorie";
		}
		else {
			cd.modifica(c);
			return "redirect:/default";
		}
	}

	/**
	 * metodo post di cancellazione delle categorie
	 * 
	 * @param c
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/admin/eliminaCategorie", method=RequestMethod.POST)
	public String eliminaCategoriaPost(Categoria c, ModelMap model) {
		cd.cancella(c);
		return "redirect:/default";
	}

}