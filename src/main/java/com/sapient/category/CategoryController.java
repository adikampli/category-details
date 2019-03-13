package com.sapient.category;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.category.entity.Category;
import com.sapient.category.entity.Product;
import com.sapient.category.service.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService service;

	@GetMapping("/category")
	public ArrayList<Category> getTopCategories() {
		return service.getTopCategories();
	}

	@GetMapping("/category/{depth}")
	public ArrayList<Category> getCategoryHierarchy(@PathVariable(name = "depth") int depth) {
		return service.getCategoryHierarchy(depth);
	}

	@GetMapping("/category/id/{categoryId}")
	public Category getCategoryDetails(@PathVariable(name = "categoryId") int categoryId) {
		return service.getCategoryDetails(categoryId);
	}

	@GetMapping(path = "/category/id/{categoryId}/product")
	public Category getProducts(@PathVariable(name = "categoryId") int categoryId) {
		return service.getProducts(categoryId);
	}

	@GetMapping(path = "/product/id/{productId}")
	public Product getProductDetails(@PathVariable(name = "productId") int productId) {
		return service.getProductDetails(productId);
	}
}
