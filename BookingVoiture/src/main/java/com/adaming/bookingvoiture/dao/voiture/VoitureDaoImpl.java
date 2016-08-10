package com.adaming.bookingvoiture.dao.voiture;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.adaming.bookingvoiture.entities.Entretien;
import com.adaming.bookingvoiture.entities.Reservation;
import com.adaming.bookingvoiture.entities.Voiture;
import com.adaming.bookingvoiture.exceptions.ExceptionDeleteVoiture;
import com.adaming.bookingvoiture.exceptions.ExceptionDispoVoiture;
import com.adaming.bookingvoiture.exceptions.ExceptionKilometrage;


public class VoitureDaoImpl implements IVoitureDao{

	Logger log=Logger.getLogger("VoitureDaoImpl");
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Voiture addVoiture(Voiture v) {
		em.persist(v);
		log.info("La voiture "+v.getImmatricule()+" a bien été enregistrée");
		return v;
	}

	@Override
	public Voiture getVoitureById(Long idVoiture) {
		Voiture v=em.find(Voiture.class, idVoiture);
		log.info("La voiture "+v.getIdvoiture()+" a bien été récupérée");
		return v;
	}

	@Override
	public List<Voiture> getVoitures() {
		Query query=em.createQuery("from Voiture");
		log.info("Il existe "+query.getResultList().size()+" voitures");
		return query.getResultList();
	}

	@Override
	public Voiture deleteVoiture(Long idVoiture) throws ExceptionDeleteVoiture {
		Voiture v=em.find(Voiture.class, idVoiture);
		List<Reservation> tabResVoit=new ArrayList<Reservation>();
		for(Reservation r:tabResVoit){
			if(tabResVoit.isEmpty()==false){
				throw new ExceptionDeleteVoiture("Cette voiture a des reservations enregistrées");
			}
		}
		em.remove(v);
		return v;
	}

	@Override
	public Voiture updateVoiture(Voiture v) {
		em.merge(v);
		return v;
	}

	@Override
	public List<Voiture> voitureDispoToday() throws ExceptionDispoVoiture {
		Date maDate=new Date();
		List<Voiture> tabVoiture=getVoitures();
		List<Voiture> tabVoitureDispo=getVoitures();
		for(Voiture v:tabVoiture){
			List<Reservation> tabResVoit=v.getTabReservationVoiture();
			for(Reservation r:tabResVoit){
				if(r.getDateDeRentrer().before(maDate) && r.getDateDeSortie().after(maDate)){
					tabVoitureDispo.remove(v);
				}	
			}
		}
		log.info("Il y a "+tabVoitureDispo.size()+" voitures disponibles aujourd'hui");
		if(tabVoitureDispo.size()==0){
			throw new ExceptionDispoVoiture("Aucune voiture n'est disponible aujourd'hui");
		}
		return tabVoitureDispo;
	}

	@Override
	public List<Voiture> voitureDispoPeriode(Date dateDebut, Date dateFin) throws ExceptionDeleteVoiture {
		List<Voiture> tabVoiture=getVoitures();
		List<Voiture> tabVoitureDispo=getVoitures();
		for(Voiture v:tabVoiture){
			List<Reservation> tabResVoit=v.getTabReservationVoiture();
			for(Reservation r:tabResVoit){
				if((r.getDateDeRentrer().before(dateDebut) && r.getDateDeSortie().after(dateFin))
						|| (r.getDateDeRentrer().after(dateDebut) && r.getDateDeSortie().before(dateFin))
						|| (r.getDateDeRentrer().before(dateFin) && r.getDateDeSortie().after(dateFin))
						|| (r.getDateDeRentrer().before(dateDebut) && r.getDateDeSortie().after(dateDebut))
						|| (r.getDateDeRentrer().equals(dateDebut))
						|| (r.getDateDeSortie().equals(dateFin))
						|| (r.getDateDeSortie().equals(dateDebut))){
					tabVoitureDispo.remove(v);
				}	
			}
		}if(tabVoitureDispo.size()==0){
			throw new ExceptionDeleteVoiture("Aucune voiture n'est disponible pour cette période");
		}
		return tabVoitureDispo;
	}

	@Override
	public double alertEntretien(Long idVoiture) throws ExceptionKilometrage {
		Voiture v=em.find(Voiture.class, idVoiture);
		double kmRestant=0;
		List<Entretien> tabEntretien=v.getTabEntretienVoit();
			for(Entretien e:tabEntretien){
				System.out.println("--------->"+tabEntretien.size());
				kmRestant=e.getKilommetrage()-v.getKilometrage();
		}if(kmRestant<0){
			throw new ExceptionKilometrage("Un entretien de la voiture"+v.getImmatricule()+ "doit être réalisé !");
		}
		log.info("Prochain entretien dans "+kmRestant+" km");
		return kmRestant;
	}

	@Override
	public List<Voiture> retourVoiture() throws ParseException {
		List<Voiture> tabVoiture=getVoitures();
		List<Voiture> tabVoitureRetour=new ArrayList<Voiture>();
		Calendar calendar= Calendar.getInstance();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		 Date date = new Date();
	     calendar.setTime(new Date());
	     int year  = calendar.get(Calendar.YEAR);
	     int month= calendar.get(Calendar.MONTH) +1;
	     int day= calendar.get(Calendar.DAY_OF_MONTH);
	     Date maDate=sdf.parse(day+"/"+month+"/"+year);
		for(Voiture v:tabVoiture){
		List<Reservation> tabResVoit=v.getTabReservationVoiture();
		for(Reservation r:tabResVoit){
			if(r.getDateDeSortie().equals(maDate)){
				tabVoitureRetour.add(v);
			}
		}
		}
		return tabVoitureRetour;
	}

}
