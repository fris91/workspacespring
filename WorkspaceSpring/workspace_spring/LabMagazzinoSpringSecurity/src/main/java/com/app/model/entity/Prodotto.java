package com.app.model.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="prodotti")
public class Prodotto implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="nome")
	@NotEmpty(message="*Inserire un nome")
	private String nome; 
	
	@Column(name="descrizione")
	@NotEmpty(message="*Inserire una descrizione")
	private String descrizione;
	
	@Column(name="foto")
	@NotEmpty(message="*Inserire una foto")
	private String foto;
	
	@ManyToOne
	@JoinColumn(name="id_categoria", referencedColumnName="id")
	private Categoria categoria;
	
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER, mappedBy="prodotto", orphanRemoval=true)
	private Set<ProdottoListino> listini=new HashSet<ProdottoListino>();
	
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
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Set<ProdottoListino> getListini() {
		return listini;
	}
	public void setListini(Set<ProdottoListino> listini) {
		this.listini = listini;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prodotto other = (Prodotto) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (descrizione == null) {
			if (other.descrizione != null)
				return false;
		} else if (!descrizione.equals(other.descrizione))
			return false;
		if (foto == null) {
			if (other.foto != null)
				return false;
		} else if (!foto.equals(other.foto))
			return false;
		if (id != other.id)
			return false;
		if (listini == null) {
			if (other.listini != null)
				return false;
		} else if (!listini.equals(other.listini))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	public Prodotto(int id, String nome, String descrizione, String foto, Categoria categoria, Set<ProdottoListino> listini) {
		super();
		this.id = id;
		this.nome = nome;
		this.descrizione = descrizione;
		this.foto = foto;
		this.categoria = categoria;
		this.listini = listini;
	}
	public Prodotto() {
		super();
	}

	public void addProdottoListino(ProdottoListino pl){
		this.listini.add(pl);
	}
	public void addProdottoToCategoria(){
		this.categoria.addProdotto(this);
	}

}
