package com.adaming.bookingvoiture.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/*
 * Classe:Client
 * Package:com.adaming.bookingvoiture.entities
 * Version: 1.0.0
 * Date: 08/08/2016
 * Author: Julie Brouqué
 * */
@Entity
public class Client {

	//Attributs 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long idClient;
	  private String nomClient;
	  private String prenomClient; 
	  @Temporal(TemporalType.DATE)
	  private Date   dateDeNaissanceClient; 
	  private String numeroTelClient; 
	  private String numeroPermisClient; 
	  private String adressPostalClient; 
	  private String mailClient; 
	  private String paysClient; 
	  @Temporal(TemporalType.DATE)
	  private Date   dateDeDelivrance;
	  private String lieuDeNaissanceClient;
	  private String delivrerPar;
	  
	  //Constructors
	  
	public Client(String nomClient, String prenomClient,
			Date dateDeNaissanceClient, String numeroTelClient,
			String numeroPermisClient, String adressPostalClient,
			String mailClient, String paysClient, Date dateDeDelivrance,
			String lieuDeNaissanceClient, String delivrerPar) {
		super();
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.dateDeNaissanceClient = dateDeNaissanceClient;
		this.numeroTelClient = numeroTelClient;
		this.numeroPermisClient = numeroPermisClient;
		this.adressPostalClient = adressPostalClient;
		this.mailClient = mailClient;
		this.paysClient = paysClient;
		this.dateDeDelivrance = dateDeDelivrance;
		this.lieuDeNaissanceClient = lieuDeNaissanceClient;
		this.delivrerPar = delivrerPar;
	}

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Get and Set

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getPrenomClient() {
		return prenomClient;
	}

	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}

	public Date getDateDeNaissanceClient() {
		return dateDeNaissanceClient;
	}

	public void setDateDeNaissanceClient(Date dateDeNaissanceClient) {
		this.dateDeNaissanceClient = dateDeNaissanceClient;
	}

	public String getNumeroTelClient() {
		return numeroTelClient;
	}

	public void setNumeroTelClient(String numeroTelClient) {
		this.numeroTelClient = numeroTelClient;
	}

	public String getNumeroPermisClient() {
		return numeroPermisClient;
	}

	public void setNumeroPermisClient(String numeroPermisClient) {
		this.numeroPermisClient = numeroPermisClient;
	}

	public String getAdressPostalClient() {
		return adressPostalClient;
	}

	public void setAdressPostalClient(String adressPostalClient) {
		this.adressPostalClient = adressPostalClient;
	}

	public String getMailClient() {
		return mailClient;
	}

	public void setMailClient(String mailClient) {
		this.mailClient = mailClient;
	}

	public String getPaysClient() {
		return paysClient;
	}

	public void setPaysClient(String paysClient) {
		this.paysClient = paysClient;
	}

	public Date getDateDeDelivrance() {
		return dateDeDelivrance;
	}

	public void setDateDeDelivrance(Date dateDeDelivrance) {
		this.dateDeDelivrance = dateDeDelivrance;
	}

	public String getLieuDeNaissanceClient() {
		return lieuDeNaissanceClient;
	}

	public void setLieuDeNaissanceClient(String lieuDeNaissanceClient) {
		this.lieuDeNaissanceClient = lieuDeNaissanceClient;
	}

	public String getDelivrerPar() {
		return delivrerPar;
	}

	public void setDelivrerPar(String delivrerPar) {
		this.delivrerPar = delivrerPar;
	}
  
}
