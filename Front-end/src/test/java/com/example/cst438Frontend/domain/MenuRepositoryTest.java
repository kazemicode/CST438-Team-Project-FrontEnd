package com.example.cst438Frontend.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.cst438Frontend.MenuItem;
import com.example.cst438Frontend.domain.MenuRepository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MenuRepositoryTest {
	
	@Autowired MenuRepository menuRepository;
	
	@Test
	public void findByIdTest() {
		MenuItem actual = menuRepository.findById(1);
		MenuItem expected = new MenuItem(1L, 17072771L, "Chicken Teriyaki", "Entree", "", 9.95);
		assertEquals(expected, actual);
	}
	
	@Test
	public void findByRestIdTest() {
		List<MenuItem> actual = menuRepository.findByRestId(17072771);
		List<MenuItem> expected = Arrays.asList(new MenuItem(1L, 17072771L, "Chicken Teriyaki", "Entree", "", 9.95),
				new MenuItem(2L, 17072771L, "Beef Teriyaki", "Entree", "", 14.95),
				new MenuItem(3L, 17072771L, "Salmon Teriyaki", "Entree", "", 10.95),
				new MenuItem(4L, 17072771L, "Sesame Chicken", "Entree", "", 10.95),
				new MenuItem(1L, 17072771L, "Chicken Katsu", "Entree", "", 10.95),
				new MenuItem(1L, 17072771L, "Chicken Teriyaki", "Entree", "", 9.95),
				new MenuItem(1L, 17072771L, "Chicken Teriyaki", "Entree", "", 9.95),
				new MenuItem(1L, 17072771L, "Chicken Teriyaki", "Entree", "", 9.95),
				new MenuItem(1L, 17072771L, "Salmon Roll", "Sushi Roll", "", 4.95),
				new MenuItem(1L, 17072771L, "Eel Avocado Roll", "Sushi Roll", "", 6.50),
				new MenuItem(1L, 17072771L, "Salmon Skin Roll", "Sushi Roll", "", 5.95),
				new MenuItem(1L, 17072771L, "Spicy Tuna Roll", "Sushi Roll", "", 5.95),
				new MenuItem(1L, 17072771L, "Spider Roll", "Sushi Roll", "", 9.95));
		assertEquals(expected, actual);
	}
	

}

