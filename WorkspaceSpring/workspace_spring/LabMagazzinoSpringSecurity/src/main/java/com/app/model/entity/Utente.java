package com.app.model.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;

@Entity
@Table(name="Utenti")
public class Utente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "utente_id")
	private int id;
	
	@Column(name = "email")
	@Email(message = "*Inserisci una mail valida")
	@NotEmpty(message = "*Per piacere inserisci una mail")
	private String email;
	
	@Column(name = "password")
	@Length(min = 5, message = "*La password deve avere una lunghezza minima di 5 caratteri")
	@NotEmpty(message = "*Inserisci una password")
	@Transient
	private String password;
	
	@Column(name = "nome")
	@NotEmpty(message = "*Inserisci il nome")
	private String nome;
	
	@Column(name = "cognome")
	@NotEmpty(message = "*Inserisci il cognome")
	private String cognome;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private Ruolo ruolo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Ruolo getRuolo() {
		return ruolo;
	}
	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}
}
