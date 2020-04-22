package com.example.cst438Frontend.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.cst438Frontend.Session;

@Repository
public interface SessionRepository extends CrudRepository <Session, Long>{
	Session findById(long id);
	
	Session deleteById(long id);

}
