/*package com.adaming.bookingvoiture;

 Classe : AgenceTestU
 * Package : com.adaming.bookingvoiture.test
 * Author : Philippe
 * Date : 09/08/16
 * Version : 1.0.1
 
import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hamcrest.core.IsEqual;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.bookingvoiture.entities.Agence;
import com.adaming.bookingvoiture.entities.Facture;
import com.adaming.bookingvoiture.service.agence.IAgenceService;

public class AgenceTestU {
	 attributs 
	Logger log = Logger.getLogger("AgenceTestU");
	
	private static IAgenceService service;
	private static ClassPathXmlApplicationContext context;
	
	 initialisation des attributs 
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		service = (IAgenceService) context.getBean("agenceService");
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	 tests 
	 Test OK 
	@Ignore
	@Test
	public void testAddAgence() {
		Agence agence1 = new Agence("nom1", "prenom1", new Date(), "addrespostal1", "numerotel1", "adressMail1", "numeroDimatricule1", "denomination1", "formJuridique1", "activite1", "adressSiege1", new Date(), "ville1", "douxiemTel1", 1.0, "choixMonnais1");
		Agence agence2 = new Agence("nom2", "prenom2", new Date(), "addrespostal2", "numerotel2", "adressMail2", "numeroDimatricule2", "denomination2", "formJuridique2", "activite2", "adressSiege2", new Date(), "ville2", "douxiemTel2", 2.0, "choixMonnais2");
		Agence agence3 = new Agence("nom3", "prenom3", new Date(), "addrespostal3", "numerotel3", "adressMail3", "numeroDimatricule3", "denomination3", "formJuridique3", "activite3", "adressSiege3", new Date(), "ville3", "douxiemTel3", 3.0, "choixMonnais3");
		Agence agence4 = new Agence("nom4", "prenom4", new Date(), "addrespostal4", "numerotel4", "adressMail4", "numeroDimatricule4", "denomination4", "formJuridique4", "activite4", "adressSiege4", new Date(), "ville4", "douxiemTel4", 4.0, "choixMonnais4");
		Agence agence5 = new Agence("nom5", "prenom5", new Date(), "addrespostal5", "numerotel5", "adressMail5", "numeroDimatricule5", "denomination5", "formJuridique5", "activite5", "adressSiege5", new Date(), "ville5", "douxiemTel5", 5.0, "choixMonnais5");
		Agence agence6 = new Agence("nom6", "prenom6", new Date(), "addrespostal6", "numerotel6", "adressMail6", "numeroDimatricule6", "denomination6", "formJuridique6", "activite6", "adressSiege6", new Date(), "ville6", "douxiemTel6", 6.0, "choixMonnais6");
		Agence agence7 = new Agence("nom7", "prenom7", new Date(), "addrespostal7", "numerotel7", "adressMail7", "numeroDimatricule7", "denomination7", "formJuridique7", "activite7", "adressSiege7", new Date(), "ville7", "douxiemTel7", 7.0, "choixMonnais7");
		Agence agence8 = new Agence("nom8", "prenom8", new Date(), "addrespostal8", "numerotel8", "adressMail8", "numeroDimatricule8", "denomination8", "formJuridique8", "activite8", "adressSiege8", new Date(), "ville8", "douxiemTel8", 8.0, "choixMonnais8");
		Agence agence9 = new Agence("nom9", "prenom9", new Date(), "addrespostal9", "numerotel9", "adressMail9", "numeroDimatricule9", "denomination9", "formJuridique9", "activite9", "adressSiege9", new Date(), "ville9", "douxiemTel9", 9.0, "choixMonnais9");
		service.addAgence(agence1);
		service.addAgence(agence2);
		service.addAgence(agence3);
		service.addAgence(agence4);
		service.addAgence(agence5);
		service.addAgence(agence6);
		service.addAgence(agence7);
		service.addAgence(agence8);
		service.addAgence(agence9);
		assertNotNull(agence1.getIdAgence());
		assertNotNull(agence2.getIdAgence());
		assertNotNull(agence3.getIdAgence());
		assertNotNull(agence4.getIdAgence());
		assertNotNull(agence5.getIdAgence());
		assertNotNull(agence6.getIdAgence());
		assertNotNull(agence7.getIdAgence());
		assertNotNull(agence8.getIdAgence());
		assertNotNull(agence9.getIdAgence());		
	}
	
	 Test OK 
	@Ignore
	@Test
	public void testGetAgence(){
		Agence agence1 = service.getAgence(1L);
		assertNotNull(agence1.getIdAgence());
	}
	
	 Test OK 
	@Ignore
	@Test
	public void testGetAgences() throws Exception{
		List<Agence> agences = service.getAgences();
		assertNotNull(agences.size()>0);
	}
	
	 Test OK 
	@Ignore
	@Test
	public void testUpdateAgence(){
		Agence agence1 = service.getAgence(1L);
		agence1.setNom("nomModifie1");
		service.updateAgence(agence1);
		Agence agence2 = service.getAgence(1L);
		assertThat("nomModifie1", IsEqual.equalTo(agence2.getNom()));
	}
	
	 Test OK 
	@Ignore
	@Test
	public void testAddFactureToAgence() throws Exception{
		Agence agence1 = service.getAgence(1L);
		service.addFactureToAgence(agence1.getIdAgence(), 3L);
		assertTrue(true);
	}

}
*/