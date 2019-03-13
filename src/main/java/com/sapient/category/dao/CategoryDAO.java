package com.sapient.category.dao;

import java.util.ArrayList;

import com.sapient.category.entity.Category;
import com.sapient.category.entity.Product;

public interface CategoryDAO {

	public ArrayList<Category> getTopCategories();

	public ArrayList<Category> getCategoryHierarchy(int depth);

	public Category getCategoryDetails(int id);

	public Category getProducts(int categoryId);

	public Product getProductDetails(int productId);
}
