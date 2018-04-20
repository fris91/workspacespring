package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import client.GestioneProdottiProxy;
import model.Prodotto;

@WebServlet("/PrimaServlet")
public class PrimaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PrimaServlet() {
        super();
    }

	GestioneProdottiProxy proxy = new GestioneProdottiProxy();
	
	RequestDispatcher rd;
	Prodotto p;
	ArrayList<Prodotto> prodotti;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	switch(request.getParameter("type")) {
		
		case "aggiungi1":
			p = new Prodotto("1","Pallone","Rotondo",12);
			proxy.addProdotto(p);
			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			break;
		
		case "aggiungi2":
			p = new Prodotto("2","Banana","Chiquita",5);
			proxy.addProdotto(p);
			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			break;
			
		case "visualizza1":
			p = proxy.getProdotto("1");
			request.setAttribute("prodotto", p);
			rd = request.getRequestDispatcher("visualizza.jsp");
			rd.forward(request, response);
			break;
			
		case "visualizza2":
			p = proxy.getProdotto("2");
			request.setAttribute("prodotto", p);
			rd = request.getRequestDispatcher("visualizza.jsp");
			rd.forward(request, response);
			break;
			
		case "visualizza":
			prodotti = (ArrayList<Prodotto>) proxy.getProdotti();
			request.setAttribute("prodotti", prodotti);
			rd = request.getRequestDispatcher("visualizza.jsp");
			rd.forward(request, response);
			break;
		
		case "elimina1":
			proxy.deleteProdotto("1");
			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			break;
			
		case "elimina2":
			proxy.deleteProdotto("2");
			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			break;
			
		}
	
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
