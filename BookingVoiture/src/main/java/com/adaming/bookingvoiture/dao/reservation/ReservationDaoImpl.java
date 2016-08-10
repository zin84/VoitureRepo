package com.adaming.bookingvoiture.dao.reservation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.adaming.bookingvoiture.entities.Client;
import com.adaming.bookingvoiture.entities.Reservation;
import com.adaming.bookingvoiture.entities.Voiture;
import com.adaming.bookingvoiture.exceptions.ExceptionDeleteRes;
import com.adaming.bookingvoiture.exceptions.ExceptionResDispo;



public class ReservationDaoImpl implements IReservationDao{

	Logger log=Logger.getLogger("ReservationDaoImpl");
	
	@PersistenceContext
	private  EntityManager em;
	
	@Override
	public Reservation addreservation(Reservation r, Long idClient,
			Long idVoiture) throws ExceptionResDispo {
		Client c=em.find(Client.class, idClient);
		Voiture v=em.find(Voiture.class, idVoiture);
		List<Reservation> tabTestRes=new ArrayList<Reservation>();
		List<Reservation> tabRes=v.getTabReservationVoiture();
		for(Reservation res:tabRes){
			if((res.getDateDeRentrer().before(r.getDateDeRentrer()) && res.getDateDeSortie().after(r.getDateDeSortie()))
					|| (res.getDateDeRentrer().after(r.getDateDeRentrer()) && res.getDateDeSortie().before(r.getDateDeSortie()))
					|| (res.getDateDeRentrer().before(r.getDateDeSortie()) && res.getDateDeSortie().after(r.getDateDeSortie()))
					|| (res.getDateDeRentrer().before(r.getDateDeRentrer()) && res.getDateDeSortie().after(r.getDateDeRentrer()))
					|| (res.getDateDeRentrer().equals(r.getDateDeRentrer()))
					|| (res.getDateDeSortie().equals(r.getDateDeSortie()))
					|| (res.getDateDeSortie().equals(r.getDateDeRentrer()))){
				tabTestRes.add(res);
				throw new ExceptionResDispo("Cette voiture n'est pas disponible pour ces dates");
			}
		}if(tabTestRes.isEmpty()){
			r.setClientReservation(c);
			r.setVoitureReservation(v);
			final int nbMiliSec=24*60*60*1000;
			Long nbJours= (r.getDateDeSortie().getTime()-r.getDateDeRentrer().getTime())/nbMiliSec;
			double prixTot=v.getPrixLocationJournee()*nbJours;
			r.setPrix(prixTot);
			em.persist(r);
			v.getTabReservationVoiture().add(r);
			log.info("La réservation "+r.getIdReservation()+" a bien été enregistrée");
		}
		return r;
	}
	

	@Override
	public Reservation updateReservation(Reservation r) throws ExceptionResDispo {
		Reservation reserv=getResById(r.getIdReservation());
		List<Reservation> tabRes=getRes();
		List<Reservation> tabResTest=new ArrayList<Reservation>();
		for(Reservation res:tabRes){
			if(res.getVoitureReservation().getIdvoiture()==reserv.getVoitureReservation().getIdvoiture()){
			if((res.getIdReservation()!=reserv.getIdReservation())){
				log.info("je rentre");
				if((res.getDateDeRentrer().before(r.getDateDeRentrer()) && res.getDateDeSortie().after((r.getDateDeSortie()))
					|| (res.getDateDeRentrer().after(r.getDateDeRentrer()) && res.getDateDeSortie().before(r.getDateDeSortie()))
					|| (res.getDateDeRentrer().before(r.getDateDeSortie()) && res.getDateDeSortie().after(r.getDateDeSortie()))
					|| (res.getDateDeRentrer().before(r.getDateDeRentrer()) && res.getDateDeSortie().after(r.getDateDeRentrer()))
					|| (res.getDateDeRentrer().equals(r.getDateDeRentrer()))
					|| (res.getDateDeSortie().equals(r.getDateDeSortie()))
					|| (res.getDateDeSortie().equals(r.getDateDeRentrer())))){
					r.setDateDeRentrer(res.getDateDeRentrer());
				tabResTest.add(res);
				throw new ExceptionResDispo("Cette voiture n'est pas disponible pour ces dates");
			}}}
		}if(tabResTest.isEmpty()){
			em.merge(r);
			log.info("La réservation "+r.getIdReservation()+" a bein été modifiée");
		}
		return r;
	}

	@Override
	public Reservation getResById(Long idReservation) {
		Reservation r=em.find(Reservation.class, idReservation);
		log.info("La réservation "+r.getIdReservation()+" a bien été récupérée");
		return r;
	}

	@Override
	public List<Reservation> getRes() {
		Query query=em.createQuery("from Reservation");
		log.info("Il existe "+query.getResultList().size()+" réservations");
		return query.getResultList();
	}

	@Override
	public List<Reservation> getHistoriqueReservation() {
		List<Reservation> tabRes=getRes();
		List<Reservation> histRes=new ArrayList<Reservation>();
		for(Reservation r:tabRes){
			if(r.getDateDeSortie().before(new Date())){
				histRes.add(r);
			}
		}
		return histRes;
	}


	@Override
	public Reservation deleteReservation(Long idReservation) throws ExceptionDeleteRes {
		Reservation r=em.find(Reservation.class, idReservation);
		if(r.getDateDeRentrer().after(new Date())){
			em.remove(r);
		}else if(r.getDateDeSortie().before(new Date())){
			throw new ExceptionDeleteRes("Cette réservation est déjà passée");
		}else{
			throw new ExceptionDeleteRes("Cette réservation est en cours");
		}
		return null;
	}

}
