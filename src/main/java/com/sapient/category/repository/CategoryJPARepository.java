package com.sapient.category.repository;

import org.springframework.data.repository.CrudRepository;

import com.sapient.category.entity.Category;

public interface CategoryJPARepository extends CrudRepository<Category, Integer> {

}
