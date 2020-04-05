package com.example.cst438Frontend.service;


import java.util.List;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cst438Frontend.LineItem;


@Service
public class OrderService {
	@Autowired
	private RabbitTemplate rabbitTemplate;
	@Autowired
	private FanoutExchange fanout;
	
	public void requestOrder(long orderId, String time, String customerName, String phoneNumber, String address, List<LineItem> items, double total, String paymentType) {
		String msg = "{\"Order Number\": \"" + orderId + "\" \"Time\": \"" + time + "\" \"Customer name\": \"" + customerName + "\" \"Phone\": \"" + phoneNumber + "\" \"address\": \"" + address + "\" \"Items\": \"" + items + "\" \"Total\": \\" + total + "\" \"Payment type\": \\" + "}";
		System.out.println("Sending message:" + msg);
		rabbitTemplate.convertSendAndReceive(fanout.getName(), "", // routing key none.
				msg);
	}


}



