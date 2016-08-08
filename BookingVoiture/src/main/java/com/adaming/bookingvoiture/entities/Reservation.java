package com.adaming.bookingvoiture.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/*
 * Classe:Reservation
 * Package:com.adaming.bookingvoiture.entities
 * Version: 1.0.0
 * Date: 08/08/2016
 * Author: Julie Brouqué
 * */
@Entity
public class Reservation {

	//Attributs 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long idReservation;
	  private double prix;
	  @Temporal(TemporalType.DATE)
	  private Date dateDeReservation;
	  @Temporal(TemporalType.DATE)
	  private Date dateDeRentrer;
	  @Temporal(TemporalType.DATE)
	  private Date dateDeSortie;
	  private String heureDeSortie;
	  private String heureDeRentrer;
	  private Integer nombresDeJours;
	  private String etatDeReservation;
	  
	  @ManyToOne
	  @JoinColumn(name="idClient")
	  private Client clientReservation;
	  
	  @ManyToOne
	  @JoinColumn(name="idVoiture")
	  private Voiture voitureReservation;
	  
	  //Contructors
	  
	

	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reservation(Date dateDeReservation, Date dateDeRentrer,
			Date dateDeSortie, String heureDeSortie, String heureDeRentrer,
			Integer nombresDeJours, String etatDeReservation) {
		super();
		this.dateDeReservation = dateDeReservation;
		this.dateDeRentrer = dateDeRentrer;
		this.dateDeSortie = dateDeSortie;
		this.heureDeSortie = heureDeSortie;
		this.heureDeRentrer = heureDeRentrer;
		this.nombresDeJours = nombresDeJours;
		this.etatDeReservation = etatDeReservation;
	}

	//Get and Set 
	

	public double getPrix() {
		return prix;
	}

	public Long getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(Long idReservation) {
		this.idReservation = idReservation;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Date getDateDeReservation() {
		return dateDeReservation;
	}

	public void setDateDeReservation(Date dateDeReservation) {
		this.dateDeReservation = dateDeReservation;
	}

	public Date getDateDeRentrer() {
		return dateDeRentrer;
	}

	public void setDateDeRentrer(Date dateDeRentrer) {
		this.dateDeRentrer = dateDeRentrer;
	}

	public Date getDateDeSortie() {
		return dateDeSortie;
	}

	public void setDateDeSortie(Date dateDeSortie) {
		this.dateDeSortie = dateDeSortie;
	}

	public String getHeureDeSortie() {
		return heureDeSortie;
	}

	public void setHeureDeSortie(String heureDeSortie) {
		this.heureDeSortie = heureDeSortie;
	}

	public String getHeureDeRentrer() {
		return heureDeRentrer;
	}

	public void setHeureDeRentrer(String heureDeRentrer) {
		this.heureDeRentrer = heureDeRentrer;
	}

	public Integer getNombresDeJours() {
		return nombresDeJours;
	}

	public void setNombresDeJours(Integer nombresDeJours) {
		this.nombresDeJours = nombresDeJours;
	}

	public String getEtatDeReservation() {
		return etatDeReservation;
	}

	public void setEtatDeReservation(String etatDeReservation) {
		this.etatDeReservation = etatDeReservation;
	}

	public Client getClientReservation() {
		return clientReservation;
	}

	public void setClientReservation(Client clientReservation) {
		this.clientReservation = clientReservation;
	}

	public Voiture getVoitureReservation() {
		return voitureReservation;
	}

	public void setVoitureReservation(Voiture voitureReservation) {
		this.voitureReservation = voitureReservation;
	}
	  
	  
}
