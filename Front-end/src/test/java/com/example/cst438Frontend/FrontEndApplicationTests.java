package com.example.cst438Frontend;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.cst438Frontend.domain.CustomerRepository;

import java.util.Arrays;

@SpringBootTest
class FrontEndApplicationTests {
	
	@Autowired CustomerRepository customerRepository;
	

	@Test
	void contextLoads() {
	}
	
	/*
	 * @Test public void testOneToOne() { // (int orderSequence, long dishId, int
	 * qty, double lineItemAmount)
	 * 
	 * Customer c = new Customer("David", "Wisneski", "100 Campus Center", "",
	 * "Seaside", "CA", "93955", ""); Order o = new Order(new Timestamp(new
	 * Date().getTime()), 25.96, 5.00, 30.96, "PayPal"); o.setCustomer(c); //
	 * associate customer id with order c.setOrder(o); assertEquals(o,
	 * c.getOrder()); assertEquals(c, o.getCustomer()); // save parent which will
	 * also save child }
	 */
	
	@Test
	public void testManyToOne() {
		
		
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
