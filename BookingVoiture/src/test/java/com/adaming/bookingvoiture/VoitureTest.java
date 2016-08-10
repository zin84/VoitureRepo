/*package com.adaming.bookingvoiture;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.bookingvoiture.entities.Reservation;
import com.adaming.bookingvoiture.entities.Voiture;
import com.adaming.bookingvoiture.exceptions.ExceptionDeleteVoiture;
import com.adaming.bookingvoiture.exceptions.ExceptionKilometrage;
import com.adaming.bookingvoiture.service.voiture.IVoitureService;

public class VoitureTest {

	private static IVoitureService serviceVoiture;
	private static ClassPathXmlApplicationContext context;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		serviceVoiture =   (IVoitureService) context.getBean("serviceVoiture");
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}
	
	
	@Test //ok
	public void testAddVoiture() {
		Voiture v=new Voiture("Citroen", "123MLK", 0D, 30, "Mini", "Diesel", "Neuf");
		serviceVoiture.addVoiture(v);
		Voiture v1=new Voiture("Renault", "123MLK", 0D, 30, "Espace", "Diesel", "Neuf");
		serviceVoiture.addVoiture(v1);
		Voiture v2=new Voiture("BMW", "123MLK", 0D, 60, "Luxe", "Diesel", "Neuf");
		serviceVoiture.addVoiture(v2);
		assertNotNull(v.getIdvoiture());
		
	}

	@Test //ok
	public void testGetVoitureById() {
		Voiture v=serviceVoiture.getVoitureById(1L);
		assertNotNull(v.getIdvoiture());
	}

	@Test //ok
	public void testGetVoitures() {
		List<Voiture> tabVoiture=serviceVoiture.getVoitures();
		assertTrue(tabVoiture.size()>1);
	}

	@Test //ok
	public void testDeleteVoiture() throws ExceptionDeleteVoiture {
		List<Voiture> tabVoiture=serviceVoiture.getVoitures();
		serviceVoiture.deleteVoiture(2L);
		List<Voiture> tabVoiture2=serviceVoiture.getVoitures();
		assertTrue(tabVoiture.size()>tabVoiture2.size());
	}

	@Test // ok
	public void testUpdateVoiture() {
		Voiture v1=serviceVoiture.getVoitureById(3L);
		v1.setKilometrage(100D);
		serviceVoiture.updateVoiture(v1);
		Voiture v2=serviceVoiture.getVoitureById(3L);
		assertTrue(v1.getKilometrage()!=v2.getKilometrage());
		
	}

	@Test //ok
	public void testVoitureDispoToday() {
		List<Voiture> tabDispoToday=serviceVoiture.voitureDispoToday();
		assertTrue(tabDispoToday.size()>0);
	}
	
	@Test //ok
	public void testVoitureDispoPeriode() throws ParseException, ExceptionDeleteVoiture {
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date madate1= sdf.parse("03/08/2016");
		Date madate2= sdf.parse("10/08/2016");
		List<Voiture> tabDispo=serviceVoiture.voitureDispoPeriode(madate1, madate2);
		assertTrue(tabDispo.size()>0);
	}

	@Test //ok
	public void testAlertEntretien() throws ExceptionKilometrage {
		double km=serviceVoiture.alertEntretien(3L);
		assertTrue(km>0);
	}

	
	@Test //ok
	public void testRetourVoiture() throws ParseException {
		
		List<Voiture> tabVoit=serviceVoiture.retourVoiture();
		System.out.println("------------------------>"+tabVoit.size());
		assertTrue(tabVoit.size()>0);
	}

}
*/