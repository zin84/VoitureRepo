package com.adaming.bookingvoiture.service.entretien;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.bookingvoiture.dao.entretien.IEntretienDao;

@Service
@Transactional
public class EntretienServiceImpl implements IEntretienService{
@Autowired
	private IEntretienDao dao;
}
