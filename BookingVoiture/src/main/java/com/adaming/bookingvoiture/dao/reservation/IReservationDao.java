package com.adaming.bookingvoiture.dao.reservation;

import java.util.List;

import com.adaming.bookingvoiture.entities.Reservation;
import com.adaming.bookingvoiture.exceptions.ExceptionDeleteRes;
import com.adaming.bookingvoiture.exceptions.ExceptionResDispo;

public interface IReservationDao {

	public Reservation addreservation(Reservation r, Long idClient, Long idVoiture) throws ExceptionResDispo;
	public Reservation updateReservation(Reservation r) throws ExceptionResDispo;
	public Reservation deleteReservation(Long idReservation) throws ExceptionDeleteRes;
	public Reservation getResById(Long idReservation);
	public List<Reservation> getRes();
	public List<Reservation> getHistoriqueReservation();
}
