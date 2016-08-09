package com.adaming.bookingvoiture.test;
/* Classe : ClientTestU
 * Package : com.adaming.bookingvoiture.test
 * Author : Philippe
 * Date : 09/08/16
 * Version : 1.0.1 testAddClient, testGetClient, testGetClients, testUpdateClient OK
 */
import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.hamcrest.core.IsEqual;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.bookingvoiture.entities.Client;
import com.adaming.bookingvoiture.service.client.IClientService;

public class ClientTestU {

	/* attributs */
	private static IClientService service;
	private static ClassPathXmlApplicationContext context;
	
	/* initialisation des attributs */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		service = (IClientService) context.getBean("clientService");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	/* tests */
	/* Test OK */
	@Ignore
	@Test
	public void testAddClient() {
		Client client1 = new Client("nomClient1", "prenomClient1", new Date(), "numeroTelClient1", "numeroPermisClient1", "adressPostalClient1", "mailClient1", "paysClient1", new Date(), "lieuDeNaissanceClient1", "delivrerPar1");
		Client client2 = new Client("nomClient2", "prenomClient2", new Date(), "numeroTelClient2", "numeroPermisClient2", "adressPostalClient2", "mailClient2", "paysClient2", new Date(), "lieuDeNaissanceClient2", "delivrerPar2");
		Client client3 = new Client("nomClient3", "prenomClient3", new Date(), "numeroTelClient3", "numeroPermisClient3", "adressPostalClient3", "mailClient3", "paysClient3", new Date(), "lieuDeNaissanceClient3", "delivrerPar3");
		Client client4 = new Client("nomClient4", "prenomClient4", new Date(), "numeroTelClient4", "numeroPermisClient4", "adressPostalClient4", "mailClient4", "paysClient4", new Date(), "lieuDeNaissanceClient4", "delivrerPar4");
		Client client5 = new Client("nomClient5", "prenomClient5", new Date(), "numeroTelClient5", "numeroPermisClient5", "adressPostalClient5", "mailClient5", "paysClient5", new Date(), "lieuDeNaissanceClient5", "delivrerPar5");
		Client client6 = new Client("nomClient6", "prenomClient6", new Date(), "numeroTelClient6", "numeroPermisClient6", "adressPostalClient6", "mailClient6", "paysClient6", new Date(), "lieuDeNaissanceClient6", "delivrerPar6");
		Client client7 = new Client("nomClient7", "prenomClient7", new Date(), "numeroTelClient7", "numeroPermisClient7", "adressPostalClient7", "mailClient7", "paysClient7", new Date(), "lieuDeNaissanceClient7", "delivrerPar7");
		Client client8 = new Client("nomClient8", "prenomClient8", new Date(), "numeroTelClient8", "numeroPermisClient8", "adressPostalClient8", "mailClient8", "paysClient8", new Date(), "lieuDeNaissanceClient8", "delivrerPar8");
		Client client9 = new Client("nomClient9", "prenomClient9", new Date(), "numeroTelClient9", "numeroPermisClient9", "adressPostalClient9", "mailClient9", "paysClient9", new Date(), "lieuDeNaissanceClient9", "delivrerPar9");
		service.addClient(client1);
		service.addClient(client2);
		service.addClient(client3);
		service.addClient(client4);
		service.addClient(client5);
		service.addClient(client6);
		service.addClient(client7);
		service.addClient(client8);
		service.addClient(client9);
		assertNotNull(client1.getIdClient());
		assertNotNull(client2.getIdClient());
		assertNotNull(client3.getIdClient());
		assertNotNull(client4.getIdClient());
		assertNotNull(client5.getIdClient());
		assertNotNull(client6.getIdClient());
		assertNotNull(client7.getIdClient());
		assertNotNull(client8.getIdClient());
		assertNotNull(client9.getIdClient());
	}
	
	/* Test OK sans toString */
	@Ignore
	@Test
	public void testGetClient(){
		Client client1 = service.getClient(1L);
		assertNotNull(client1.getIdClient());
	}
	
	/* Test OK */
	@Ignore
	@Test
	public void testGetClients() throws Exception{
		List<Client> clients = service.getClients();
		assertNotNull(clients.size()>0);
	}
	
	/* Test OK sans toString */
	@Ignore
	@Test
	public void testUpdateClient(){
		Client client1 = service.getClient(1L);
		client1.setNomClient("nomClientModifie1");
		service.updateClient(client1);
		Client client2 = service.getClient(1L);
		assertThat("nomClientModifie1", IsEqual.equalTo(client2.getNomClient()));
		
	}

}
