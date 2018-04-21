package com.app.model.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="sconti")
public class Sconto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="nome_sconto")
	@NotEmpty(message="*Inserire uno sconto")
	private String nomeSconto;
	
	@Column(name="sconto")
	@NotEmpty(message="*Inserire un valore")
	private double sconto;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.MERGE, mappedBy="sconto")
	private Set<ProdottoListino> prodottiListino=new HashSet<ProdottoListino>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeSconto() {
		return nomeSconto;
	}
	public void setNomeSconto(String nomeSconto) {
		this.nomeSconto = nomeSconto;
	}
	public double getSconto() {
		return sconto;
	}
	public void setSconto(double sconto) {
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
		Sconto other = (Sconto) obj;
		if (id != other.id)
			return false;
		if (nomeSconto == null) {
			if (other.nomeSconto != null)
				return false;
		} else if (!nomeSconto.equals(other.nomeSconto))
			return false;
		if (Double.doubleToLongBits(sconto) != Double.doubleToLongBits(other.sconto))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Sconti [id=" + id + ", nomeSconto=" + nomeSconto + ", sconto=" + sconto + "]";
	}
	
	public Sconto(int id, String nomeSconto, double sconto) {
		super();
		this.id = id;
		this.nomeSconto = nomeSconto;
		this.sconto = sconto;
	}
	public Sconto() {
		super();
	}
	
	public void addProdottoListino(ProdottoListino pl){
		this.prodottiListino.add(pl);
	}

}
