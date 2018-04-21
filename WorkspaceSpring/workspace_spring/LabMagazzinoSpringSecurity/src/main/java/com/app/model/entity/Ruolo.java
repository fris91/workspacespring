package com.app.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ruoli")
public class Ruolo  implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ruolo_id")
	private int id;
	
	@Column(name="ruolo")
	private String ruolo;
	
	@OneToMany(mappedBy="ruolo",cascade = CascadeType.ALL)
	private List<Utente> utenti = new ArrayList<Utente>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRuolo() {
		return ruolo;
	}
	public List<Utente> getUtente() {
		return utenti;
	}
	public void setUtente(List<Utente> utente) {
		this.utenti = utente;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	
}