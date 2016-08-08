package com.adaming.bookingvoiture.service.agence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.bookingvoiture.dao.agence.IAgenceDao;

@Service
@Transactional
public class AgenceServiceImpl implements IAgenceService{
@Autowired
	private IAgenceDao dao;
}
