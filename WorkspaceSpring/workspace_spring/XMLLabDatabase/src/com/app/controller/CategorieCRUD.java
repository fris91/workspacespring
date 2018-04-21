package com.app.controller;

import java.io.File;

import com.app.model.entity.Categorie;
import com.app.services.InOutXML;

public class CategorieCRUD {

	InOutXML<Categorie> xmlCategorie;
	File fileCategorie;
	Categorie categorie;
	
	public CategorieCRUD() {
		super();
		this.xmlCategorie = new InOutXML<Categorie>();
		this.fileCategorie = new File("C:/workspace_spring/FileXML/Categorie.xml");
		this.categorie = new Categorie();
	}
	
	public Categorie read() {
		return xmlCategorie.readXML(fileCategorie, Categorie.class);
	}
}
