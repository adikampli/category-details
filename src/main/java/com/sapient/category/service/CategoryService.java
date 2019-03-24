package com.sapient.category.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.category.dao.CategoryDAO;
import com.sapient.category.entity.Category;
import com.sapient.category.entity.Product;

@Service
public class CategoryService {

	@Autowired
	private CategoryDAO categoryDAO;

	public List<Category> getTopCategories() {
		return categoryDAO.getTopCategories();
	}

	public List<Category> getCategoryHierarchy(int depth) {
		return categoryDAO.getCategoryHierarchy(depth);
	}

	public Category getCategoryDetails(int id) {
		return categoryDAO.getCategoryDetails(id);
	}

	public List<Product> getProducts(int categoryId) {
		return categoryDAO.getProducts(categoryId);
	}

	public Product getProductDetails(int productId) {
		return categoryDAO.getProductDetails(productId);
	}

}
