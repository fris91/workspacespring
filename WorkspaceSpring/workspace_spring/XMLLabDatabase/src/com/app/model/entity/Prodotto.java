package com.app.model.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "prodotto")
public class Prodotto {
	
	@XmlAttribute	
	private int id;
	
	@XmlElement
	private String nome;
	
	@XmlElement
	private String descrizione;
	
	@XmlElement
	private Categoria categoria;
		
	public Prodotto() {
		super();
	}
	
	public Prodotto(String nome, String descrizione, Categoria categoria) {
		super();
		this.nome = nome;
		this.descrizione = descrizione;
		this.categoria = categoria;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
