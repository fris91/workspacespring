package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.ServizioProxy;

@WebServlet("/PrimaServlet")
public class PrimaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PrimaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int a=Integer.parseInt(request.getParameter("primoAddendo"));
		int b=Integer.parseInt(request.getParameter("secondoAddendo"));
		ServizioProxy sq=new ServizioProxy();
		int c=sq.somma(a, b);
		response.getWriter().println("la somma è "+c);
	}

}
