package com.app.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.entity.ProdottoListino;
import com.app.model.entity.ProdottoListino.Id;

@Repository
@Transactional
public class ProdottoListinoDao {

	@PersistenceContext
	private EntityManager entity;
	
	/**
	 * inserisce il prodotto-listino all'interno del database
	 * 
	 * @param pl
	 */
	public void inserimento(ProdottoListino pl) {
		entity.persist(pl);
		entity.flush();
		entity.clear();
	}
	
	/**
	 * ritorna dal database il prodotto-listino avente l'id inserito nel metodo
	 * 
	 * @param id
	 * @return
	 */
	public ProdottoListino returnProdottoListinoById(Id id) {
		ProdottoListino pl=entity.find(ProdottoListino.class, id);
		return pl;
	}
	
	/**
	 * elimina il prodotto-listino all'interno del database
	 * 
	 * @param pl
	 */
	public void cancella(ProdottoListino pl) {
		entity.remove(entity.merge(pl));
		entity.flush();
	}
	
}