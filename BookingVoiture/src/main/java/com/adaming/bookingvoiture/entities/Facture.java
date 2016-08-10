package com.adaming.bookingvoiture.entities;
/* Classe : Facture
 * Package : com.adaming.bookingvoiture.entities
 * Author : Philippe
 * Date : 08/08/16
 * Version : 1.0.0
 */
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class Facture {
	/* attributs */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idFacture;
    @Temporal(TemporalType.DATE)
	private Date dateDeFacturation;
	
	@OneToOne()
	@JoinColumn(name = "reserv")
	private Reservation reservation;
	
	/* constructeur par defaut */
	public Facture() {
		super();
	}
	
	/* constructeur avec parametres */
	public Facture(Date dateDeFacturation) {
		super();
		dateDeFacturation = dateDeFacturation;
	}
	/* accesseurs */
	public Long getIdFacture() {
		return idFacture;
	}
	public void setIdFacture(Long idFacture) {
		this.idFacture = idFacture;
	}
	public Date getDateDeFacturation() {
		return dateDeFacturation;
	}
	public void setDateDeFacturation(Date dateDeFacturation) {
		dateDeFacturation = dateDeFacturation;
	}
	
	@JsonIgnore
	public Reservation getReservation() {
		return reservation;
	}

	@JsonSetter
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	
	/* redefinition de toString */
	@Override
	public String toString() {
		return "Facture [idFacture=" + idFacture + ", DateDeFacturation=" + dateDeFacturation + "]";
	}

}
