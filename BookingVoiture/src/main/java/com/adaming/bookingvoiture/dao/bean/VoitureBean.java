package com.adaming.bookingvoiture.dao.bean;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;

import jdk.nashorn.internal.objects.annotations.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adaming.bookingvoiture.entities.Voiture;
import com.adaming.bookingvoiture.exceptions.ExceptionDeleteVoiture;
import com.adaming.bookingvoiture.exceptions.ExceptionDispoVoiture;
import com.adaming.bookingvoiture.exceptions.ExceptionKilometrage;
import com.adaming.bookingvoiture.service.voiture.IVoitureService;

@Component("VoitureBean")
@RequestScoped
public class VoitureBean {
	
	Logger log=Logger.getLogger("VoitureBean");
	
	@Autowired
	private IVoitureService serviceVoiture;

	//Attributs
	
	private Long idVoiture=0L;
	private Date dateEntree;
	private Date dateSortie;
	private String model;
	private String immatricule;
	private Double kilometrage;
	private double prixLocationJournee;
	private String typeVoiture;
	private String typeCarburant;
	private String etatVoiture;
	private Voiture voiture;
	private List<Voiture> tabVoitures;
	private List<Voiture> tabVoitureDispoToday;
	private List<Voiture> tabVoituredispoPeriode;
	private List<Voiture> tabRetourVoiture;
	private String exceptionDelVoiture;
	private String exceptionDispoToday;
	private String exceptionDispoPeriode;
	private String exceptionRetour;
	private String exceptionkmEntretient;
	private double kmEntretienRestant;
	private String exceptionkmAllEntretien=null;
	
	public void addVoiture(){
		Voiture v =new Voiture(model, immatricule, kilometrage, prixLocationJournee, typeVoiture, typeCarburant, etatVoiture);
		serviceVoiture.addVoiture(v);
		getAllVoiture();
	}
	
	@PostConstruct
	public void getAllVoiture(){
		exceptionkmEntretient=null;
		tabVoitures=serviceVoiture.getVoitures();
	}
	
	public void deleteVoiture() throws ExceptionDeleteVoiture{
		try {
			serviceVoiture.deleteVoiture(idVoiture);
		} catch (Exception e) {
			exceptionDelVoiture=e.getMessage();
		}
		getAllVoiture();
	}
	
	@PostConstruct
	public void voitureDispoToday() throws ExceptionDispoVoiture, ExceptionKilometrage{
		try {
			tabVoitureDispoToday=serviceVoiture.voitureDispoToday();
		} catch (Exception e) {
			exceptionDispoToday=e.getMessage();
		}
		
	}
	
	public void voitureDispoPeriode() throws ExceptionDeleteVoiture, ExceptionDispoVoiture{
		tabVoituredispoPeriode=null;
		exceptionDispoPeriode=null;
		try {
			tabVoituredispoPeriode=serviceVoiture.voitureDispoPeriode(dateEntree, dateSortie);
		} catch (Exception e) {
			exceptionDispoPeriode=e.getMessage();
		}
		getAllVoiture();
	}
	
	@PostConstruct
	public void alertAllEntretien(){
		exceptionkmAllEntretien=null;
		try {
			exceptionkmAllEntretien=null;
			serviceVoiture.alertAllEntretien();
			exceptionkmAllEntretien=null;
		} catch (Exception e) {
			exceptionkmAllEntretien=e.getMessage();
		}
	}

	public void getVoitureById(){
		voiture=serviceVoiture.getVoitureById(idVoiture);
	}
	public void updateVoiture(){
		serviceVoiture.updateVoiture(voiture);
		getAllVoiture();
	}
	
	public void alertEntretien() throws ExceptionKilometrage{
			kmEntretienRestant= serviceVoiture.alertEntretien(idVoiture);
	}
	
	@PostConstruct
	public void retourVoiture() throws ParseException{
		try {
			tabRetourVoiture=serviceVoiture.retourVoiture();
		} catch (Exception e) {
			exceptionRetour=e.getMessage();
		}
	}
	
	//Constructor
	
	public VoitureBean() {
		// TODO Auto-generated constructor stub
	}
	
