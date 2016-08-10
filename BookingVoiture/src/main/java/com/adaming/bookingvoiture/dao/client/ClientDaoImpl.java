package com.adaming.bookingvoiture.dao.client;
/* Classe : ClientDaoImpl
 * Package : com.adaming.bookingvoiture.dao.client
 * Author : Philippe
 * Date : 09/08/16
 * Version : 1.0.1
 */
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.adaming.bookingvoiture.entities.Client;
import com.adaming.bookingvoiture.exceptions.ExceptionGetClients;

public class ClientDaoImpl implements IClientDao {
	
	/* attributs */
	Logger log = Logger.getLogger("ClientDaoImpl");
	
	@PersistenceContext
	private EntityManager em;
	
	/* implementation des methodes de IClientDao */
	@Override
	public Client addClient(Client client) {
		em.persist(client);
		log.info("-----addClient-----"+client.toString());
		return client;
	}

	@Override
	public Client getClient(Long idClient) {
		Client client = em.find(Client.class, idClient);
		log.info("-----getClient-----"+client.toString());
		return client;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> getClients() throws Exception {
		Query query = em.createQuery("from Client");
		if(query.getResultList().size() == 0){
			throw new ExceptionGetClients("pas de clients");
		}
		log.info("-----getClients (size)-----"+query.getResultList().size());
		return query.getResultList();
	}

	@Override
	public Client updateClient(Client client) {
		em.merge(client);
		log.info("-----updateClient-----"+client.toString());
		return client;
	}

}
