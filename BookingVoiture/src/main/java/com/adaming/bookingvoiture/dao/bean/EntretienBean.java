package com.adaming.bookingvoiture.dao.bean;

import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adaming.bookingvoiture.service.entretien.IEntretienService;

@Component("EntretienBean")
@RequestScoped
public class EntretienBean {

	@Autowired
	private IEntretienService serviceEntretien;
}
