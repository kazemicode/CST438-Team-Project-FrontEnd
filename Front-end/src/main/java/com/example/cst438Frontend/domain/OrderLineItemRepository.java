package com.example.cst438Frontend.domain;
import org.springframework.data.repository.CrudRepository;
import com.example.cst438Frontend.OrderLineItem;
import com.example.cst438Frontend.OrderLineItemId;

public interface OrderLineItemRepository extends CrudRepository <OrderLineItem, OrderLineItemId>{

}
