package com.app.model.entity;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="prodotti")
public class Prodotti {
	
	ArrayList<Prodotto> listaProdotti;

	public Prodotti() {
		super();
		listaProdotti = new ArrayList<Prodotto>();
	}

	public Prodotti(ArrayList<Prodotto> prodotti) {
		super();
		this.listaProdotti = prodotti;
	}

    @XmlElement(name = "prodotto")
	public ArrayList<Prodotto> getProdotti() {
		return listaProdotti;
	}

	public void setProdotti(ArrayList<Prodotto> prodotti) {
		this.listaProdotti = prodotti;
	}
	
	public void addProdotto(Prodotto prodotto) {
		this.listaProdotti.add(prodotto);
	}
	
	public void removeProdotto(Prodotto prodotto) {
		this.listaProdotti.remove(prodotto);
	}
	
	public void clear() {
		this.listaProdotti.clear();
	}

}
