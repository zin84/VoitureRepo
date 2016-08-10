package com.adaming.bookingvoiture.service.facture;

import java.util.List;

import com.adaming.bookingvoiture.entities.Facture;
import com.adaming.bookingvoiture.exceptions.ExceptionPerso;

public interface IFactureService {
	public Facture addFactureByReservation(Facture f, Long idReservation) throws ExceptionPerso;
	public List<Facture> getAllfactures();
	public Facture getInfosPrintFacture(Long idFacture,Long idReservation);
	public Double calculerCoutFacture(Long idReservation) throws ExceptionPerso;
	public Double calculCoutTotalByClient(Long idReservation,Long idClient, Long idvoiture) throws ExceptionPerso;
	public Double calculCoutTotalByVoiture(Long idReservation, Long idVoiture);
}
