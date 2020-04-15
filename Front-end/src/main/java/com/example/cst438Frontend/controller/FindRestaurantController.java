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
import org.springframework.web.bind.annotation.RequestParam;

import com.example.cst438Frontend.MenuItem;
import com.example.cst438Frontend.domain.Restaurant;
import com.example.cst438Frontend.domain.User;
import com.example.cst438Frontend.service.FindRestaurantService;
import com.example.cst438Frontend.service.MenuService;
import com.example.cst438Frontend.service.ZomatoService;

@Controller
public class FindRestaurantController {

	@Autowired
	FindRestaurantService findRestaurantService;
	
	@Autowired
	ZomatoService zomatoService;
	
	@Autowired
	MenuService menuService;
	
	@GetMapping("/nearme")
	public String findRestaurants() {
		return "index";
	}
	
	@PostMapping("/findrestaurants") // 
	public String getRestaurants(@Valid User user, BindingResult result,
			Model model) {
		findRestaurantService.getGeoCodes(user);
		List<Restaurant> restaurants = zomatoService.GetRestaurantsInArea(Double.parseDouble(user.getLatitude()), Double.parseDouble(user.getLongitude()));
		model.addAttribute("restaurants", restaurants);
		return "restaurant_results";		
	}
	
	@GetMapping("/cart")
	public String cart() {
		return "cart_summary";
	}
	
	@PostMapping("/order_form")
	public String getMenu(
			@RequestParam("id") String id,
			Model model) {
		// Do look up for menu and pass that to next View
		List<MenuItem> menu = menuService.GetRestaurantMenu(Long.valueOf(id));
		System.out.println(menu);
		model.addAttribute("menu", menu);
		
		return "restaurant_menu";
	}
}
