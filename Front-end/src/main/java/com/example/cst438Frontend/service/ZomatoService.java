package com.example.cst438Frontend.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.cst438Frontend.domain.Restaurant;
import com.fasterxml.jackson.databind.JsonNode;

@Service
public class ZomatoService {
	
	private static final Logger log = LoggerFactory.getLogger(ZomatoService.class);
	private RestTemplate restTemplate;
	private String zomatoUrl;
	private String apiKey;
	
	public ZomatoService(
			@Value("${zomato.url}") final String zomatoUrl,
			@Value("${zomato.apikey}") final String apiKey
			) {
		this.restTemplate = new RestTemplate();
		this.zomatoUrl = zomatoUrl;
		this.apiKey = apiKey;
	}
	
	public List<Restaurant> GetRestaurantsInArea(double lat, double lon) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("user-key", apiKey);
		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
		
		String endpoint = zomatoUrl + "?lat=" + lat + "&lon=" + lon;
		
		ResponseEntity<JsonNode> response = restTemplate.exchange(endpoint, HttpMethod.GET, entity, JsonNode.class);
		JsonNode json = response.getBody();
		log.info("Status code from zomato service: " + response.getStatusCodeValue());
		List<Restaurant> restaurants = new ArrayList<Restaurant>();
		JsonNode locations = json.get("nearby_restaurants");
		locations.forEach(
				location -> restaurants.add(new Restaurant(
						location.get("restaurant").get("id").asInt(),
						location.get("restaurant").get("name").asText(),
						location.get("restaurant").get("location").get("address").asText(),
						location.get("restaurant").get("cuisines").asText()
						))
				);
		return restaurants;
	}
	
}
