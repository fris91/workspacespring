package services;

import java.net.URI;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import dao.ProdottoRepository;
import model.Prodotto;

@Path("/prodotti")
@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON,MediaType.TEXT_HTML})
@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
public class ProdottiContainer {
	
	@Context
	private UriInfo context;
	private ProdottoRepository pr;
	public ProdottiContainer() {
		pr=ProdottoRepository.getInstance();
	}

	@GET
	public ArrayList<Prodotto> getProdotti() {
		ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>();
		prodotti.addAll(pr.visualizzaProdotti());
		return prodotti;
	}

	@POST
	public Response postProdotto(
			@FormParam("id") String id,
			@FormParam("nome") String nome,
			@FormParam("descrizione") String descrizione,
			@FormParam("prezzo") int prezzo,
			@Context HttpServletResponse servletResponse) {
		Prodotto p = new Prodotto(id, nome, descrizione, prezzo); //l'oggetto form è un'oggetto java, quindi non una vera form HTML
		pr.aggiungiProdotto(p);
		URI uri = context.getAbsolutePathBuilder().path(id).build(); //crea l'indirizzo per accedere all'oggetto
		return Response.created(uri).build();
	}

}
