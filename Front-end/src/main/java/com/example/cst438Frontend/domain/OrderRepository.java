package com.example.cst438Frontend.domain;


import org.springframework.data.repository.CrudRepository;
import com.example.cst438Frontend.Order;

public interface OrderRepository extends CrudRepository <Order, Long> {
	Order findById(long id);
}
