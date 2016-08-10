/*package com.adaming.bookingvoiture;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.bookingvoiture.entities.Facture;
import com.adaming.bookingvoiture.exceptions.ExceptionPerso;
import com.adaming.bookingvoiture.service.facture.IFactureService;

public class FactureTestUI {
	private static IFactureService metier;
	private static ClassPathXmlApplicationContext context;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		metier = (IFactureService) context.getBean("serviceFacture");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}
	@Test
	public void testAddFactureByReservation() throws ExceptionPerso {
		Facture f = new Facture(new Date());
		metier.addFactureByReservation(f, 2L);
		
	}

	@Test
	public void testGetAllfactures() {
		metier.getAllfactures();
	}

	@Test
	public void testCalculerCoutFacture() throws ExceptionPerso {
	double coutFacture=metier.calculerCoutFacture(1L);
	}

	/*@Test
	public void testCalculCoutTotalByClient() throws ExceptionPerso {
		double cout = metier.calculCoutTotalByClient(1L, 1L, 1L);
	}

	@Test
	public void testCalculCoutTotalByVoiture() {
		double cout = metier.calculCoutTotalByVoiture(1L, 1L);
	}

	@Test
	public void testGetInfosPrintFacture() {
		metier.getInfosPrintFacture(1L, 1L);
	}

}
*/