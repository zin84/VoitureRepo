package com.adaming.bookingvoiture.dao.bean;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adaming.bookingvoiture.entities.Client;
import com.adaming.bookingvoiture.entities.Reservation;
import com.adaming.bookingvoiture.entities.Voiture;
import com.adaming.bookingvoiture.exceptions.ExceptionDeleteRes;
import com.adaming.bookingvoiture.exceptions.ExceptionResDispo;
import com.adaming.bookingvoiture.service.client.IClientService;
import com.adaming.bookingvoiture.service.reservation.IReservationService;
import com.adaming.bookingvoiture.service.voiture.IVoitureService;

@Component("ReservationBean")
@RequestScoped
public class ReservationBean {
	@Autowired
	private IReservationService serviceReservation;
	
	@Autowired
	private IClientService serviceClient;
	@Autowired
	private IVoitureService serviceVoiture;

	// Attributs

	private Long idReservation;
	private Long idClient;
	private Long idVoiture;
	  private double prix;
	  private Date dateDeReservation;
	  private Date dateDeRentrer;
	  private Date dateDeSortie;
	  private String heureDeSortie;
	  private String heureDeRentrer;
	  private Integer nombresDeJours;
	  private String etatDeReservation;
	  private Reservation reservation;
	  private List<Client> tabClientRes;
	  private List<Voiture> tabVoitureRes;
	  private List<Reservation> tabRes;
	  private List<Reservation> tabHistRes;
	  private String exceptionRes;
	  private String exceptionDelRes;
	  private String exceptionUpdateRes;
	  
	  public void addReservation() throws Exception{
		  exceptionDelRes=null;
		  exceptionRes=null;
		  exceptionUpdateRes=null;
		  try {
			  Reservation r=new Reservation(new Date(), dateDeRentrer, dateDeSortie, heureDeSortie, heureDeRentrer, etatDeReservation);
			  serviceReservation.addreservation(r, idClient, idVoiture);
		} catch (Exception e) {
			exceptionRes=e.getMessage();
		}
		  getAllReservation();
		  getAllClient();
		  getAllVoiture();
	  }
	  
	  @PostConstruct
	  public void getAllReservation(){
		  tabRes=serviceReservation.getRes();
	  }
	  
	  @PostConstruct
	  public void getAllClient() throws Exception{
		  tabClientRes=serviceClient.getClients();
	  }
	  @PostConstruct
	  public void getAllVoiture(){
		  tabVoitureRes=null;
		  tabVoitureRes=serviceVoiture.getVoitures();
	  }
	  
	  public void deleteRes() {
		  exceptionDelRes=null;
		  exceptionRes=null;
		  exceptionUpdateRes=null;
		 try {
			  serviceReservation.deleteReservation(idReservation);
		} catch (Exception e) {
			System.out.println("Echec>--------------------------");
			exceptionDelRes=e.getMessage();
		}
		  getAllReservation();
	  }
	  @PostConstruct
	  public void histRes(){
		  tabHistRes=serviceReservation.getHistoriqueReservation();
	  }
	  
	  public void getResById(){
		  reservation=serviceReservation.getResById(idReservation);
	  }
	  
	  public void updateRes() throws Exception{
		  exceptionDelRes=null;
		  exceptionRes=null;
		  exceptionUpdateRes=null;
		  try {
			  serviceReservation.updateReservation(reservation);
		} catch (Exception e) {
			exceptionUpdateRes=e.getMessage();
		}
		  getAllReservation();
		  getAllClient();
		  getAllVoiture();
	  }
	  //Constructor
	  
	  public ReservationBean() {
			// TODO Auto-generated constructor stub
		}
	  
	  //Get and Set
	  
	
	public IReservationService getServiceReservation() {
		return serviceReservation;
	}
	public void setServiceReservation(IReservationService serviceReservation) {
		this.serviceReservation = serviceReservation;
	}
	public double getPrix() {
		return prix;
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
	public Long getIdClient() {
		return idClient;
	}
	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}
	public Long getIdVoiture() {
		return idVoiture;
	}
	public void setIdVoiture(Long idVoiture) {
		this.idVoiture = idVoiture;
	}
	public List<Client> getTabClientRes() {
		return tabClientRes;
	}
	public void setTabClientRes(List<Client> tabClientRes) {
		this.tabClientRes = tabClientRes;
	}
	public List<Voiture> getTabVoitureRes() {
		return tabVoitureRes;
	}
	public void setTabVoitureRes(List<Voiture> tabVoitureRes) {
		this.tabVoitureRes = tabVoitureRes;
	}

	public List<Reservation> getTabRes() {
		return tabRes;
	}

	public void setTabRes(List<Reservation> tabRes) {
		this.tabRes = tabRes;
	}

	public Long getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(Long idReservation) {
		this.idReservation = idReservation;
	}

	public List<Reservation> getTabHistRes() {
		return tabHistRes;
	}

	public void setTabHistRes(List<Reservation> tabHistRes) {
		this.tabHistRes = tabHistRes;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public String getExceptionRes() {
		return exceptionRes;
	}

	public void setExceptionRes(String exceptionRes) {
		this.exceptionRes = exceptionRes;
	}

	public String getExceptionDelRes() {
		return exceptionDelRes;
	}

	public void setExceptionDelRes(String exceptionDelRes) {
		this.exceptionDelRes = exceptionDelRes;
	}

	public String getExceptionUpdateRes() {
		return exceptionUpdateRes;
	}

	public void setExceptionUpdateRes(String exceptionUpdateRes) {
		this.exceptionUpdateRes = exceptionUpdateRes;
	}
	  
	
	 
	  
}
