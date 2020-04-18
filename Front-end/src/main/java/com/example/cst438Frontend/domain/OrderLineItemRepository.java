package com.example.cst438Frontend.domain;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.cst438Frontend.*;

// use composite id?
@Repository
public interface OrderLineItemRepository extends CrudRepository <OrderLineItem, Long>{
	List<OrderLineItem> findByOrderId(long order_id);

}
