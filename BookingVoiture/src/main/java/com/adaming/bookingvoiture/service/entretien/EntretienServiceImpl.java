package com.adaming.bookingvoiture.service.entretien;
/*
 * Classe:EntretienServiceImpl
 * Package:com.adaming.bookingvoiture.service.entretien
 * Version: 1.0.0
 * Date: 09/08/2016
 * Author: Romain Ganet
 * */

import java.util.List;
import java.util.logging.Logger;
import org.springframework.transaction.annotation.Transactional;
import com.adaming.bookingvoiture.dao.entretien.IEntretienDao;
import com.adaming.bookingvoiture.entities.Entretien;
import com.adaming.bookingvoiture.exceptions.ObjetInexistantException;



@Transactional
public class EntretienServiceImpl implements IEntretienService{
	
Logger log = Logger.getLogger("EntretienServiceImpl");


	private IEntretienDao daoEntretien;
	

public void setDaoEntretien(IEntretienDao daoEntretien) {
	log.info("-----DAO AGENCE INJECTEE-----");
		this.daoEntretien = daoEntretien;
	}

@Override
public Entretien addEntretien(Entretien e, Long idVoiture)
		throws ObjetInexistantException {
	// TODO Auto-generated method stub
	return daoEntretien.addEntretien(e, idVoiture);
}

@Override
public Entretien deleteEntretien(Long idEntretient)
		throws ObjetInexistantException {
	// TODO Auto-generated method stub
	return daoEntretien.deleteEntretien(idEntretient);
}

@Override
public Entretien updateEntretien(Entretien e) {
	// TODO Auto-generated method stub
	return daoEntretien.updateEntretien(e);
}

@Override
public List<Entretien> getListEntretien() throws ObjetInexistantException {
	// TODO Auto-generated method stub
	return daoEntretien.getListEntretien();
}

@Override
public Entretien getEntretien(Long idEntretient) throws ObjetInexistantException {
	// TODO Auto-generated method stub
	return daoEntretien.getEntretien(idEntretient);
}


@Override
public List<Entretien> getListVidange() throws ObjetInexistantException {
	// TODO Auto-generated method stub
	return daoEntretien.getListVidange();
}

@Override
public List<Entretien> getListChaineDistribution() throws ObjetInexistantException {
	// TODO Auto-generated method stub
	return daoEntretien.getListChaineDistribution();
}

@Override
public List<Entretien> getListFiltreHuile() throws ObjetInexistantException {
	// TODO Auto-generated method stub
	return daoEntretien.getListFiltreHuile();
}







}
