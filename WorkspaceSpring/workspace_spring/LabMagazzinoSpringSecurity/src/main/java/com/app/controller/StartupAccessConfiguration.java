package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.dao.RuoloDao;
import com.app.model.dao.ScontoDao;
import com.app.model.dao.UtenteDao;
import com.app.model.entity.Ruolo;
import com.app.model.entity.Sconto;
import com.app.model.entity.Utente;

@Component
public class StartupAccessConfiguration {

	boolean inizializzazioneAvvenuta = false;

	@Autowired
	RuoloDao ruoloDao;
	@Autowired
	UtenteDao utenteDao;
	@Autowired
	ScontoDao scontoDao;

	@EventListener(ContextRefreshedEvent.class)
	@Transactional
	public void contextRefreshedEvent() {

		if (inizializzazioneAvvenuta) return;

		Utente utenteGod = utenteDao.returnUtenteByEmail("god@god.com");
		if (utenteGod == null) {
			utenteGod = new Utente();
			utenteGod.setRuolo(createRoleIfNotFound("GOD"));
			utenteGod.setEmail("god@god.com");
			utenteGod.setPassword("godgod");
			utenteGod.setNome("god");
			utenteGod.setCognome("god");
			utenteDao.inserimento(utenteGod);
		}

		Utente utenteAdmin = utenteDao.returnUtenteByEmail("admin@admin.com");
		if (utenteAdmin == null) {
			utenteAdmin = new Utente();
			utenteAdmin.setRuolo(createRoleIfNotFound("ADMIN"));
			utenteAdmin.setEmail("admin@admin.com");
			utenteAdmin.setPassword("adminadmin");
			utenteAdmin.setNome("admin");
			utenteAdmin.setCognome("admin");
			utenteDao.inserimento(utenteAdmin);
		}
		
		createRoleIfNotFound("USER");
		
		Sconto scontoZero = scontoDao.returnScontoById(1);
		if (scontoZero == null) {
			scontoZero = new Sconto();
			scontoZero.setNomeSconto("Nessuno sconto");
			scontoZero.setSconto(0);
			scontoDao.inserimento(scontoZero);
		}
		
		Sconto scontoVenticinque = scontoDao.returnScontoById(2);
		if (scontoVenticinque == null) {
			scontoVenticinque = new Sconto();
			scontoVenticinque.setNomeSconto("Sconto 25");
			scontoVenticinque.setSconto(25);
			scontoDao.inserimento(scontoVenticinque);
		}
		
		Sconto scontoCinquanta = scontoDao.returnScontoById(3);
		if (scontoCinquanta == null) {
			scontoCinquanta = new Sconto();
			scontoZero.setNomeSconto("Sconto 50");
			scontoCinquanta.setSconto(50);
			scontoDao.inserimento(scontoCinquanta);
		}

		inizializzazioneAvvenuta = true;
	}

	private Ruolo createRoleIfNotFound(String name) {

		Ruolo ruolo = ruoloDao.returnRuoloByName(name);
		if (ruolo == null) {
			ruolo = new Ruolo();
			ruolo.setRuolo(name);
			ruoloDao.inserimento(ruolo);
		}
		return ruolo;
	}
	
}

