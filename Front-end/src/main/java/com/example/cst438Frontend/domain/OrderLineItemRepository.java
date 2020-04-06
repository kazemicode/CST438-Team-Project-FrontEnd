package com.example.cst438Frontend.domain;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.example.cst438Frontend.*;

// use composite id?
public interface OrderLineItemRepository extends CrudRepository <OrderLineItem, OrderLineItemId>{
	List<OrderLineItem> findByOrderId(long order_id);

}
