package com.adaming.bookingvoiture.service.voiture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.bookingvoiture.dao.voiture.IVoitureDao;

@Service
@Transactional
public class VoitureServiceImpl {
@Autowired
	private IVoitureDao dao;
}
