package com.adaming.bookingvoiture.dao.client;
/* Classe : IClientDao
 * Package : com.adaming.bookingvoiture.dao.client
 * Author : Philippe
 * Date : 09/08/16
 * Version : 1.0.1
 */

import java.util.List;

import com.adaming.bookingvoiture.entities.Client;

public interface IClientDao {
	/* methodes implementees dans ClientDaoImpl */
	public Client addClient(Client client);
	public Client getClient(Long idClient);
	public List<Client> getClients() throws Exception;
	public Client updateClient(Client client);
}
