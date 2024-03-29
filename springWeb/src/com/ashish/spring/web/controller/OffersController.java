package com.ashish.spring.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashish.spring.web.dao.Offer;
import com.ashish.spring.web.service.OffersService;

@Controller
public class OffersController {
	private OffersService	offersService;

	@Autowired
	public void setOffersService(OffersService offersService) {
		this.offersService = offersService;
	}

	@RequestMapping("/test")
	public String showTest(Model model, @RequestParam("id") String id) {
		System.out.println("id is " + id);
		return "home";
	}

	@RequestMapping("/offers")
	public String showOffers(Model model) {

		List<Offer> offers = offersService.getCurrent();
		model.addAttribute("offers", offers);

		return "offers";
	}

	@RequestMapping("/createOffer")
	public String createOffer(Model model) {
		model.addAttribute("offer", new Offer());
		return "createOffer";
	}

	@RequestMapping(value = "/doCreateOffer", method = RequestMethod.POST)
	public String doCreateOffer(Model model, @Valid Offer offer, BindingResult result) {
		if (result.hasErrors()) {
			return "createOffer";
		}

		offersService.createOffer(offer);
		System.out.println(offer);
		return "offerCreated";
	}

}
