package com.example.cst438Frontend.service;


import java.util.List;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.cst438Frontend.LineItem;
import com.example.cst438Frontend.domain.OrderLineItemRepository;
import com.example.cst438Frontend.domain.OrderRepository;


@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderLineItemRepository orderLineItemRepository;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	@Autowired
	private FanoutExchange fanout;
	
	// future story todo: implement so we can query the db for orders already placed
	
	
	public void requestOrder(long orderId, String time, String customerName, String phoneNumber, String address, List<LineItem> items, double total, String paymentType) {
		String msg = "{\"Order Number\": \"" + orderId + "\" \"Time\": \"" + time + "\" \"Customer name\": \"" + customerName + "\" \"Phone\": \"" + phoneNumber + "\" \"address\": \"" + address + "\" \"Items\": \"" + items + "\" \"Total\": \\" + total + "\" \"Payment type\": \\" + "}";
		System.out.println("Sending message:" + msg);
		rabbitTemplate.convertSendAndReceive(fanout.getName(), "", // routing key none.
				msg);
	}


}



