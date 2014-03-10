package com.ashish.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashish.spring.web.dao.Offer;
import com.ashish.spring.web.dao.OffersDao;

@Service("offerService")
public class OffersService {

	private OffersDao offersDAO;

	@Autowired
	public void setOffersDAO(OffersDao offersDAO) {
		this.offersDAO = offersDAO;
	}

	public List<Offer> getCurrent() {
		return offersDAO.getOffers();
	}

	public void createOffer(Offer offer) {
		offersDAO.create(offer);
	}

	public void throwTestException() {
		offersDAO.getOffer(99999);
	}
}
