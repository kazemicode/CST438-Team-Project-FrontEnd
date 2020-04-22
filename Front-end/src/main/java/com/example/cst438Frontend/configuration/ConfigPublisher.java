package com.example.cst438Frontend.configuration;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/* Sends Message to receiver (separate backend service) */

@Configuration
public class ConfigPublisher {
	public static final String TOPIC_EXCHANGE_NAME = "foodflight.topic";

	
	@Bean
	public Declarables topicBindings() {
		Queue deliveryQueue = new Queue("delivery-order", false);
		Queue restaurantQueue = new Queue("restaurant-order", false);

		TopicExchange topicExchange = new TopicExchange(TOPIC_EXCHANGE_NAME);
		
		return new Declarables(
				deliveryQueue,
				restaurantQueue,
				topicExchange,
				BindingBuilder
				.bind(deliveryQueue)
				.to(topicExchange).with("*.delivery"),
				BindingBuilder
				.bind(restaurantQueue)
				.to(topicExchange).with("*.restaurant"));
				
	}
	
	
	
}


