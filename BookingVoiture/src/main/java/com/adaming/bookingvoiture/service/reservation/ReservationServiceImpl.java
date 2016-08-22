package com.adaming.bookingvoiture.service.reservation;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.bookingvoiture.dao.reservation.IReservationDao;
import com.adaming.bookingvoiture.entities.Reservation;
import com.adaming.bookingvoiture.exceptions.ExceptionDeleteRes;
import com.adaming.bookingvoiture.exceptions.ExceptionResDispo;


@Transactional
public class ReservationServiceImpl implements IReservationService {
	
	Logger log=Logger.getLogger("VoitureServiceImpl");
	
	@Autowired
	private IReservationDao daoReservation;

	public void setDaoReservation(IReservationDao daoReservation) {
		this.daoReservation = daoReservation;
		log.info("<----------------daoReservation Injected---------------->");
	}

	@Override
	public Reservation addreservation(Reservation r, Long idClient,
			Long idVoiture) throws ExceptionResDispo {
		// TODO Auto-generated method stub
		return daoReservation.addreservation(r, idClient, idVoiture);
	}

	@Override
	public Reservation updateReservation(Reservation r)
			throws ExceptionResDispo {
		// TODO Auto-generated method stub
		return daoReservation.updateReservation(r);
	}

	@Override
	public Reservation getResById(Long idReservation) {
		// TODO Auto-generated method stub
		return daoReservation.getResById(idReservation);
	}

	@Override
	public List<Reservation> getRes() {
		// TODO Auto-generated method stub
		return daoReservation.getRes();
	}

	@Override
	public List<Reservation> getHistoriqueReservation() {
		// TODO Auto-generated method stub
		return daoReservation.getHistoriqueReservation();
	}

	@Override
	public Reservation deleteReservation(Long idReservation)
			throws ExceptionDeleteRes {
		return daoReservation.deleteReservation(idReservation);
	}
}
