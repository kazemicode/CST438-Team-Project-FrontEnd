package com.example.cst438Frontend.domain;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.example.cst438Frontend.Customer;
import com.example.cst438Frontend.OrderLineItem;

public interface CustomerRepository extends CrudRepository <Customer, Long>{
	Customer findById(long id);

}
