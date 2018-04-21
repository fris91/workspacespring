package com.app.model.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="categorie")
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="categoria")
	@NotEmpty(message="*Inserire una categoria")
	private String nomeCategoria;
	
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER, mappedBy="categoria", orphanRemoval=true)
	private Set<Prodotto> prodotti=new HashSet<Prodotto>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Set<Prodotto> getProdotto() {
		return prodotti;
	}
	public void setProdotto(Set<Prodotto> prodotto) {
		this.prodotti = prodotto;
	}
	public String getNomeCategoria() {
		return nomeCategoria;
	}
	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (id != other.id)
			return false;
		if (nomeCategoria == null) {
			if (other.nomeCategoria != null)
				return false;
		} else if (!nomeCategoria.equals(other.nomeCategoria))
			return false;
		if (prodotti == null) {
			if (other.prodotti != null)
				return false;
		} else if (!prodotti.equals(other.prodotti))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return nomeCategoria;
	}
	
	public Categoria(int id, String nomeCategoria, Set<Prodotto> prodotto) {
		super();
		this.id = id;
		this.nomeCategoria = nomeCategoria;
		this.prodotti = prodotto;
	}
	public Categoria() {
		super();
	}
	
	public void addProdotto(Prodotto p){
		this.prodotti.add(p);
	}

}
