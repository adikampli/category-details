package com.sapient.category.dao;

import java.util.List;

import com.sapient.category.entity.Category;
import com.sapient.category.entity.Product;

public interface CategoryDAO {

	public List<Category> getTopCategories();

	public List<Category> getCategoryHierarchy(int depth);

	public Category getCategoryDetails(int id);

	public List<Product> getProducts(int categoryId);

	public Product getProductDetails(int productId);
}
