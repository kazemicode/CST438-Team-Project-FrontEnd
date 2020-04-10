package com.example.cst438Frontend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.cst438Frontend.domain.User;
import com.fasterxml.jackson.databind.JsonNode;

@Service
public class FindRestaurantService {

	private static final Logger log = LoggerFactory.getLogger(FindRestaurantService.class);
	private RestTemplate restTemplate;
	private String bingUrl;
	private String apiKey;
	private String maxResults = "1";
	User user;
	
	public FindRestaurantService(
			@Value("${bing.url}") final String bingUrl,
			@Value("${bing.apikey}") final String apiKey ) {
		this.restTemplate = new RestTemplate();
		this.bingUrl = bingUrl;
		this.apiKey = apiKey;
	}
	
	public void getGeoCodes(User user) {		
		ResponseEntity<JsonNode> response = restTemplate.getForEntity(bingUrl + user.getState() + "/" +
				user.getZip_code() + "/" + user.getCity() + "/" + user.getAddress() + "/" + 
				"?&maxResults=" + maxResults + "&key=" + apiKey, JsonNode.class);
		JsonNode json = response.getBody();
		log.info("Status code from bing server:" + response.getStatusCodeValue());
		String latitude = json.get("resourceSets").get(0).get("resources").get(0).get("geocodePoints").get(0).get("coordinates").get(0).asText();
		String longitude = json.get("resourceSets").get(0).get("resources").get(0).get("geocodePoints").get(0).get("coordinates").get(1).asText();
		user.setLatitude(latitude);
		user.setLongitude(longitude);
	}
}
