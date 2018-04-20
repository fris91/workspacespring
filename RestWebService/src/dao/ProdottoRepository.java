package dao;

import java.util.Collection;
import java.util.HashMap;

import model.Prodotto;

public class ProdottoRepository {
	
	private ProdottoRepository(){}
	
	private static ProdottoRepository instance=null;
	
	public static synchronized ProdottoRepository getInstance() {
		if(instance==null) {
			instance = new ProdottoRepository();
		}
		return instance;
	}
	
	private HashMap<String,Prodotto> prodotti = new  HashMap<String,Prodotto>();
	
	//metodo per aggiungere il singolo prodotto
	public void aggiungiProdotto(Prodotto p) {
		prodotti.put(p.getId(), p);
	}
	
	//metodo per eliminare il singolo prodotto
	public Prodotto eliminaProdotto(String id) {
		return prodotti.remove(id);
	}
	
	//ritorna tutta la collection di prodotti
	public Collection<Prodotto> visualizzaProdotti() {
		return prodotti.values();
	}
	
	//metodo che ritorna il singolo prodotto dalla collection
	public Prodotto visualizzaProdotto(String id) {
		return prodotti.get(id);
	}
	
}
