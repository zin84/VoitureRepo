package com.adaming.bookingvoiture.dao.entretien;

import java.util.List;

import com.adaming.bookingvoiture.entities.Entretien;
import com.adaming.bookingvoiture.exceptions.ObjetInexistantException;
/*
 * Classe:IEntretienDao
 * Package:com.adaming.bookingvoiture.dao.entretien
 * Version: 1.0.0
 * Date: 09/08/2016
 * Author: Romain Ganet
 * */

public interface IEntretienDao {
	
	public Entretien addEntretien (Entretien e, Long idVoiture) throws ObjetInexistantException;
	public Entretien deleteEntretien(Long idEntretient) throws ObjetInexistantException;
	public Entretien updateEntretien(Entretien e);
	public List<Entretien> getListEntretien() throws ObjetInexistantException;
	public Entretien getEntretien(Long idEntretient) throws ObjetInexistantException;
	public List<Entretien> getListVidange() throws ObjetInexistantException;
	public List<Entretien> getListChaineDistribution() throws ObjetInexistantException;
	public List<Entretien> getListFiltreHuile() throws ObjetInexistantException;

}