	//Get and Set
	
	
	public IVoitureService getServiceVoiture() {
		return serviceVoiture;
	}
	public void setServiceVoiture(IVoitureService serviceVoiture) {
		this.serviceVoiture = serviceVoiture;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getImmatricule() {
		return immatricule;
	}
	public void setImmatricule(String immatricule) {
		this.immatricule = immatricule;
	}
	public Double getKilometrage() {
		return kilometrage;
	}
	public void setKilometrage(Double kilometrage) {
		this.kilometrage = kilometrage;
	}
	public double getPrixLocationJournee() {
		return prixLocationJournee;
	}
	public void setPrixLocationJournee(double prixLocationJournee) {
		this.prixLocationJournee = prixLocationJournee;
	}
	public String getTypeVoiture() {
		return typeVoiture;
	}
	public void setTypeVoiture(String typeVoiture) {
		this.typeVoiture = typeVoiture;
	}
	public String getTypeCarburant() {
		return typeCarburant;
	}
	public void setTypeCarburant(String typeCarburant) {
		this.typeCarburant = typeCarburant;
	}
	public String getEtatVoiture() {
		return etatVoiture;
	}
	public void setEtatVoiture(String etatVoiture) {
		this.etatVoiture = etatVoiture;
	}

	public List<Voiture> getTabVoitures() {
		return tabVoitures;
	}

	public void setTabVoitures(List<Voiture> tabVoitures) {
		this.tabVoitures = tabVoitures;
	}

	public Long getIdVoiture() {
		return idVoiture;
	}

	public void setIdVoiture(Long idVoiture) {
		this.idVoiture = idVoiture;
	}

	public List<Voiture> getTabVoitureDispoToday() {
		return tabVoitureDispoToday;
	}

	public void setTabVoitureDispoToday(List<Voiture> tabVoitureDispoToday) {
		this.tabVoitureDispoToday = tabVoitureDispoToday;
	}

	public Date getDateEntree() {
		return dateEntree;
	}

	public void setDateEntree(Date dateEntree) {
		this.dateEntree = dateEntree;
	}

	public Date getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}

	public List<Voiture> getTabVoituredispoPeriode() {
		return tabVoituredispoPeriode;
	}

	public void setTabVoituredispoPeriode(List<Voiture> tabVoituredispoPeriode) {
		this.tabVoituredispoPeriode = tabVoituredispoPeriode;
	}

	public Voiture getVoiture() {
		return voiture;
	}

	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}

	
	public List<Voiture> getTabRetourVoiture() {
		return tabRetourVoiture;
	}

	public void setTabRetourVoiture(List<Voiture> tabRetourVoiture) {
		this.tabRetourVoiture = tabRetourVoiture;
	}

	public String getExceptionDelVoiture() {
		return exceptionDelVoiture;
	}

	public void setExceptionDelVoiture(String exceptionDelVoiture) {
		this.exceptionDelVoiture = exceptionDelVoiture;
	}

	public String getExceptionDispoToday() {
		return exceptionDispoToday;
	}

	public void setExceptionDispoToday(String exceptionDispoToday) {
		this.exceptionDispoToday = exceptionDispoToday;
	}

	public String getExceptionDispoPeriode() {
		return exceptionDispoPeriode;
	}

	public void setExceptionDispoPeriode(String exceptionDispoPeriode) {
		this.exceptionDispoPeriode = exceptionDispoPeriode;
	}

	public String getExceptionRetour() {
		return exceptionRetour;
	}

	public void setExceptionRetour(String exceptionRetour) {
		this.exceptionRetour = exceptionRetour;
	}

	public String getExceptionkmEntretient() {
		return exceptionkmEntretient;
	}

	public void setExceptionkmEntretient(String exceptionkmEntretient) {
		this.exceptionkmEntretient = exceptionkmEntretient;
	}

	public double getKmEntretienRestant() {
		return kmEntretienRestant;
	}

	public void setKmEntretienRestant(double kmEntretienRestant) {
		this.kmEntretienRestant = kmEntretienRestant;
	}

	public String getExceptionkmAllEntretien() {
		return exceptionkmAllEntretien;
	}

	public void setExceptionkmAllEntretien(String exceptionkmAllEntretien) {
		this.exceptionkmAllEntretien = exceptionkmAllEntretien;
	}

	

	
}
