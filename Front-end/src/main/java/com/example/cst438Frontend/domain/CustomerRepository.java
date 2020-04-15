package com.example.cst438Frontend.domain;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.cst438Frontend.Customer;

@Repository
public interface CustomerRepository extends CrudRepository <Customer, Long>{
	Customer findById(long id);

}
