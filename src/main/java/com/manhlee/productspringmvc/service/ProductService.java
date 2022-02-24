package com.manhlee.productspringmvc.service;

import com.manhlee.productspringmvc.entities.ProductEntity;
import com.manhlee.productspringmvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductEntity> getProducts() {
        return (List<ProductEntity>) productRepository.findAll();
    }

    public void save(ProductEntity product){
        productRepository.save(product);
    }
}
