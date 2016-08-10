package com.adaming.bookingvoiture.service.reservation;

import java.util.List;

import com.adaming.bookingvoiture.entities.Reservation;
import com.adaming.bookingvoiture.exceptions.ExceptionDeleteRes;
import com.adaming.bookingvoiture.exceptions.ExceptionResDispo;

public interface IReservationService {


	public Reservation addreservation(Reservation r, Long idClient, Long idVoiture) throws ExceptionResDispo;
	public Reservation updateReservation(Reservation r) throws ExceptionResDispo;
	public Reservation getResById(Long idReservation);
	public List<Reservation> getRes();
	public List<Reservation> getHistoriqueReservation();
	public Reservation deleteReservation(Long idReservation) throws ExceptionDeleteRes;
}
