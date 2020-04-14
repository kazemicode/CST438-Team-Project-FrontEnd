package com.example.cst438Frontend.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.example.cst438Frontend.*;
import com.example.cst438Frontend.domain.*;
import com.example.cst438Frontend.service.OrderService;

@SpringBootTest
public class OrderServiceTest {
	@MockBean
	private OrderRepository orderRepository;
	@MockBean
	private OrderLineItemRepository orderLineItemRepository;
	@MockBean
	private CustomerRepository customerRepository;
	@MockBean
	private MenuRepository menuRepository;
	@Autowired
	private OrderService orderService;
	
	
	@Test
	public void contextLoads() {
	}
	
	@Test
public void orderFound() throws Exception {
		Timestamp datetime = new Timestamp(new Date().getTime());
		long id = 3799;
		long cust_id = 4;
		double order_total = 22.45;
		double tip = 5.00;
		double grand_total = order_total + tip;
		String payment_type = "PayPal";
		
		/* Mocked objects: Order, List of Order Line Items, Customer*/
		Order order = new Order(id, cust_id, datetime, order_total, tip, grand_total, payment_type);
		
		// each line item consists of: long order_id, int order_sequence, long dish_id, int qty, double line_item_amount
		List<OrderLineItem> orderLineItems = 
                Arrays.asList(
                		new OrderLineItem(id, 1, 52, 1, 2.99),
                		new OrderLineItem(id, 2, 2, 2, 13.99));
		
		// Transform to line item info objects
		MenuItem m1 = new MenuItem(1, 1, "Wontons", "Appetizers", "Delicious", 2.99);
		MenuItem m2 = new MenuItem(1, 1, "Green Curry", "Curry", "Appetizer", 13.99);
		List<LineItemInfo> lineItemInfo = 
			      Arrays.asList(
	                		new LineItemInfo(m1, orderLineItems.get(0)),
	                		new LineItemInfo(m2, orderLineItems.get(1)));

		Customer customer = new Customer(cust_id, "David", "Wisneski", "100 Campus Center", "", "Seaside", "CA", "93955", "831-582-4580");

		OrderInfo expected = new OrderInfo(order, customer, lineItemInfo);
		
		given(orderRepository.findById(id)).willReturn(order);
		given(orderLineItemRepository.findByOrderId(id)).willReturn(orderLineItems);
		given(customerRepository.findById(cust_id)).willReturn(customer);

		// when
		OrderInfo actual =  orderService.getOrderInfo(id);
		// then verify that the order info is correct
		assertEquals(expected, actual);
				
	}
}
