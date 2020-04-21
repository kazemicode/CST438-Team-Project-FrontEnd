package com.example.cst438Frontend.configuration;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/* Sends Message to receiver (separate backend service) */

@Configuration
public class ConfigPublisher {
	
	@Bean
	@Qualifier("fanoutOrder")
	public FanoutExchange fanoutOrder() {
		return new FanoutExchange("restaurant-order");
	}
	
	@Bean
	@Qualifier("fanoutDelivery")
	public FanoutExchange fanoutDelivery() {
		return new FanoutExchange("delivery-order");
	}
	
}


