package com.adaming.bookingvoiture.service.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.bookingvoiture.dao.client.IClientDao;

@Service
@Transactional
public class ClientServiceImpl implements IClientService {
@Autowired
	private IClientDao dao;
}
