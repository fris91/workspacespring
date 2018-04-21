package com.app.model.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.entity.Prodotto;

@Repository // è il contesto di spring che annota che questa classe si occuperà solo dei dao
@Transactional
public class ProdottoDao {

	@PersistenceContext
	private EntityManager entity;

	/**
	 * inserisce il prodotto all'interno del database
	 * 
	 * @param p
	 */
	public void inserimento(Prodotto p) {
		entity.persist(p);
		entity.flush();
		entity.clear();
	}

	/**
	 * ritorna dal database il prodotto avente l'id inserito nel metodo
	 * 
	 * @param id
	 * @return
	 */
	public Prodotto returnProdottoById(int id) {
		Prodotto p=entity.find(Prodotto.class, id);
		return p;
	}

	/**
	 * modifica il prodotto all'interno del database
	 * 
	 * @param p
	 */
	public void modifica(Prodotto p) {
		entity.merge(p);
		entity.flush();
		entity.clear();
	}

	/**
	 * elimina il prodotto all'interno del database
	 * 
	 * @param p
	 */
	public void cancella(Prodotto p) {
		entity.remove(entity.merge(p));
		entity.flush();
	}

	/**
	 * ritorna tutti i prodotti contenuti nel database
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Prodotto> visualizza() {
		ArrayList<Prodotto> prodotti= (ArrayList<Prodotto>)entity.createQuery("From Prodotto").getResultList();
		return prodotti;
	}
	
	
	// ********************* NAVIGAZIONE PER PAGINE ******************************************
	
	/*
	 * variabili di navigazione
	 */
	private int paginaCorrente;
	private int lunghezzaPagina;

	public int getPaginaCorrente() {
		return paginaCorrente;
	}

	public int getLunghezzaPagina() {
		return lunghezzaPagina;
	}

	public void setPaginaCorrente(int paginaCorrente) {
		this.paginaCorrente = paginaCorrente;
	}

	public void setLunghezzaPagina(int lunghezzaPagina) {
		this.lunghezzaPagina = lunghezzaPagina;
	}

	/**
	 * metodo che ritorna il valore dell'offset
	 * 
	 * @return
	 */
	public int getOffset() {
		return (paginaCorrente-1)*lunghezzaPagina;
	}

	/**
	 * metodo che ritorna il totale delle righe
	 * 
	 * @return
	 */
	public long totaleRighe() {
		return (long) entity.createQuery("select count(p.id) from Prodotto p").getSingleResult();
	}

	/**
	 * metodo che ritorna il totale delle pagine
	 * 
	 * @return
	 */
	public int TotalePagine() {
		return (int) Math.ceil((double)totaleRighe()/lunghezzaPagina);
	}

	/**
	 * metodo che ritorna tutti i prodotti presenti nel database,
	 * 
	 * dati limit e offset
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Prodotto> dammiPagina() {
		return (ArrayList<Prodotto>) entity.createQuery("from Prodotto")
				.setFirstResult(getOffset()) 		//offset
				.setMaxResults(lunghezzaPagina) 	//limit
				.getResultList();
	}

	/**
	 * metodo che ritorna la pagina successiva, se presente
	 * 
	 * @return
	 */
	public ArrayList<Prodotto> paginaSuccessiva() {
		if(paginaCorrente<TotalePagine()){
			paginaCorrente++;
			return dammiPagina();
		}else{ 
			return dammiPagina();
		}
	}

	/**
	 * metodo che ritorna la pagina precedente, se presente
	 * 
	 * @return
	 */
	public ArrayList<Prodotto> paginaPrecedente() {
		if(paginaCorrente>1){
			paginaCorrente--;
			return dammiPagina();
		}else{ 
			return dammiPagina();
		}
	}

	/**
	 * metodo che ritorna la prima pagina
	 * 
	 * @return
	 */
	public ArrayList<Prodotto> primaPagina() {
		paginaCorrente=1;
		return dammiPagina();
	}

	/**
	 * metodo che ritorna l'ultima pagina
	 * 
	 * @return
	 */
	public ArrayList<Prodotto> ultimaPagina() {
		paginaCorrente=TotalePagine();
		return dammiPagina();
	}
	
	// costruttore di default
	public ProdottoDao() {
		super();
		/*
		 * al momento dell'istanza del dao inizializzo
		 * le variabili di navigazione ad uno
		 */
		this.paginaCorrente=1;
		this.lunghezzaPagina=1;
	}

}
