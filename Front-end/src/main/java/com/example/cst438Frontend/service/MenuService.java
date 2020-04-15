package com.example.cst438Frontend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cst438Frontend.MenuItem;
import com.example.cst438Frontend.domain.MenuRepository;

@Service
public class MenuService {
	
	@Autowired
	private MenuRepository menuRepository;
		
	public List<MenuItem> GetRestaurantMenu(long id) {
		return menuRepository.findByRestId(id);
	}

}