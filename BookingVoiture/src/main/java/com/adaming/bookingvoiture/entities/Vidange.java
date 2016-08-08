package com.adaming.bookingvoiture.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Vidange")
public class Vidange extends Entretien{

	
	//Constructeurs//
	
	public Vidange() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vidange(String typeEntretient, Date dateEntretient,
			Double kilommetrage, Integer prixEntrtient) {
		super(typeEntretient, dateEntretient, kilommetrage, prixEntrtient);
		// TODO Auto-generated constructor stub
	}
	
	
	

}
