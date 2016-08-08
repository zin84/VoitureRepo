package com.adaming.bookingvoiture;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.adaming.bookingvoiture.entities.Entretien;

@Entity
@DiscriminatorValue("FiltreHuile")
public class FiltreHuile extends Entretien{

	
	//Constructeurs//
	
	public FiltreHuile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FiltreHuile(String typeEntretient, Date dateEntretient,
			Double kilommetrage, Integer prixEntrtient) {
		super(typeEntretient, dateEntretient, kilommetrage, prixEntrtient);
		// TODO Auto-generated constructor stub
	}
	
	

}
