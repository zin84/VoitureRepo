package com.adaming.bookingvoiture.dao.bean;

import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adaming.bookingvoiture.service.agence.IAgenceService;

@Component("AgenceBean")
@RequestScoped
public class AgenceBean {

	@Autowired
	private IAgenceService serviceAgence;
}
