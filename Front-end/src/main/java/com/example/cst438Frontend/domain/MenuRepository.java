package com.example.cst438Frontend.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.example.cst438Frontend.*;



public interface MenuRepository extends CrudRepository <MenuItem, Long> {
	List<MenuItem> findById(long id);

}
