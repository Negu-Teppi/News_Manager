package com.manhlee.productspringmvc.repository;

import com.manhlee.productspringmvc.entities.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {

}
