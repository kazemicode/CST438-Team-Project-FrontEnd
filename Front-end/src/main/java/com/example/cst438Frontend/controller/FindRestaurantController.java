package com.example.cst438Frontend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.example.cst438Frontend.domain.Restaurant;
import com.example.cst438Frontend.domain.User;
import com.example.cst438Frontend.service.FindRestaurantService;
import com.example.cst438Frontend.service.ZomatoService;

@Controller
public class FindRestaurantController {

	@Autowired
	FindRestaurantService findRestaurantService;
	
	@Autowired
	ZomatoService zomatoService;
	
	
	@GetMapping("/nearme")
	public String findRestaurants() {
		return "index";
	}
	
	@PostMapping("/findrestaurants") // 
	public ResponseEntity<List<Restaurant>> getRestaurants(@Valid User user, BindingResult result,
			Model model) {
		findRestaurantService.getGeoCodes(user);
		List<Restaurant> restaurants = zomatoService.GetRestaurantsInArea(33.129081726074219, -117.20842742919922);
		return new ResponseEntity<List<Restaurant>>( restaurants, HttpStatus.OK);	
	}	
}
