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
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.dao.CategoriaDao;
import com.app.model.dao.ProdottoDao;
import com.app.model.entity.Prodotto;

@Controller
@RequestMapping(value="/")
public class ProdottoController {

	@Autowired
	ProdottoDao pd;

	@Autowired
	CategoriaDao cd;
	
	/*
	 * vettore contente i valori della combobox di visualizzaizone del numero di pagine
	 */
	int[] combo={1,2,3,4,5};
	
	
	// ********************* METODI GET ******************************************
	
	
	/**
	 * visualizza la jsp contenente tutti i prodotti presenti nel database
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/visualizzaProdotti", method=RequestMethod.GET)
	public String visualizzaProdotto(HttpServletRequest request, ModelMap model) {
		HttpSession session=request.getSession();
		session.setAttribute("prodotti", pd.primaPagina());
		session.setAttribute("combo", combo); //utilizza il vettore prima istanziato
		return "prodotti";
	}
	
	@RequestMapping(value="/admin/visualizzaProdotti", method=RequestMethod.GET)
	public String visualizzaProdottiAdmin(HttpServletRequest request, ModelMap model) {
		HttpSession session=request.getSession();
		session.setAttribute("prodotti", pd.primaPagina());
		session.setAttribute("combo", combo); //utilizza il vettore prima istanziato
		return "admin/prodotti";
	}

	/**
	 * visualizza la jsp contenente la form di inserimento per i prodotti
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/admin/inserimentoProdotti", method=RequestMethod.GET)
	public String inserimentoProdottoGet(HttpServletRequest request, ModelMap model) {
		model.addAttribute("categoria", cd.visualizza());
		model.addAttribute("prodotto", new Prodotto());
		return "admin/inserimentoProdotti";
	}

	/**
	 * visualizza la jsp contenente la form di modifica per i prodotti
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/admin/modificaProdotti", method=RequestMethod.GET)
	public String ModificaProdottoGet(HttpServletRequest request, ModelMap model) {
		Prodotto p=pd.returnProdottoById(Integer.parseInt(request.getParameter("id")));
		model.addAttribute("categoria", cd.visualizza());
		model.addAttribute("prodotto", p);
		return "admin/modificaProdotti";
	}

	/**
	 * visualizza la jsp contenente la form di cancelalzione per i prodotti
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/admin/eliminaProdotti", method=RequestMethod.GET)
	public String eliminaProdottoGet(HttpServletRequest request, ModelMap model) {
		Prodotto p=pd.returnProdottoById(Integer.parseInt(request.getParameter("id")));
		model.addAttribute("categoria", cd.visualizza());
		model.addAttribute("prodotto", p);
		return "admin/eliminaProdotti";
	}

	
	// ********************* METODI POST ******************************************
	
	
	/**
	 * metodo post di inserimento dei prodotti
	 * 
	 * @param p
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/admin/inserimentoProdotti", method=RequestMethod.POST)
	public String inserimentoProdottoPost(@Valid Prodotto p, BindingResult result, ModelMap model) {
		/*
		 * crea una reject in caso di mancato inserimento della categoria
		 */
		if(p.getCategoria().getId()==-1) {
			model.addAttribute("categoria", cd.visualizza());
			result.rejectValue("categoria", "error.categoria", "*Inserire la categoria");
			return "admin/inserimentoProdotti";
		/*
		 * in caso ci siano errori reinvio la stessa pagina con le reject
		 */
		}else if(result.hasErrors()) {
			model.addAttribute("categoria", cd.visualizza());
			return "admin/inserimentoProdotti";
		}else{
			pd.inserimento(p);
			return "redirect:/default";
		}
	}

	/**
	 * metodo post di modifica dei prodotti
	 * 
	 * @param p
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/admin/modificaProdotti", method=RequestMethod.POST)
	public String ModificaProdottoPost(@Valid Prodotto p, BindingResult result, ModelMap model) {
		if(p.getCategoria().getId()==-1) {
			model.addAttribute("categoria", cd.visualizza());
			result.rejectValue("categoria", "error.categoria", "*Inserire la categoria");
			return "admin/modificaProdotti";
		}else if(result.hasErrors()) {
			model.addAttribute("categoria", cd.visualizza());
			return "admin/modificaProdotti";
		}else{
			pd.modifica(p);
			return "redirect:/default";
		}
	}

	/**
	 * metodo post di cancellazione dei prodotti
	 * 
	 * @param p
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/admin/eliminaProdotti", method=RequestMethod.POST)
	public String eliminaProdottoPost(Prodotto p, ModelMap model) {
		pd.cancella(p);
		return "redirect:/default";
	}

	/**
	 * metodo contenete la navigazione per pagine
	 * 
	 * @param btn
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/navigazione", method=RequestMethod.POST, params="btn")
	public String visualizzaProdottoNavigazione(@RequestParam String btn, HttpServletRequest request) {
		/*
		 * visualizza il numero di righe contenute all'interno della combobox
		 */
		if(btn.equals("change")) {
			pd.setLunghezzaPagina(Integer.parseInt(request.getParameter("vis")));
			request.getSession().setAttribute("prodotti", pd.primaPagina());
			request.getSession().setAttribute("selCombo", pd.getLunghezzaPagina());
			return "/prodotti";
		/*
		 * visualizza la prima pagina
		 */
		} else if(btn.equals("prima")) {
			request.getSession().setAttribute("prodotti", pd.primaPagina());
			return "/prodotti";
		/*
		 * visualizza la pagina successiva, se presente
		 */
		} else if(btn.equals("succ")) {
			request.getSession().setAttribute("prodotti", pd.paginaSuccessiva());
			return "/prodotti";
		/*
		 * visualizza la pagina precedente, se presente
		 */
		} else if(btn.equals("prec")) {
			request.getSession().setAttribute("prodotti", pd.paginaPrecedente());
			return "/prodotti";
		/*
		 * visualizza l'ultima pagina
		 */
		} else if(btn.equals("ultima")) {
			request.getSession().setAttribute("prodotti", pd.ultimaPagina());
			return "/prodotti";
		} else {
			return "/indexUser";
		}
	}
	
	@RequestMapping(value="/admin/navigazione", method=RequestMethod.POST, params="btn")
	public String visualizzaProdottoNavigazioneAdmin(@RequestParam String btn, HttpServletRequest request) {
		/*
		 * visualizza il numero di righe contenute all'interno della combobox
		 */
		if(btn.equals("change")) {
			pd.setLunghezzaPagina(Integer.parseInt(request.getParameter("vis")));
			request.getSession().setAttribute("prodotti", pd.primaPagina());
			request.getSession().setAttribute("selCombo", pd.getLunghezzaPagina());
			return "/admin/prodotti";
		/*
		 * visualizza la prima pagina
		 */
		} else if(btn.equals("prima")) {
			request.getSession().setAttribute("prodotti", pd.primaPagina());
			return "/admin/prodotti";
		/*
		 * visualizza la pagina successiva, se presente
		 */
		} else if(btn.equals("succ")) {
			request.getSession().setAttribute("prodotti", pd.paginaSuccessiva());
			return "/admin/prodotti";
		/*
		 * visualizza la pagina precedente, se presente
		 */
		} else if(btn.equals("prec")) {
			request.getSession().setAttribute("prodotti", pd.paginaPrecedente());
			return "/admin/prodotti";
		/*
		 * visualizza l'ultima pagina
		 */
		} else if(btn.equals("ultima")) {
			request.getSession().setAttribute("prodotti", pd.ultimaPagina());
			return "admin/prodotti";
		} else {
			return "redirect:/default";
		}
	}
}
