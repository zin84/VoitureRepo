package com.adaming.bookingvoiture.dao.facture;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.adaming.bookingvoiture.entities.Client;
import com.adaming.bookingvoiture.entities.Facture;
import com.adaming.bookingvoiture.entities.Reservation;
import com.adaming.bookingvoiture.entities.Voiture;
import com.adaming.bookingvoiture.exceptions.ExceptionPerso;


public class FactureDaoImpl implements IFactureDao{
	
@PersistenceContext
	private EntityManager em;
Logger log = Logger.getLogger("FactureDaoImpl");

	
	@Override
	public Facture addFactureByReservation(Facture f, Long idReservation) 
			throws ExceptionPerso {
		Reservation r = em.find(Reservation.class, idReservation);
		if (r==null) {
			throw new ExceptionPerso("L'id de la reservation n'existe pas");
		}
		f.setReservation(r);
		if (f.getReservation().getIdReservation()==idReservation) {
			throw new ExceptionPerso("La facture possède déjà une réservation");
		}
		em.merge(f.getReservation());
		em.persist(f);
		log.info("La facture"+" "+f.getDateDeFacturation()+" "+"a bien été enregistrée");
		return f;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Facture> getAllfactures() {
		Query query = em.createQuery("From Facture");
		log.info("Il existe"+" "+query.getResultList().size()+" "+"factures");
		return query.getResultList();
	}

	@Override
	public Facture getInfosPrintFacture(Long idFacture,Long idReservation) {
		Facture f =em.find(Facture.class, idFacture);
		Reservation r=em.find(Reservation.class, idReservation);
		r.getClientReservation().getIdClient();
		f.setReservation(r);
		log.info("la facture"+" "+f.getIdFacture()+"a bien été récupérée");
		return f;
	}

	@Override
	public Double calculerCoutFacture(Long idReservation) throws ExceptionPerso {

		Reservation r = em.find(Reservation.class, idReservation);
		double coutReservation=0;
	    coutReservation=r.getPrix();
		double coutFacture=coutReservation +(0.5*coutReservation);
		log.info("Le cout de la facture est de :"+" "+coutFacture+"euros");
		return coutFacture;
		
	}

	@Override
	public Double calculCoutTotalByClient(Long idReservation,Long idClient,Long idVoiture) throws ExceptionPerso {
		Client c = em.find(Client.class, idClient);
		if (c==null) {
			throw new ExceptionPerso("L'id client"+" "+c.getIdClient()
					+"n'existe pas");
		}
		Reservation r = em.find(Reservation.class, idReservation);
		if(r==null){
			throw new ExceptionPerso("L'id de la réservation"+" "
		+r.getIdReservation()+"n'existe pas");
		}
		Voiture v = em.find(Voiture.class, idVoiture);
		if(v==null){
			throw new ExceptionPerso("L'id de la voiture"+" "
		+v.getIdvoiture()+"n'existe pas");
		}
		List<Reservation>tabReservation = v.getTabReservationVoiture();
		double coutReservation=0;
		double coutFactureByClient=0;
		for (Reservation reservation : tabReservation) {
			if (reservation.getClientReservation().getIdClient()==idClient) {
				coutReservation=reservation.getPrix();
			}
			
		}
		log.info("Le cout de la facture de la voiture :"+" "+v.getIdvoiture()+" "
				+"est de:"+" "+coutFactureByClient+" "+"euros");
		return coutFactureByClient = coutReservation+(0.5*coutFactureByClient);
	}

	@Override
	public Double calculCoutTotalByVoiture(Long idReservation, Long idVoiture) {
		Reservation r = em.find(Reservation.class, idReservation);
		Voiture v=em.find(Voiture.class, idVoiture);
		List<Reservation>tabReservation = v.getTabReservationVoiture();
		double coutReservation=0;
		for (Reservation reservation : tabReservation) {
			if (r.getVoitureReservation().getIdvoiture()==(idVoiture)) {
				coutReservation= reservation.getPrix();
			}
		}
		double coutFactureByVoiture=coutReservation+(coutReservation*0.5);
		log.info("Le cout de la facture de la voiture :"+" "+v.getIdvoiture()+" "
				+"est de:"+" "+coutFactureByVoiture+" "+"euros");
		return coutFactureByVoiture;
	}

}
