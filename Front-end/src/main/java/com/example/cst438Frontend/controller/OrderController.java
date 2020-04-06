package com.example.cst438Frontend.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.cst438Frontend.Order;
import com.example.cst438Frontend.domain.OrderRepository;

@Controller
public class OrderController {
	/* Access to the orderRepository interface */
	@Autowired
	OrderRepository orderRepository;

	/*
	 * Add order to table and display success page. In case of validation errors, return form. 
	 */
	
	/* To read for saving multiple line items entities: https://www.baeldung.com/spring-data-jpa-batch-inserts */
	@PostMapping("/order/submit")
	public String processOrderForm(@Valid Order order, BindingResult result, Model model) {
		if (result.hasErrors()) {
			System.out.println(result);
			return "order";
		}
		orderRepository.save(order);
		return "order_success";
	}

}
