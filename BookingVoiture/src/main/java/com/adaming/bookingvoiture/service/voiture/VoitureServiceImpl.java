package com.adaming.bookingvoiture.service.voiture;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.bookingvoiture.dao.voiture.IVoitureDao;
import com.adaming.bookingvoiture.entities.Voiture;
import com.adaming.bookingvoiture.exceptions.ExceptionDeleteVoiture;
import com.adaming.bookingvoiture.exceptions.ExceptionDispoVoiture;
import com.adaming.bookingvoiture.exceptions.ExceptionKilometrage;

@Transactional
public class VoitureServiceImpl implements IVoitureService {

	Logger log=Logger.getLogger("VoitureServiceImpl");
	
	@Autowired
	private IVoitureDao daoVoiture;


	public void setDaoVoiture(IVoitureDao daoVoiture) {
		this.daoVoiture = daoVoiture;
		log.info("<--------------daoVoiture Injected-------------->");
		
	}

	@Override
	public Voiture addVoiture(Voiture v) {
		// TODO Auto-generated method stub
		return daoVoiture.addVoiture(v);
	}

	@Override
	public Voiture getVoitureById(Long idVoiture) {
		// TODO Auto-generated method stub
		return daoVoiture.getVoitureById(idVoiture);
	}

	@Override
	public List<Voiture> getVoitures() {
		// TODO Auto-generated method stub
		return daoVoiture.getVoitures();
	}

	@Override
	public Voiture deleteVoiture(Long idVoiture) throws ExceptionDeleteVoiture {
		// TODO Auto-generated method stub
		return daoVoiture.deleteVoiture(idVoiture);
	}

	@Override
	public Voiture updateVoiture(Voiture v) {
		// TODO Auto-generated method stub
		return daoVoiture.updateVoiture(v);
	}

	@Override
	public List<Voiture> voitureDispoToday() throws ExceptionDispoVoiture {
		// TODO Auto-generated method stub
		return daoVoiture.voitureDispoToday();
	}

	@Override
	public List<Voiture> voitureDispoPeriode(Date dateDebut, Date dateFin) throws ExceptionDeleteVoiture {
		// TODO Auto-generated method stub
		return daoVoiture.voitureDispoPeriode(dateDebut, dateFin);
	}

	@Override
	public double alertEntretien(Long idVoiture) throws ExceptionKilometrage {
		// TODO Auto-generated method stub
		return daoVoiture.alertEntretien(idVoiture);
	}

	@Override
	public List<Voiture> retourVoiture() throws ParseException {
		// TODO Auto-generated method stub
		return daoVoiture.retourVoiture();
	}
}
