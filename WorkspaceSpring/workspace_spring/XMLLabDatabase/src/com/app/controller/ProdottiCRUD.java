package com.app.controller;

import java.io.File;

import com.app.model.entity.Prodotti;
import com.app.model.entity.Prodotto;
import com.app.services.InOutXML;

public class ProdottiCRUD {
	
	private InOutXML<Prodotti> xmlProdotti;
	private File fileProdotti;
	private Prodotti prodotti;
	private static int contatore;
	
	public ProdottiCRUD() {
		super();
		this.xmlProdotti = new InOutXML<Prodotti>();
		this.fileProdotti = new File("C:/workspace_spring/FileXML/Prodotti.xml");
		this.prodotti = read();
		// Imposto il contatore con l'id dell'ultimo prodotto presente nell'attributo listaProdotti
		if (this.prodotti.getProdotti().size() != 0) {
			ProdottiCRUD.contatore = this.prodotti.getProdotti().get(this.prodotti.getProdotti().size()-1).getId();
		}
	}

	public void create(Prodotto prodotto) {
		if (prodotto == null) return;
		contatore += 1;
		prodotto.setId(contatore);
		prodotti.addProdotto(prodotto);
		xmlProdotti.writeXML(fileProdotti, prodotti);
	}
	
	public Prodotti read() {
		return xmlProdotti.readXML(fileProdotti, Prodotti.class);
	}
	
	public void deleteOne(Prodotto prodotto) {
		if (prodotto == null) return;
		prodotti.removeProdotto(prodotto);
		xmlProdotti.writeXML(fileProdotti, prodotti);
	}
	
	public void deleteMany(String[] idValuesToRemove) {
		if (idValuesToRemove == null) return;
		for (String idString : idValuesToRemove) {
			for (Prodotto p : prodotti.getProdotti()) {
				if (p.getId() == Integer.parseInt(idString)) {
					prodotti.removeProdotto(p);
					break;
				}
			}
		}
		xmlProdotti.writeXML(fileProdotti, prodotti);
	}
	
	public void clear() {
		prodotti.clear();
		xmlProdotti.writeXML(fileProdotti, prodotti);
	}

}
