package com.adaming.bookingvoiture.service.client;
/* Classe : IClientService
 * Package : com.adaming.bookingvoiture.service.client
 * Author : Philippe
 * Date : 09/08/16
 * Version : 1.0.1
 */
import java.util.List;

import com.adaming.bookingvoiture.entities.Client;

public interface IClientService {
	/* methodes implementees dans ClientServiceImpl */
	public Client addClient(Client client);
	public Client getClient(Long idClient);
	public List<Client> getClients() throws Exception;
	public Client updateClient(Client client);
}
