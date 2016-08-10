/*package com.adaming.bookingvoiture;
import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.adaming.bookingvoiture.entities.ChaineDistribution;
import com.adaming.bookingvoiture.entities.Entretien;
import com.adaming.bookingvoiture.entities.FiltreHuile;
import com.adaming.bookingvoiture.entities.Vidange;
import com.adaming.bookingvoiture.exceptions.ObjetInexistantException;
import com.adaming.bookingvoiture.service.entretien.IEntretienService;

 * Classe:EntretienServiceTestU
 * Package:(default package)
 * Version: 1.0.0
 * Date: 09/08/2016
 * Author: Romain Ganet
 * 

public class EntretienServiceTestU {
	
	private static ClassPathXmlApplicationContext context;
	private static IEntretienService service;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		service = (IEntretienService) context.getBean("serviceEntretien");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testAddEntretien() throws ObjetInexistantException {
		Entretien e1 = new FiltreHuile("typeEntretient1", new Date(), 5000d, 100);
		Entretien e2 = new Vidange("typeEntretient2", new Date(), 7000d, 150);
		Entretien e3 = new ChaineDistribution("typeEntretient3", new Date(), 9500d, 200);
		Entretien e4 = new FiltreHuile("typeEntretient4", new Date(), 6000d, 100);
		Entretien e5 = new Vidange("typeEntretient5", new Date(), 8000d, 150);
		Entretien e6 = new ChaineDistribution("typeEntretient6", new Date(), 11000d, 200);
		service.addEntretien(e1, 1L);
		service.addEntretien(e2, 2L);
		service.addEntretien(e3, 3L);
		service.addEntretien(e4, 4L);
		service.addEntretien(e5, 5L);
		service.addEntretien(e6, 6L);
		assertNotNull(e1.getIdEntretient());
	}

	@Test
	public void testDeleteEntretien() throws ObjetInexistantException {
		Entretien e7 = service.getEntretien(6L);
		service.deleteEntretien(6L);
		assertNull(e7.getIdEntretient());
	}

	@Test
	public void testUpdateEntretien() throws ObjetInexistantException {
		Entretien einit = service.getEntretien(1L);
		Entretien efin = service.getEntretien(1L);
		efin.setPrixEntrtient(125);
		service.updateEntretien(efin);
		assertNotSame(einit.getPrixEntrtient(), efin.getPrixEntrtient());
	}

	@Test
	public void testGetListEntretien() {
		List<Entretien> entretiens = service.getListEntretien();
		assertTrue(entretiens.size()>0);
	}

	@Test
	public void testGetEntretien() throws ObjetInexistantException {
		Entretien e8 = service.getEntretien(1L);
		assertNotNull(e8.getIdEntretient());
	}

	@Test
	public void testGetListVidange() throws ObjetInexistantException {
		List<Entretien> vidanges = service.getListVidange();
		assertTrue(vidanges.size()>0);
	}
	
	@Test
	public void testGetListChaineDistribution() throws ObjetInexistantException {
		List<Entretien> chaineDistributions = service.getListChaineDistribution();
		assertTrue(chaineDistributions.size()>0);
	}
	
	@Test
	public void testGetListFiltreHuile() throws ObjetInexistantException {
		List<Entretien> filtreHuiles = service.getListFiltreHuile();
		assertTrue(filtreHuiles.size()>0);
	}
}
*/