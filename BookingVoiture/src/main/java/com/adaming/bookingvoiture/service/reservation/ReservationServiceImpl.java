package com.adaming.bookingvoiture.service.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.bookingvoiture.dao.reservation.IReservationDao;

@Service
@Transactional
public class ReservationServiceImpl implements IReservationService{
@Autowired
	private IReservationDao dao;
}
