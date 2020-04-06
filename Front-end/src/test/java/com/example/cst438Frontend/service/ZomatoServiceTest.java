package com.example.cst438Frontend.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.cst438Frontend.domain.*;

@SpringBootTest
public class ZomatoServiceTest {

	@Autowired
	private ZomatoService zomatoService;
	
	@Test
	public void contextLoads() {}
	
	@Test
	public void testRestaurantsFound() throws Exception {
		
		// Code here for successful search
		// Success is a user enters address and list of restaurants is returned
		
	}
	
	@Test
	public void testNoRestaurantsFound() throws Exception {
		
		// Code here for testing address that returns no results
		
	}
	
}
