package com.example.cst438Frontend.controller;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.cst438Frontend.*;
import com.example.cst438Frontend.domain.CustomerRepository;

public class OrderControllerTest {
	
	@Autowired CustomerRepository customerRepository;

	
public void ControllerSaveTest() {
	Customer c = new Customer("David", "Wisneski", "100 Campus Center", "", "Seaside", "CA", "93955", "");

	List<OrderLineItem> orderLineItems = 
			Arrays.asList(
					new OrderLineItem(1, 1, 1, 9.95),
					new OrderLineItem(2, 12, 2, 9.95));

	double subtotal = 0;
	for(OrderLineItem li : orderLineItems) {
		subtotal += li.getLineItemAmount() * li.getQty();

	}
	double tip = 5.0;
	double grandtotal = subtotal + tip;

	Order o = new Order(new Timestamp(new Date().getTime()), subtotal, tip, grandtotal, "PayPal");
	for(OrderLineItem li : orderLineItems) {
		li.setOrder(o);
	}
	// associate line items with order
	o.getOrderLineItems().add(orderLineItems.get(0));
	o.getOrderLineItems().add(orderLineItems.get(1));
	o.setCustomer(c); // associate customer id with order

	c.setOrder(o); // associate order with customer
	customerRepository.save(c);
}
}
