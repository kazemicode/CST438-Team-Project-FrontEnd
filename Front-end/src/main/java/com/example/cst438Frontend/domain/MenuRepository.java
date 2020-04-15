package com.example.cst438Frontend.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.cst438Frontend.MenuItem;


@Repository
public interface MenuRepository extends CrudRepository <MenuItem, Long> {
	MenuItem findById(long id);
	List<MenuItem> findByRestId(long restId);

}