package com.adaming.bookingvoiture.service.client;
/* Classe : ClientServiceImpl
 * Package : com.adaming.bookingvoiture.service.client
 * Author : Philippe
 * Date : 09/08/16
 * Version : 1.0.1
 */
import java.util.List;

import org.apache.log4j.Logger;
/* Classe : ClientServiceImpl
 * Package : com.adaming.bookingvoiture.service.client
 * Author : Philippe
 * Date : 09/08/16
 * Version : 1.0.1
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.bookingvoiture.dao.client.IClientDao;
import com.adaming.bookingvoiture.entities.Client;

//@Service
@Transactional
public class ClientServiceImpl implements IClientService {
	/* attributs */
	Logger log = Logger.getLogger("ClientServiceImpl");
	
	@Autowired
	private IClientDao daoClient;
	
	/* DI DAO */
	
	public void setDaoClient(IClientDao daoClient) {
		log.info("-----DAO CLIENT INJECTEE-----");
		this.daoClient = daoClient;
	}

	

	/* implementation des methodes de IClientService */
	@Override
	public Client addClient(Client client) {
		return daoClient.addClient(client);
	}

	@Override
	public Client getClient(Long idClient) {
		return daoClient.getClient(idClient);
	}

	@Override
	public List<Client> getClients() throws Exception {
		return daoClient.getClients();
	}

	@Override
	public Client updateClient(Client client) {
		return daoClient.updateClient(client);
	}
}
