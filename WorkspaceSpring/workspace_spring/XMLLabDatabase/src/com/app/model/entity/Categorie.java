package com.app.model.entity;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="categorie")
public class Categorie {

	ArrayList<Categoria> listaCategorie;
	
	public Categorie() {
		super();
	}
	
	public Categorie(ArrayList<Categoria> categorie) {
		super();
		this.listaCategorie = categorie;
	}

    @XmlElement(name = "categoria")
	public ArrayList<Categoria> getListaCategorie() {
		return listaCategorie;
	}

	public void setListaCategorie(ArrayList<Categoria> listaCategorie) {
		this.listaCategorie = listaCategorie;
	}
	
}
