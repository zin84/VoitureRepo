package com.adaming.bookingvoiture.dao.voiture;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.adaming.bookingvoiture.entities.Voiture;
import com.adaming.bookingvoiture.exceptions.ExceptionDeleteVoiture;
import com.adaming.bookingvoiture.exceptions.ExceptionDispoVoiture;
import com.adaming.bookingvoiture.exceptions.ExceptionKilometrage;

public interface IVoitureDao {

	public Voiture addVoiture(Voiture v);
	public Voiture getVoitureById(Long idVoiture);
	public List<Voiture> getVoitures();
	public Voiture deleteVoiture(Long idVoiture) throws ExceptionDeleteVoiture;
	public Voiture updateVoiture(Voiture v);
	public List<Voiture> voitureDispoToday() throws ExceptionDispoVoiture;
	public List<Voiture> voitureDispoPeriode(Date dateDebut, Date dateFin) throws ExceptionDeleteVoiture;
	public double alertEntretien(Long idVoiture) throws ExceptionKilometrage;
	public List<Voiture> retourVoiture() throws ParseException;
}