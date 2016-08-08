package com.adaming.bookingvoiture.dao.bean;

import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adaming.bookingvoiture.service.client.IClientService;

@Component("ClientBean")
@RequestScoped
public class ClientBean {
@Autowired
	private IClientService serviceClient;
}
