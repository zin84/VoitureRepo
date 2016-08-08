package com.adaming.bookingvoiture.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ChaineDistribution")
public class ChaineDistribution extends Entretien{

	
	//Constructeurs//
	
	public ChaineDistribution() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChaineDistribution(String typeEntretient, Date dateEntretient,
			Double kilommetrage, Integer prixEntrtient) {
		super(typeEntretient, dateEntretient, kilommetrage, prixEntrtient);
		// TODO Auto-generated constructor stub
	}
	
	

}
