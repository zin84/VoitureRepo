package com.adaming.bookingvoiture.dao.bean;

import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adaming.bookingvoiture.service.reservation.IReservationService;

@Component("ReservationBean")
@RequestScoped
public class ReservationBean {
@Autowired
	private IReservationService serviceReservation;
	
}
