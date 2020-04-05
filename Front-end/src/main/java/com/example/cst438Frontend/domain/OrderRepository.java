package com.example.cst438Frontend.domain;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.cst438Frontend.Order;

public interface OrderRepository extends PagingAndSortingRepository <Order, Long> {
}
