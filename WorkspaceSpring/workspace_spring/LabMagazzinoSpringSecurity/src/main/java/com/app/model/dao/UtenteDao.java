package com.app.model.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.entity.Utente;

@Repository
@Transactional
public class UtenteDao {

	@PersistenceContext
	private EntityManager manager;

	@Autowired
	RuoloDao ruoloDao;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private static final Logger logger = LoggerFactory.getLogger(UtenteDao.class);

	/**
	 * inserisce l'utente nel database criptando la password
	 * 
	 * @param utente
	 * @return
	 */
	public boolean inserimento(Utente utente) {
		utente.setPassword(bCryptPasswordEncoder.encode(utente.getPassword()));
		manager.persist(utente);
		manager.clear();
		return true;
	}
	
	/**
	 * Restituisce un utente identificato dalla sua email
	 * 
	 * @param email Email dell'utente
	 */
	public Utente returnUtenteByEmail(String email) {
		Utente utente = null;
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Utente> criteria = builder.createQuery(Utente.class);
		Root<Utente> rootUtente = criteria.from(Utente.class);
		criteria.where(builder.equal(rootUtente.get("email"), email));
		Query query = manager.createQuery(criteria);
		try {
			utente = (Utente) query.getSingleResult();
		} catch (Exception e) {
			logger.info("Utente non trovato");
		} finally {
			manager.clear();
		}
		return utente;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Utente> visualizza() {
		ArrayList<Utente> utenti= (ArrayList<Utente>)manager.createQuery("From Utente").getResultList();
		return utenti;
	}

}