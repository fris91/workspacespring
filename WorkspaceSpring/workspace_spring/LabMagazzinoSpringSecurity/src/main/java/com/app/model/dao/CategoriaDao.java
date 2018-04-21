package com.app.model.dao;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.app.model.entity.Categoria;

@Repository
@Transactional
public class CategoriaDao {
	
	@PersistenceContext
	private EntityManager entity;
	
	/**
	 * inserisce la categoria all'interno del database
	 * 
	 * @param c
	 */
	public void inserimento(Categoria c) {
		entity.persist(c);
		entity.flush();
		entity.clear();
	}
	
	/**
	 * ritorna dal database la categoria avente l'id inserito nel metodo
	 * 
	 * @param id
	 * @return
	 */
	public Categoria returnCategoriaById(int id) {
		Categoria c=entity.find(Categoria.class, id);
		return c;
	}
	
	/**
	 * modifica la categoria all'interno del database
	 * 
	 * @param c
	 */
	public void modifica(Categoria c) {
		entity.merge(c);
		entity.flush();
		entity.clear();
	}
	
	/**
	 * elimina la categoria all'interno del database
	 * 
	 * @param c
	 */
	public void cancella(Categoria c) {
		entity.remove(entity.merge(c));
		entity.flush();
	}
	
	/**
	 * ritorna tutte le categorie contenute nel database
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Categoria> visualizza() {
		ArrayList<Categoria> categorie= (ArrayList<Categoria>)entity.createQuery("From Categoria").getResultList();
		return categorie;
	}
	
}