package com.app.model.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="prodotti_listini")
public class ProdottoListino {
	
	/*
	 * creazione dell'id composto
	 */
	@Embeddable
	public static class Id implements Serializable {
		private static final long serialVersionUID = 1L;

		@Column(name="id_prodotto")
		private int id_prodotto;

		@Column(name="id_listino")
		private int id_listino;

		public int getId_prodotto() {
			return id_prodotto;
		}

		public void setId_prodotto(int id_prodotto) {
			this.id_prodotto = id_prodotto;
		}

		public int getId_listino() {
			return id_listino;
		}

		public void setId_listino(int id_listino) {
			this.id_listino = id_listino;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Id other = (Id) obj;
			if (id_listino != other.id_listino)
				return false;
			if (id_prodotto != other.id_prodotto)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Id [id_prodotto=" + id_prodotto + ", id_listino=" + id_listino + "]";
		}

		public Id(int id_prodotto, int id_listino) {
			super();
			this.id_prodotto = id_prodotto;
			this.id_listino = id_listino;
		}

		public Id() {
			super();
		}
	}
	
	/*
	 * l'id di questa classe è composto da due chiavi:
	 * 
	 * id_prodotto
	 * 
	 * id_listino
	 * 
	 */
	@EmbeddedId
	private Id id;
	
	@ManyToOne
	@JoinColumn(name="id_prodotto",referencedColumnName="id",insertable=false, updatable=false)
	private Prodotto prodotto;
	
	@ManyToOne
	@JoinColumn(name="id_listino",referencedColumnName="id",insertable=false, updatable=false)
	private Listino listino;
	
	@ManyToOne
	@JoinColumn(name="id_sconto",referencedColumnName="id")
	private Sconto sconto;
	
	@Column(name="prezzo")
	private double prezzo;

	public Id getId() {
		return id;
	}
	public void setId(Id id) {
		this.id = id;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public Prodotto getProdotto() {
		return prodotto;
	}
	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}
	public Listino getListino() {
		return listino;
	}
	public void setListino(Listino listino) {
		this.listino = listino;
	}
	public Sconto getSconto() {
		return sconto;
	}
	public void setSconto(Sconto sconto) {
		this.sconto = sconto;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdottoListino other = (ProdottoListino) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (listino == null) {
			if (other.listino != null)
				return false;
		} else if (!listino.equals(other.listino))
			return false;
		if (Double.doubleToLongBits(prezzo) != Double.doubleToLongBits(other.prezzo))
			return false;
		if (prodotto == null) {
			if (other.prodotto != null)
				return false;
		} else if (!prodotto.equals(other.prodotto))
			return false;
		if (sconto == null) {
			if (other.sconto != null)
				return false;
		} else if (!sconto.equals(other.sconto))
			return false;
		return true;
	}

	public ProdottoListino() {
		super();
	}
	public ProdottoListino(Id id, Prodotto prodotto, Listino listino, Sconto sconto, double prezzo) {
		super();
		this.id = id;
		this.prodotto = prodotto;
		this.listino = listino;
		this.sconto = sconto;
		this.prezzo = prezzo;
	}

	public void addProdottoListinoToProdotto(){
		this.prodotto.addProdottoListino(this);
	}
	public void addProdottoListinoToListino(){
		this.listino.AddProdottoListino(this);
	}
	public void addProdottoListinoToSconto(){
		this.sconto.addProdottoListino(this);
	}
	
}
