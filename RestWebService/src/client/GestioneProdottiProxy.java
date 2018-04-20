package client;

import java.util.Collection;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.jackson.JacksonFeature;

import model.Prodotto;

public class GestioneProdottiProxy {

	private Client client;
	private final String serviceUrl="http://localhost:8080/RestWebService/services/prodotti";

	public GestioneProdottiProxy() {
		client = ClientBuilder.newClient();
		client.register(new JacksonFeature());
	}

	public void close() {
		if (client!=null) { 
			client.close(); 
		}
	}

	public String getProdottiAsJsonString() {
		String result = client.target(serviceUrl).request().accept(MediaType.APPLICATION_JSON).get().readEntity(String.class);
		return result; 
	}

	public Collection<Prodotto> getProdotti() {
		Collection<Prodotto> result =client.target(serviceUrl).request(MediaType.APPLICATION_JSON).get(new GenericType<Collection<Prodotto>>() {});
		return result; 
	}

	public Prodotto getProdotto(String id) {
		try {
			Prodotto result = client.target(serviceUrl).path(id).request(MediaType.APPLICATION_JSON).get(Prodotto.class);
			return result; 
		} catch(NotFoundException e) {
			return null; 
		}
	}

	public void addProdotto(Prodotto p) {
		Form form = new Form().param("id", p.getId()).param("nome", p.getNome()).param("descrizione", p.getDescrizione()).param("prezzo", String.valueOf(p.getPrezzo()));
		client.target(serviceUrl).request().accept(MediaType.APPLICATION_JSON).post(Entity.form(form));
	}

	public void deleteProdotto(String id) {
		client.target(serviceUrl).path((id)).request().accept(MediaType.APPLICATION_JSON).delete();
	}

}

