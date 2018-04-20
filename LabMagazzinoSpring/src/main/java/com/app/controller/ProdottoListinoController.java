package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.model.dao.ListinoDao;
import com.app.model.dao.ProdottoDao;
import com.app.model.dao.ProdottoListinoDao;
import com.app.model.dao.ScontoDao;
import com.app.model.entity.Prodotto;
import com.app.model.entity.ProdottoListino;
import com.app.model.entity.ProdottoListino.Id;

@Controller
@RequestMapping(value="/")
public class ProdottoListinoController {
	
	@Autowired
	ProdottoDao pd;
	
	@Autowired
	ListinoDao ld;
	
	@Autowired
	ProdottoListinoDao pld;
	
	@Autowired
	ScontoDao sd;
	
	
	// ********************* AGGIUNGI IL PRODOTTO AL LISTINO ******************************************
	
	
	/**
	 * visualizza la form per l'inserimento del prodotto selezionato ad uno dei listini esistenti
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/aggiungiListini", method=RequestMethod.GET)
	public String aggiungiListinoGet(HttpServletRequest request, ModelMap model) {
		Prodotto p = pd.returnProdottoById(Integer.parseInt(request.getParameter("Id")));
		request.getSession().setAttribute("prodotto", p);
		model.addAttribute("listini", ld.visualizza());
		model.addAttribute("sconti", sd.visualizza());
		model.addAttribute("prodottolistino", new ProdottoListino());
		return "aggiungiListini";
	}
	
	/**
	 * metodo per l'inserimento del prodotto selezionato ad uno dei listini esistenti,
	 * 
	 * con la possibilità di aggiungere uno sconto ed un prezzo
	 * 
	 * @param pl
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/aggiungiListini", method=RequestMethod.POST)
	public String aggiungiListinoPost(@ModelAttribute("prodottolistino") @Valid ProdottoListino pl, BindingResult result, ModelMap model) {
		/*
		 * crea una reject in caso di mancato inserimento del prezzo,
		 * 
		 * cioè nel caso si imposti il prezzo uguale a zero
		 */
		if(pl.getPrezzo()==0.0) {
			result.rejectValue("prezzo", "error.prezzo", "*Inserire un prezzo");
		}
		/*
		 * crea una reject in caso di mancato inserimento dello sconto
		 * 
		 * per l'inserimento di uno sconto pari a zero ho inserito nel database una voce "Nessuno sconto", contenente come valore di sconto
		 * zero, così da bypassare il problema della foreign key
		 * 
		 */
		if(pl.getSconto().getId()==-1) {
			result.rejectValue("sconto", "error.sconto", "*Inserire uno sconto");
		}
		/*
		 * crea una reject in caso di mancato inserimento del listino
		 */
		if(pl.getId().getId_listino()==-1) {
			result.rejectValue("listino", "error.listino", "*Inserire un listino");
		}
		/*
		 * in caso ci siano errori reinvio la stessa pagina con le reject
		 */
		if(result.hasErrors()) {
			model.addAttribute("prodottolistino", pl);
			model.addAttribute("listini", ld.visualizza());
			model.addAttribute("sconti", sd.visualizza());
			return "aggiungiListini";
		}else{
			pld.inserimento(pl);
			return "index";
		}
	}
	
	
	/* ********************* VISUALIZZAZIONE DEL SINGOLO LISTINO CON LA POSSIBILITA'****************************************** 
	   ********************* DI RIMUOVERE UN ARTICOLO AL SUO INTERNO				*******************************************/
	
	
	/**
	 * visualizza la jsp contenente tutti i prodotti associati al listino selezionato
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/visualizzaSingoloListino", method=RequestMethod.GET)
	public String visualizzaSingoloListino(HttpServletRequest request, ModelMap model) {
		request.setAttribute("prodottiListino", ld.returnListinoById(Integer.parseInt(request.getParameter("Id"))).getProdotto());
		model.addAttribute("id", new Id());
		return "singoloListino";
	}
	
	/**
	 * metodo che rimuove il prodotto selezionato dal listino visualizzato
	 * 
	 * @param id
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/eliminaSingoloProdotto", method=RequestMethod.POST)
	public String eliminaSingoloProdotto(Id id, HttpServletRequest request, ModelMap model) {
		pld.cancella(pld.returnProdottoListinoById(id));
		return "listini";
	}
	
}
