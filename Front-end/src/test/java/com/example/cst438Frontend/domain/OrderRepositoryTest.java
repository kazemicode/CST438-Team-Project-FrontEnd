package com.example.cst438Frontend.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.cst438Frontend.Order;

@SpringBootTest
public class OrderRepositoryTest {
	
	@Autowired OrderRepository orderRepository;
	
	@Test
	public void findByIdTest() {
		Timestamp ts = new Timestamp(1586891041000L);
		Order expected = new Order(ts, 25.96, 5.0, 30.96, "PayPal");
		Order actual = orderRepository.findById(2);
		assertEquals(expected.getOrderDatetime(), actual.getOrderDatetime());
		assertEquals(expected.getGrandTotal(), actual.getGrandTotal());
	}


}
