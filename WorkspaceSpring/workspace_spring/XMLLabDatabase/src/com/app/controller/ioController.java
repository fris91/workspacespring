package com.app.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.model.entity.Categoria;
import com.app.model.entity.Categorie;
import com.app.model.entity.Prodotto;
import com.app.services.InOutXML;

/**
 * Servlet implementation class ioController
 */
@WebServlet("/ioController")
public class ioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ProdottiCRUD prodottiCRUD;
	CategorieCRUD categorieCRUD;
	HttpSession session;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ioController() {
		super();
		prodottiCRUD = new ProdottiCRUD();
		categorieCRUD = new CategorieCRUD();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		stampaOggettiXML(new File("C:/workspace_spring/FileXML/Categorie.xml"), new File("C:/workspace_spring/FileXML/Prodotti.xml"));
		session = request.getSession();			
		session.setAttribute("prodotti", prodottiCRUD.read().getProdotti());
		goToPage("visualizzaProdotti.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();		
		switch (request.getParameter("btnVisualizzaProdotti")) {
		case "aggiungi":			
			session.setAttribute("cat", categorieCRUD.read().getListaCategorie());
			goToPage("inserisciProdotto.jsp", request, response);
			break;
		case "elimina": 		
			String[] idValuesToRemove = request.getParameterValues("prodotti");
			prodottiCRUD.deleteMany(idValuesToRemove);
			session.setAttribute("prodotti", prodottiCRUD.read().getProdotti());
			goToPage("visualizzaProdotti.jsp", request, response);
			break;
		case "creaProdotto":
			prodottiCRUD.create(nuovoProdotto(request));
			session.setAttribute("prodotti", prodottiCRUD.read().getProdotti());
			goToPage("visualizzaProdotti.jsp", request, response);
			break;
		default:
			break;
		}
	}

	/**
	 * Indirizza la richiesta alla pagina indicata come stringa.
	 * 
	 * @param pagina Stringa contenente il nome della pagina da visualizzare
	 * @param request 
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void goToPage(String pagina, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(pagina);
		rd.forward(request, response);
	}

	public Prodotto nuovoProdotto(HttpServletRequest request) {
		Prodotto prodotto = null;
		String nome = request.getParameter("nome");
		String descrizione = request.getParameter("desc");
		int idCategoria = Integer.parseInt(request.getParameter("categoria"));
		if ( (nome != null) && (descrizione != null) && (idCategoria != -1) ) {
			for (Categoria categoria : categorieCRUD.read().getListaCategorie()) {
				if (categoria.getId() == idCategoria) {
					prodotto = new Prodotto(nome, descrizione, categoria);
					break;
				}
			}
		}
		
		return prodotto;
	}

	/*
	 * Metodo di prova per l'applicazione. 
	 * Crea un oggetto Categorie, un oggetto Prodotti e, utilizzando un metodo di servizio 
	 * ne crea una descrizione su un file XML. 
	 */
	public void stampaOggettiXML(File fileCategorie, File fileProdotti) {
		InOutXML<Categorie> xmlCategorie = new InOutXML<Categorie>();
		ArrayList<Categoria> listaCategorie = new ArrayList<Categoria>();

		listaCategorie = new ArrayList<Categoria>();
		Categoria c1 = new Categoria(1, "aaa");
		listaCategorie.add(c1);
		Categoria c2 = new Categoria(2, "bbb");
		listaCategorie.add(c2);
		Categoria c3 = new Categoria(3, "ccc");
		listaCategorie.add(c3);
		Categorie categorie = new Categorie();

		categorie.setListaCategorie(listaCategorie);
		xmlCategorie.writeXML(fileCategorie, categorie);

		Prodotto p1 = new Prodotto("pallone", "rotondo", c1);
		prodottiCRUD.create(p1);
		Prodotto p2 = new Prodotto("computer", "scassato", c2);
		prodottiCRUD.create(p2);
		Prodotto p3 = new Prodotto("iPhone", "pezzotto", c2);
		prodottiCRUD.create(p3);
		Prodotto p4 = new Prodotto("banana", "curva", c3);
		prodottiCRUD.create(p4);
		Prodotto p5 = new Prodotto("caricabatterie", "cinese", c2);
		prodottiCRUD.create(p5);

	}

}
