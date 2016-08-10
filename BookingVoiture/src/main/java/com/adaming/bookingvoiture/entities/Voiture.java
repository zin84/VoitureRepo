package com.adaming.bookingvoiture.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
/*
 * Classe:Voiture
 * Package:com.adaming.bookingvoiture.entities
 * Version: 1.0.0
 * Date: 08/08/2016
 * Author: Julie Brouqué
 * */
@Entity
public class Voiture {

	//Attributs
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idvoiture;
    private String model;
    private String immatricule;
    private Double kilometrage;
    private double prixLocationJournee;
    private String typeVoiture;
    private String typeCarburant;
    private String etatVoiture;
    
    @OneToMany(mappedBy="voitureReservation", fetch=FetchType.EAGER)
    private List<Reservation> tabReservationVoiture;
    
    @OneToMany(mappedBy="voiture")
    private List<Entretien> tabEntretienVoit;
   
    
    //Constructors
    
    

	public Voiture() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Voiture(String model, String immatricule, Double kilometrage,
			double prixLocationJournee, String typeVoiture,
			String typeCarburant, String etatVoiture) {
		super();
		this.model = model;
		this.immatricule = immatricule;
		this.kilometrage = kilometrage;
		this.prixLocationJournee = prixLocationJournee;
		this.typeVoiture = typeVoiture;
		this.typeCarburant = typeCarburant;
		this.etatVoiture = etatVoiture;
	}

	//Get and Set
	
	public Long getIdvoiture() {
		return idvoiture;
	}

	public void setIdvoiture(Long idvoiture) {
		this.idvoiture = idvoiture;
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

	public List<Reservation> getTabReservationVoiture() {
		return tabReservationVoiture;
	}

	public void setTabReservationVoiture(List<Reservation> tabReservationVoiture) {
		this.tabReservationVoiture = tabReservationVoiture;
	}

	public List<Entretien> getTabEntretienVoit() {
		return tabEntretienVoit;
	}

	public void setTabEntretienVoit(List<Entretien> tabEntretienVoit) {
		this.tabEntretienVoit = tabEntretienVoit;
	}
    
    
}

