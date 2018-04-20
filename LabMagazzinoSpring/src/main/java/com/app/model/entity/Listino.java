package com.app.model.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="listini")
public class Listino {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="data")
	@Temporal(TemporalType.DATE)
	@NotNull(message="*Inserire una data")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Calendar data;
	
	@Column(name="nome_listino")
	@NotEmpty(message="*Inserire un listino")
	private String nomeListino;
	
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER, mappedBy="listino", orphanRemoval=true)
	private Set<ProdottoListino> prodottilistino=new HashSet<ProdottoListino>();

	public String formatDate() {
		SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
		String formatted = date.format(this.data.getTime());
		return formatted;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public String getNomeListino() {
		return nomeListino;
	}
	public void setNomeListino(String nomeListino) {
		this.nomeListino = nomeListino;
	}
	public Set<ProdottoListino> getProdotto() {
		return prodottilistino;
	}
	public void setProdotto(Set<ProdottoListino> prodotto) {
		this.prodottilistino = prodotto;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Listino other = (Listino) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (id != other.id)
			return false;
		if (nomeListino == null) {
			if (other.nomeListino != null)
				return false;
		} else if (!nomeListino.equals(other.nomeListino))
			return false;
		if (prodottilistino == null) {
			if (other.prodottilistino != null)
				return false;
		} else if (!prodottilistino.equals(other.prodottilistino))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Listini [id=" + id + ", data=" + data + ", nomeListino=" + nomeListino + ", prodotto=" + prodottilistino + "]";
	}

	public Listino(int id, Calendar data, String nomeListino, Set<ProdottoListino> prodottilistino) {
		super();
		this.id = id;
		this.data = data;
		this.nomeListino = nomeListino;
		this.prodottilistino = prodottilistino;
	}
	public Listino() {
		super();
	}
	
	public void AddProdottoListino(ProdottoListino pl){
		this.prodottilistino.add(pl);
	}

}
