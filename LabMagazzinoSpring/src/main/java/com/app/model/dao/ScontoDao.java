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
