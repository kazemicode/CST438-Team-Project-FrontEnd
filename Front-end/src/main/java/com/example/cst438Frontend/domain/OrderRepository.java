package com.example.cst438Frontend.domain;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.cst438Frontend.Order;

@Repository
public interface OrderRepository extends JpaRepository <Order, Long> {
	Order findById(long id);
}
