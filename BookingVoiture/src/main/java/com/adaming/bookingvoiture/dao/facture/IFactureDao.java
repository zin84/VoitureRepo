package com.adaming.bookingvoiture.dao.facture;

import java.util.List;







import com.adaming.bookingvoiture.entities.Facture;
import com.adaming.bookingvoiture.exceptions.ExceptionPerso;


public interface IFactureDao {

public Facture addFactureByReservation(Facture f, Long idReservation) throws ExceptionPerso;
public List<Facture> getAllfactures();
public Facture getInfosPrintFacture(Long idFacture,Long idReservation);
public Double calculerCoutFacture(Long idReservation) throws ExceptionPerso;
public Double calculCoutTotalByClient(Long idReservation,Long idClient, Long idVoiture) throws ExceptionPerso;
public Double calculCoutTotalByVoiture(Long idReservation, Long idVoiture);

}
