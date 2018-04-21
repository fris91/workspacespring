package com.app.model.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.entity.Sconto;

@Repository
@Transactional
public class ScontoDao {

	@PersistenceContext
	private EntityManager entity;
	
	/**
	 * inserisce lo sconto all'interno del database
	 * 
	 * @param s
	 */
	public void inserimento(Sconto s) {
		entity.persist(s);
		entity.flush();
		entity.clear();
	}
	
	public Sconto returnScontoById(int id) {
		Sconto s=entity.find(Sconto.class, id);
		return s;
	}
	
	/**
	 * ritorna tutti gli sconti contenuti nel database
	 * 
	 * @return
	 */
	public ArrayList<Sconto> visualizza(){
		@SuppressWarnings("unchecked")
		ArrayList<Sconto> sconti=(ArrayList<Sconto>)entity.createQuery("from Sconto").getResultList();
		return sconti;
	}
	
	
	
}
