package com.sapient.category.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sapient.category.entity.Category;
import com.sapient.category.entity.Product;
import com.sapient.category.repository.CategoryJPARepository;
import com.sapient.category.repository.ProductJPARepository;

@Repository
public class CategoryDAOImpl implements CategoryDAO {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CategoryJPARepository categoryJPA;

	@Autowired
	private ProductJPARepository productJPA;

	@Override
	public List<Category> getTopCategories() {
		logger.info("Inside : getTopCategories");
		ArrayList<Category> allCategories = (ArrayList<Category>) categoryJPA.findAll();
		List<Category> topCategories = new ArrayList<>();
		for(Category category : allCategories) {
			logger.info("Category : "+ category.getTopGroup().toString());
			if(category.getTopGroup()) {
				topCategories.add(category);
			}
		}
		return topCategories;
	}

	@Override
	public List<Category> getCategoryHierarchy(int depth) {
		return getTopCategories();
	}

	@Override
	public Category getCategoryDetails(int id) {
		Optional<Category> category = categoryJPA.findById(id);
		if (!category.isPresent()) {
			// throw new exception
		}
		return category.get();
	}

	@Override
	public List<Product> getProducts(int categoryId) {
		return getCategoryDetails(categoryId).getProducts();
	}

	@Override
	public Product getProductDetails(int productId) {
		Optional<Product> product = productJPA.findById(productId);
		if (!product.isPresent()) {
			// throw exception if no entry found
		}
		return product.get();
	}

}
