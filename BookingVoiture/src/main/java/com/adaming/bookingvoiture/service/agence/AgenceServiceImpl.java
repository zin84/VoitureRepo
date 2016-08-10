package com.adaming.bookingvoiture.service.agence;

/* Classe : AgenceServiceImpl
 * Package : com.adaming.bookingvoiture.service.agence
 * Author : Philippe
 * Date : 09/08/16
 * Version : 1.0.1
 */
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.bookingvoiture.dao.agence.IAgenceDao;
import com.adaming.bookingvoiture.entities.Agence;

//@Service
@Transactional
public class AgenceServiceImpl implements IAgenceService {
	
	/* attributs */
	Logger log = Logger.getLogger("AgenceServiceImpl");
	
	@Autowired
	private IAgenceDao daoAgence;
	
	/* DI DAO */
	public void setDaoAgence(IAgenceDao daoAgence){
		log.info("-----DAO AGENCE INJECTEE-----");
		this.daoAgence = daoAgence;
		
	}

	/* implementation des methodes de IAgenceService */
	@Override
	public Agence addAgence(Agence agence) {
		return daoAgence.addAgence(agence);
	}

	@Override
	public Agence getAgence(Long idAgence) {
		return daoAgence.getAgence(idAgence);
	}

	@Override
	public List<Agence> getAgences() throws Exception {
		return daoAgence.getAgences();
	}

	@Override
	public Agence updateAgence(Agence agence) {
		return daoAgence.updateAgence(agence);
	}

	@Override
	public Agence addFactureToAgence(Long idAgence, Long idFacture) throws Exception {
		return daoAgence.addFactureToAgence(idAgence, idFacture);
	}
}
