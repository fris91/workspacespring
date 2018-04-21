package com.app.model.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.entity.Ruolo;

@Repository
@Transactional
public class RuoloDao {
 	
	@PersistenceContext
	private EntityManager entity;
	
	/**
	 * inserisce il ruolo all'interno del database
	 * 
	 * @param r
	 */
	public void inserimento(Ruolo r) {
		entity.persist(r);
		entity.flush();
		entity.clear();
	}
	
	/**
	 * ritorna tutti i ruoli contenuti nel database
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Ruolo> visualizza() {
		ArrayList<Ruolo> ruoli= (ArrayList<Ruolo>)entity.createQuery("From Ruolo").getResultList();
		return ruoli;
	}
	
	/**
	 * Restituisce un ruolo identificato dal nome del ruolo
	 * 
	 * @param email Email dell'utente
	 */
	public Ruolo returnRuoloByName(String nomeRuolo) {
		Ruolo ruolo = null;
		CriteriaBuilder builder = entity.getCriteriaBuilder();
		CriteriaQuery<Ruolo> criteria = builder.createQuery(Ruolo.class);
		Root<Ruolo> rootRuolo = criteria.from(Ruolo.class);
		criteria.where(builder.equal(rootRuolo.get("ruolo"), nomeRuolo));
		Query query = entity.createQuery(criteria);
		try {
			ruolo = (Ruolo) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entity.clear();
		}
		return ruolo;
	}
}
