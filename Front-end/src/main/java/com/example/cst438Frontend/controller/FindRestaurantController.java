package com.example.cst438Frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class FindRestaurantController {

	@Autowired
	//private service
	
	@GetMapping("/findRestaurants")
	public String findRestaurants(@PathVariable("city") String cityName) {
		
		return "show_restaurants";
	}
}
