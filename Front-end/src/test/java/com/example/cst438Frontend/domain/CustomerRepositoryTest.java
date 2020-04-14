package com.example.cst438Frontend.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.cst438Frontend.Customer;
import com.example.cst438Frontend.Order;

@SpringBootTest
public class CustomerRepositoryTest {

	@Autowired CustomerRepository customerRepository; 
	
	@Test
	public void testOneToOneSave() {
		Customer c = new Customer("David", "Wisneski", "100 Campus Center", "", "Seaside", "CA", "93955", "");
		Order o = new Order(new Timestamp(new Date().getTime()), 25.96, 5.00, 30.96, "PayPal");
		o.setCustomer(c); // associate customer id with order
		c.setOrder(o);
		assertEquals(o, c.getOrder());
		assertEquals(c, o.getCustomer());
		// save parent which will also save child
		customerRepository.save(c);
	}
}
