package com.example.cst438Frontend.domain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.cst438Frontend.Customer;

@Repository
public interface CustomerRepository extends JpaRepository <Customer, Long>{
	Customer findById(long id);

}
