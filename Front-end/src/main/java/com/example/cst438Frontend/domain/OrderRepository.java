package com.example.cst438Frontend.domain;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.cst438Frontend.Order;

@Repository
public interface OrderRepository extends CrudRepository <Order, Long> {
	Order findById(long id);
}
