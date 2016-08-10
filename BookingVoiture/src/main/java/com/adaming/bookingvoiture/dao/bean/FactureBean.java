package com.adaming.bookingvoiture.dao.bean;

import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adaming.bookingvoiture.service.facture.IFactureService;

@Component("FactureBean")
@RequestScoped
public class FactureBean {

	@Autowired
	private IFactureService serviceFacture;
	
	private Long idFacture;
	
}
