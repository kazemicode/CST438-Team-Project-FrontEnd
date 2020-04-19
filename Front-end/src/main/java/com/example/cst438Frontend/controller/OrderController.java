package com.example.cst438Frontend.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.cst438Frontend.Customer;
import com.example.cst438Frontend.MenuItem;
import com.example.cst438Frontend.Order;
import com.example.cst438Frontend.OrderLineItem;
import com.example.cst438Frontend.Session;
import com.example.cst438Frontend.domain.CustomerRepository;
import com.example.cst438Frontend.domain.OrderLineItemRepository;
import com.example.cst438Frontend.domain.OrderRepository;
import com.example.cst438Frontend.domain.Restaurant;
import com.example.cst438Frontend.domain.SessionRepository;
import com.example.cst438Frontend.domain.User;
import com.example.cst438Frontend.service.FindRestaurantService;
import com.example.cst438Frontend.service.MenuService;
import com.example.cst438Frontend.service.OrderService;
import com.example.cst438Frontend.service.ZomatoService;

//import org.springframework.boot.configurationprocessor.json.JSONArray;
//import org.springframework.boot.configurationprocessor.json.JSONObject;

@Controller
public class OrderController {
	/* Access to the orderRepository interface */
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	OrderLineItemRepository orderLineItemRepository;
	
	@Autowired SessionRepository sessionRepository;
	
	@Autowired 
	OrderService orderService;
	
	@Autowired
	FindRestaurantService findRestaurantService;
	
	@Autowired ZomatoService zomatoService;
	
	@Autowired MenuService menuService;
	
	@GetMapping("/nearme")
	public String findRestaurants() {
		return "index";
	}
	
	// When address is submitted to find nearby restaurants, let's save
	// address details to our sessions table and get the session id for future use
	@PostMapping("/findrestaurants")
	public String processAddress(@Valid User user, BindingResult result, Model model) {
		Session session = new Session();
		session.setAddr1(user.getAddress());
		session.setAddr2("");
		session.setCity(user.getCity());
		session.setState(user.getState());
		session.setZipcode(user.getZip_code());
		session = (Session) sessionRepository.save(session);
		long sessionId = session.getId();
		model.addAttribute("sessionId", sessionId);
		
		findRestaurantService.getGeoCodes(user);
		List<Restaurant> restaurants = zomatoService.GetRestaurantsInArea(Double.parseDouble(user.getLatitude()), Double.parseDouble(user.getLongitude()));
		model.addAttribute("restaurants", restaurants);
		return "restaurant_results";	
		
	}
	
	// when restaurant is selected, re-add session id to model
	// for future use
	@PostMapping("/order_form")
	public String getMenu(
			@RequestParam("id") String id,
			@RequestParam("sessionId") String sessionId,
			Model model) {
		// Do look up for menu and pass that to next View
		List<MenuItem> menu = menuService.GetRestaurantMenu(Long.valueOf(id));
		System.out.println(menu);
		model.addAttribute("menu", menu);
		model.addAttribute("sessionId", sessionId);
		
		// Create list of OrderLineItems
		// If MenuItem quantity >=1, create OrderLineItem and add to list
		// Parse form, create JSON formatted string from OrderLineItems, and submit to next view
		// (order/summary)
		List<OrderLineItem> lineItems = new ArrayList<>();
		
		return "restaurant_menu";
	}
	
	// when item quantities are submitted from restaurant order page,
	//
	@PostMapping("order/summary") // need route
	public String getOrderDetails(
			@RequestParam("orderJSON") String orderJSON, 
			@RequestParam("sessionId") String sessionId, 
			Model model) {
		model.addAttribute("orderJSON", orderJSON);
		model.addAttribute("sessionId", sessionId);
		
		Session session = sessionRepository.findById(Long.parseLong(sessionId));
		session.setOrderLineItems(orderJSON);
		sessionRepository.save(session);
		
	return "order_summary";
	}

	/*
	 * Add order to table and display success page. In case of validation errors, return form. 
	 */
	
	// phone number,  firstName, lastName, subtotal, tip, grandtotal
	@PostMapping("/order/submit")
	public String processOrderForm( 
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("phone") String phone,
			@RequestParam("subtotal") double subtotal,
			@RequestParam("tip") double tip,
			@RequestParam("grandtotal") double grandtotal,
			@RequestParam("sessionId") String sessionId, 
			Model model) {
		
		
		Session session = sessionRepository.findById(Long.parseLong(sessionId));
		session.setFirstName(firstName);
		session.setLastName(lastName);
		session.setPhone(phone);
		session.setSubtotal(subtotal);
		session.setTip(tip);
		session.setGrandtotal(grandtotal);
		String paymentType = "Paypal";
	
		sessionRepository.save(session);
		
		
		Customer customer = new Customer(
				session.getFirstName(), 
				session.getLastName(),
				session.getAddr1(),
				session.getAddr2(),
				session.getCity(),
				session.getState(),
				session.getZipcode(),
				session.getPhone());
		
		Order order = new Order(		// Why is this being created here instead of in order/summary? 
				new Timestamp(new Date().getTime()),
				session.getSubtotal(),
				session.getTip(),
				session.getGrandtotal(),
				paymentType); // todo: dropdown for payment type
		
		List<OrderLineItem> orderLineItems = new ArrayList<>();
		// todo: parse JSON string to add orderlineitem objects to list
		
		customer.setOrder(order);
		order.setCustomer(customer);
		order.setOrderLineItems(orderLineItems);
		for(OrderLineItem ol : orderLineItems) {
			ol.setOrder(order);
		}
		
		return "order_success";
	}

}


