package model;

public class Prodotto {

	private String id;
	private String nome;
	private String descrizione;
	private int prezzo;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public int getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}
	
	public Prodotto(String id, String nome, String descrizione, int prezzo) {
		super();
		this.id = id;
		this.nome = nome;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
	}
	public Prodotto() {
		super();
	}
	
	@Override
	public String toString() {
		return "Prodotto [id=" + id + ", nome=" + nome + ", descrizione=" + descrizione + ", prezzo=" + prezzo + "]";
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
		if (descrizione == null) {
			if (other.descrizione != null)
				return false;
		} else if (!descrizione.equals(other.descrizione))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(prezzo) != Double.doubleToLongBits(other.prezzo))
			return false;
		return true;
	}

}
