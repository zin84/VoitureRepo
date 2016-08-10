package com.adaming.bookingvoiture.dao.agence;
/* Classe : AgenceDaoImpl
 * Package : com.adaming.bookingvoiture.dao.agence
 * Author : Philippe
 * Date : 09/08/16
 * Version : 1.0.1
 */
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.adaming.bookingvoiture.entities.Agence;
import com.adaming.bookingvoiture.entities.Facture;
import com.adaming.bookingvoiture.exceptions.ExceptionAddFactureExistanteToAgence;
import com.adaming.bookingvoiture.exceptions.ExceptionAddFactureToAgence;
import com.adaming.bookingvoiture.exceptions.ExceptionGetAgences;

public class AgenceDaoImpl implements IAgenceDao{

	/* attributs */
	Logger log = Logger.getLogger("AgenceDaoImpl");
	
	@PersistenceContext
	private EntityManager em;
	
	/* implementation des methodes de IAgenceDao */
	@Override
	public Agence addAgence(Agence agence) {
		em.persist(agence);
		log.info("-----addAgence-----"+agence.toString());
		return agence;
	}

	@Override
	public Agence getAgence(Long idAgence) {
		Agence agence = em.find(Agence.class, idAgence);
		log.info("-----getAgence-----"+agence.toString());
		return agence;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Agence> getAgences() throws Exception {
		Query query = em.createQuery("from Agence");
		if(query.getResultList().size() == 0){
			throw new ExceptionGetAgences("pas d agences");
		}
		log.info("-----getAgences (size)-----"+query.getResultList().size());
		return query.getResultList();
	}

	@Override
	public Agence updateAgence(Agence agence) {
		em.merge(agence);
		log.info("-----updateAgence-----"+agence.toString());
		return agence;
	}

	@Override
	public Agence addFactureToAgence(Long idAgence, Long idFacture) throws Exception {
		Agence agence = em.find(Agence.class, idAgence);
		Facture facture = em.find(Facture.class, idFacture);
		if(facture == null){
			throw new ExceptionAddFactureToAgence("pas de facture a ajouter a cette agence");
		}else{
			for(Facture f : agence.getFactures()){
				if(f.getIdFacture() == facture.getIdFacture()){
					throw new ExceptionAddFactureExistanteToAgence("facture existante dans cette agence");
				}
			}
		}
		agence.getFactures().add(facture);
		log.info("-----nom Agence-----"+agence.getNom());
		em.merge(agence);
		log.info("-----addFactureToAgence-----agence : "+agence.toString()+" facture : "+facture.toString());
		return agence;
	}

}
