package services;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import dao.ProdottoRepository;
import model.Prodotto;

@Path("/prodotti/{id}")
public class ProdottoResources {

	@Context
	private UriInfo context;
	private ProdottoRepository pr;
	public ProdottoResources() {
		pr=ProdottoRepository.getInstance();
	}

	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
	public Prodotto getProdotto (@PathParam("id") String id) {
		Prodotto p = pr.visualizzaProdotto(id); 
		if (p==null) {
			String errorMessage = "Prodotto with id: " + id + " not found";
			throw new WebApplicationException(Response.status(404).entity(errorMessage).type("text/plain").build());
		}
		return p; 
	}

	@DELETE
	public Prodotto deleteProdotto (@PathParam("id") String id) {
		Prodotto p = pr.eliminaProdotto(id); 
		if (p==null) {
			String errorMessage = "Prodotto with id: " + id + " not found";
			throw new WebApplicationException(Response.status(404).entity(errorMessage).type("text/plain").build());
		}
		return p; 
	}

}
