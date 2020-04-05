package com.example.cst438Frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.cst438Frontend.domain.Restaurant;
import com.example.cst438Frontend.service.ZomatoService;

@Controller
public class FrontEndController {
	
	@Autowired
	private ZomatoService zomatoService;
	
	@PostMapping("/search")
	public String getRestaurants(
			@RequestParam("lat") double lat,
			@RequestParam("lon") double lon,
			Model model) {
		
		List<Restaurant> restaurants = zomatoService.GetRestaurantsInArea(lat, lon);
		
		model.addAttribute("restaurants", restaurants);
		
		return "location_results";
	}
	
}
