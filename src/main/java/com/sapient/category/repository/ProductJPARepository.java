package com.sapient.category.repository;

import org.springframework.data.repository.CrudRepository;

import com.sapient.category.entity.Product;

public interface ProductJPARepository extends CrudRepository<Product, Integer> {

}
