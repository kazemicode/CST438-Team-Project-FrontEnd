package com.example.cst438Frontend.service;


import java.util.ArrayList;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.cst438Frontend.*;
import com.example.cst438Frontend.configuration.ConfigPublisher;
import com.example.cst438Frontend.domain.*;


@Service
public class OrderService {
	private static final Logger log = LoggerFactory.getLogger(OrderService.class);
	
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderLineItemRepository orderLineItemRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private MenuRepository menuRepository;
	
	
	@Autowired
	private RabbitTemplate rabbitTemplate;

	private static String ROUTING_KEY_RESTAURANT = "restaurant.request";
	private static String ROUTING_KEY_DELIVERY = "delivery.request";

	
	// Returns order info object
	public OrderInfo getOrderInfo(long orderId) {
		log.info("Order to retrieve: " + orderId);
		
		// Retrieve order matching the id
		Order order = orderRepository.findById(orderId);
		// if not found, return null
		if (order.equals(null)) {
			return null;
		}
		
		
		// Retrieve line items matching the order id
		List<OrderLineItem> lineItems = orderLineItemRepository.findByOrderId(orderId);
		// if not found, return null
		if (lineItems.isEmpty()) {
			return null;
		}	
		// Transform into LineItemInfo objects
		List<LineItemInfo> lineItemInfo = this.getLineItemInfo(lineItems);
		
		
		// Get customer by id
		Customer customer = customerRepository.findById(order.getCustomer().getId());
		if (customer.equals(null)) {
			return null;
		}
		
		
		return new OrderInfo(order, customer, lineItemInfo);
	}
	
	public List<LineItemInfo> getLineItemInfo(List<OrderLineItem> lineItems){
		List<LineItemInfo> lineItemInfo = new ArrayList<>();
		for(OrderLineItem lineItem : lineItems) {
			MenuItem menuItem = menuRepository.findById(lineItem.getDishId());
			lineItemInfo.add(new LineItemInfo(menuItem, lineItem));
		}
		
		return lineItemInfo;
		
	}

	
	public void requestOrder(long orderId, String time, String customerName, String phoneNumber, String address, List<LineItemInfo> items, double total, String paymentType) {
		String msg = "{\"Order Number\": \"" + orderId +
				"\" \"Time\": \"" + time +
				"\" \"Customer name\": \"" + customerName +
				"\" \"Phone\": \"" + phoneNumber +
				"\" \"address\": \"" + address +
				"\" \"Items\": \"" + items +
				"\" \"Total\": \"" + total +
				"\" \"Payment type\": \"" + "\"}";
		System.out.println("Sending order to restaurant:" + msg);
		rabbitTemplate.convertSendAndReceive(ConfigPublisher.TOPIC_EXCHANGE_NAME, ROUTING_KEY_RESTAURANT, 
				msg);
		
	}
	
	public void requestDelivery(long orderId, String time, String address, long restId) {
		String msg = "\"Order Number\": \"" + orderId +
				"\" \"Time\": \"" + time +
				"\" \"Customer address\": \"" + address +
				"\" \"Restaurant ID\": \"" + restId + "\"}";
		System.out.println("Sending order to delivery personnel:" + msg);
		rabbitTemplate.convertSendAndReceive(ConfigPublisher.TOPIC_EXCHANGE_NAME, ROUTING_KEY_DELIVERY, 
				msg);
	}
	
}



