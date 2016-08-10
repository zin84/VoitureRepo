package com.adaming.bookingvoiture.service.facture;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.bookingvoiture.dao.facture.IFactureDao;
import com.adaming.bookingvoiture.entities.Facture;
import com.adaming.bookingvoiture.exceptions.ExceptionPerso;
@Transactional
public class FactureServiceImpl implements IFactureService {
@Autowired
	private IFactureDao daoFacture;
Logger log = Logger.getLogger("FactureServiceImpl");

public void setDaoFacture(IFactureDao daoFacture) {
	log.info("--------daoFacture injected----------");
	this.daoFacture = daoFacture;
}

@Override
public Facture addFactureByReservation(Facture f, Long idReservation)
		throws ExceptionPerso {
	return daoFacture.addFactureByReservation(f, idReservation);
}

@Override
public List<Facture> getAllfactures() {
	return daoFacture.getAllfactures();
}

@Override
public Double calculerCoutFacture(Long idReservation)
		throws ExceptionPerso {
	return daoFacture.calculerCoutFacture(idReservation);
}

@Override
public Double calculCoutTotalByClient(Long idReservation, Long idClient,
		Long idvoiture) throws ExceptionPerso {
	return daoFacture.calculCoutTotalByClient(idReservation, idClient, idvoiture);
}

@Override
public Double calculCoutTotalByVoiture(Long idReservation, Long idVoiture) {
	return daoFacture.calculCoutTotalByVoiture(idReservation, idVoiture);
}

@Override
public Facture getInfosPrintFacture(Long idFacture, Long idReservation) {
	return daoFacture.getInfosPrintFacture(idFacture, idReservation);
}



}
