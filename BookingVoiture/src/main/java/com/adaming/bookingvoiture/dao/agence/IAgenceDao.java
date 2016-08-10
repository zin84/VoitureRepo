package com.adaming.bookingvoiture.dao.agence;
/* Classe : IAgenceDao
 * Package : com.adaming.bookingvoiture.dao.agence
 * Author : Philippe
 * Date : 09/08/16
 * Version : 1.0.1
 */
import java.util.List;


import com.adaming.bookingvoiture.entities.Agence;

public interface IAgenceDao {
	/* methodes implementees dans AgenceDaoImpl */
	public Agence addAgence(Agence agence);
	public Agence getAgence(Long idAgence);
	public List<Agence> getAgences() throws Exception;
	public Agence updateAgence(Agence agence);
	
	public Agence addFactureToAgence(Long idAgence, Long idFacture) throws Exception;
}
