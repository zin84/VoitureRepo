package com.adaming.bookingvoiture.dao.entretien;
/*
 * Classe:EntretienDaoImpl
 * Package:com.adaming.bookingvoiture.dao.entretien
 * Version: 1.0.0
 * Date: 09/08/2016
 * Author: Romain Ganet
 * */

import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.adaming.bookingvoiture.entities.Entretien;
import com.adaming.bookingvoiture.entities.Voiture;
import com.adaming.bookingvoiture.exceptions.ObjetInexistantException;


public class EntretienDaoImpl implements IEntretienDao{
	
Logger log = Logger.getLogger("EntretienDaoImpl");
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Entretien addEntretien(Entretien e, Long idVoiture) throws ObjetInexistantException {
		Voiture v = em.find(Voiture.class, idVoiture);
		if(v == null)
			throw new ObjetInexistantException("La voiture n'existe pas");
		e.setVoiture(v);
		em.persist(e);
		log.info("L'entretien "+e.getIdEntretient()+" a bien été enregistré !");
		return e;
	}

	@Override
	public Entretien deleteEntretien(Long idEntretient) throws ObjetInexistantException {
		Entretien e = em.find(Entretien.class, idEntretient);
		if(e == null)
			throw new ObjetInexistantException("L'entretien n'existe pas"); 
		em.remove(e);
		log.info("L'entretien "+e.getIdEntretient()+" a bien été supprimé !");
		return e;
	}

	@Override
	public Entretien updateEntretien(Entretien e) {
		Entretien e2 = em.find(Entretien.class,e.getIdEntretient());
		if(e2.getVoiture()!= null){
			e2.setVoiture(e2.getVoiture());
		}
		em.merge(e);
		log.info("L'entretien "+e.getIdEntretient()+" a bien été modifié !");
		return e;
	}

	@Override
	public List<Entretien> getListEntretien() throws ObjetInexistantException {
		Query query = em.createQuery("from Entretien");
		if(query.getResultList().size() == 0)
			throw new ObjetInexistantException("Il n'existe aucun entretien");
		log.info("Il existe "+query.getResultList().size()+" entretiens !");
		return query.getResultList();
	}

	@Override
	public Entretien getEntretien(Long idEntretient) throws ObjetInexistantException {
		Entretien e3 = em.find(Entretien.class, idEntretient);
		if(e3 == null)
			throw new ObjetInexistantException("L'entretien n'existe pas");
		log.info("L'entretien "+e3.getIdEntretient()+" a bien été récupéré !");
		return e3;
	}

	@Override
	public List<Entretien> getListVidange() throws ObjetInexistantException {
		Query query = em.createQuery("from Entretien where TypeEntretien = Vidange");
		if(query.getResultList().size() == 0)
			throw new ObjetInexistantException("Il n'existe aucun entretien type vidange");
		log.info("Il existe "+query.getResultList().size()+" entretiens type vidange !");
		return query.getResultList();
	}

	@Override
	public List<Entretien> getListChaineDistribution() throws ObjetInexistantException {
		Query query = em.createQuery("from Entretien where TypeEntretien = ChaineDistribution");
		if(query.getResultList().size() == 0)
			throw new ObjetInexistantException("Il n'existe aucun entretien type chaine distribution");
		log.info("Il existe "+query.getResultList().size()+" entretiens type chaine distribution !");
		return query.getResultList();
	}

	@Override
	public List<Entretien> getListFiltreHuile() throws ObjetInexistantException {
		Query query = em.createQuery("from Entretien where TypeEntretien = FiltreHuile");
		if(query.getResultList().size() == 0)
			throw new ObjetInexistantException("Il n'existe aucun entretien type filtre huile");
		log.info("Il existe "+query.getResultList().size()+" entretiens type filtre huile !");
		return query.getResultList();
	}

}
