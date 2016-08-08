package com.adaming.bookingvoiture.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Entretien {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEntretient;
	private String typeEntretient;
	@Temporal(TemporalType.DATE)
	private Date dateEntretient;
	private  Double Kilommetrage;
	private Integer prixEntrtient;
	
	@ManyToOne
	@JoinColumn(name="idVoiture")
	private Voiture voiture;
	
	
	
	
	
//Constructeurs//

	public Entretien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Entretien(String typeEntretient, Date dateEntretient,
			Double kilommetrage, Integer prixEntrtient) {
		super();
		this.typeEntretient = typeEntretient;
		this.dateEntretient = dateEntretient;
		Kilommetrage = kilommetrage;
		this.prixEntrtient = prixEntrtient;
	}

	//Getters & setters//

	public Long getIdEntretient() {
		return idEntretient;
	}

	public void setIdEntretient(Long idEntretient) {
		this.idEntretient = idEntretient;
	}

	public String getTypeEntretient() {
		return typeEntretient;
	}

	public void setTypeEntretient(String typeEntretient) {
		this.typeEntretient = typeEntretient;
	}

	public Date getDateEntretient() {
		return dateEntretient;
	}

	public void setDateEntretient(Date dateEntretient) {
		this.dateEntretient = dateEntretient;
	}

	public Double getKilommetrage() {
		return Kilommetrage;
	}

	public void setKilommetrage(Double kilommetrage) {
		Kilommetrage = kilommetrage;
	}

	public Integer getPrixEntrtient() {
		return prixEntrtient;
	}

	public void setPrixEntrtient(Integer prixEntrtient) {
		this.prixEntrtient = prixEntrtient;
	}

	public Voiture getVoiture() {
		return voiture;
	}

	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}
	
	

}
