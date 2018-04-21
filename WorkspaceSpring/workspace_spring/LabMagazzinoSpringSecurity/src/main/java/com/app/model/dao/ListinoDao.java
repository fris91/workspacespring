package com.app.model.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.app.model.entity.Listino;

@Repository
@Transactional
public class ListinoDao {

	@PersistenceContext
	private EntityManager entity;
	
	/**
	 * inserisce il listino all'interno del database
	 * 
	 * @param l
	 */
	public void inserimento(Listino l) {
		entity.persist(l);
		entity.flush();
		entity.clear();
	}
	
	/**
	 * ritorna dal database il listino avente l'id inserito nel metodo
	 * 
	 * @param id
	 * @return
	 */
	public Listino returnListinoById(int id) {
		Listino l=entity.find(Listino.class, id);
		return l;
	}
	
	/**
	 * modifica il listino all'interno del database
	 * 
	 * @param l
	 */
	public void modifica(Listino l) {
		entity.merge(l);
		entity.flush();
		entity.clear();
	}
	
	/**
	 * elimina il listino all'interno del database
	 * 
	 * @param l
	 */
	public void cancella(Listino l) {
		entity.remove(entity.merge(l));
		entity.flush();
	}
	
	/**
	 * ritorna tutti i listini contenuti nel database
	 * 
	 * @return
	 */
	public ArrayList<Listino> visualizza(){
		@SuppressWarnings("unchecked")
		ArrayList<Listino> listini=(ArrayList<Listino>)entity.createQuery("from Listino").getResultList();
		return listini;
	}

}