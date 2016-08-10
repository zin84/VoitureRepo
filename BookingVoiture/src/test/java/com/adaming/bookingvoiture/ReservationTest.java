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
import com.adaming.bookingvoiture.exceptions.ExceptionDeleteRes;
import com.adaming.bookingvoiture.exceptions.ExceptionResDispo;
import com.adaming.bookingvoiture.service.reservation.IReservationService;
import com.adaming.bookingvoiture.service.voiture.IVoitureService;

public class ReservationTest {

	
	private static IReservationService serviceReservation;
	private static ClassPathXmlApplicationContext context;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		serviceReservation =   (IReservationService) context.getBean("serviceReservation");
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}
	@Test  //ok
	public void testAddreservation() throws ParseException, ExceptionResDispo {
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date madate1= sdf.parse("05/08/2016");
		Date madate2= sdf.parse("09/08/2016");
		Reservation r=new Reservation(new Date(), madate1, madate2, "08h00", "14h00", 5, "Neuf");
		serviceReservation.addreservation(r, 1L, 1L);
		assertNotNull(r.getIdReservation());
	}

	@Test //ok
	public void testUpdateReservation() throws ParseException, ExceptionResDispo {
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date madate1= sdf.parse("05/08/2016");
		Reservation res=serviceReservation.getResById(3L);
		res.setDateDeRentrer(madate1);
		serviceReservation.updateReservation(res);
		Reservation res1=serviceReservation.getResById(3L);
		assertTrue(res.getDateDeRentrer()!=res1.getDateDeRentrer());
	}

	@Test //ok
	public void testGetResById() {
		Reservation res=serviceReservation.getResById(1L);
		assertNotNull(res.getIdReservation());
	}

	@Test //ok
	public void testGetRes() {
		List<Reservation> tabRes=serviceReservation.getRes();
		assertTrue(tabRes.size()>0);
	}

	@Test //ok
	public void testGetHistoriqueReservation() {
		List<Reservation> tabHistRes=serviceReservation.getHistoriqueReservation();
		assertTrue(tabHistRes.size()>0);
	}
	
	@Test //ok
	public void testDeleteReservation() throws ExceptionDeleteRes {
		List<Reservation> tabRes=serviceReservation.getRes();
		serviceReservation.deleteReservation(1L);
		List<Reservation> tabRes1=serviceReservation.getRes();
		assertTrue(tabRes.size()>tabRes1.size());
	}

}
*/