package com.sapient.category.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.sapient.category.entity.Category;
import com.sapient.category.entity.CategoryProductRel;
import com.sapient.category.entity.CategoryRel;
import com.sapient.category.entity.Product;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

	private static ArrayList<Category> allCategories = new ArrayList<>();
	private static ArrayList<Product> allProducts = new ArrayList<>();
	private static ArrayList<CategoryRel> allCategoriesRelations = new ArrayList<>();
	private static ArrayList<CategoryProductRel> allCategoriesProductRelations = new ArrayList<>();

	/*
	 * @Autowired private CategoryProxy proxy;
	 */

	// TODO: Fetch all data from DB
	private static Category category1 = new Category(1, "Knit Tops 1");
	private static Category category2 = new Category(2, "Knit Tops 2");
	private static Category category3 = new Category(3, "Knit Tops 3");

	// Subcategories
	private static Category subCategory1 = new Category(4, "Knit Tops 4");
	private static Category subCategory2 = new Category(5, "Knit Tops 5");
	private static Category subCategory3 = new Category(6, "Knit Tops 6");

	private static Category thirdLevelCategory1 = new Category(7, "Knit Tops 7");
	private static Category thirdLevelCategory2 = new Category(8, "Knit Tops 8");
	private static Category thirdLevelCategory3 = new Category(9, "Knit Tops 9");

	// Products
	private static Product product1 = new Product(1, "Product 1", 20, 20);
	private static Product product2 = new Product(2, "Product 2", 30, 30);
	private static Product product3 = new Product(3, "Product 3", 25, 25);

	private static CategoryProductRel productRel1 = new CategoryProductRel(1, 1);
	private static CategoryProductRel productRel2 = new CategoryProductRel(2, 2);
	private static CategoryProductRel productRel3 = new CategoryProductRel(3, 1);

	private static CategoryRel topCatRel1 = new CategoryRel(-1, 3);
	private static CategoryRel topCatRel2 = new CategoryRel(-1, 2);
	private static CategoryRel topCatRel3 = new CategoryRel(-1, 1);
	private static CategoryRel catRel1 = new CategoryRel(1, 4);
	private static CategoryRel catRel2 = new CategoryRel(2, 5);
	private static CategoryRel catRel3 = new CategoryRel(3, 6);
	private static CategoryRel catRel4 = new CategoryRel(4, 7);
	private static CategoryRel catRel5 = new CategoryRel(5, 8);
	private static CategoryRel catRel6 = new CategoryRel(6, 9);

	static {
		allCategories.add(category1);
		allCategories.add(category2);
		allCategories.add(category3);
		allCategories.add(subCategory1);
		allCategories.add(subCategory2);
		allCategories.add(subCategory3);
		allCategories.add(thirdLevelCategory1);
		allCategories.add(thirdLevelCategory2);
		allCategories.add(thirdLevelCategory3);

		allCategoriesRelations.add(topCatRel1);
		allCategoriesRelations.add(topCatRel2);
		allCategoriesRelations.add(topCatRel3);
		allCategoriesRelations.add(catRel1);
		allCategoriesRelations.add(catRel2);
		allCategoriesRelations.add(catRel3);
		allCategoriesRelations.add(catRel4);
		allCategoriesRelations.add(catRel5);
		allCategoriesRelations.add(catRel6);

		allProducts.add(product1);
		allProducts.add(product2);
		allProducts.add(product3);

		allCategoriesProductRelations.add(productRel1);
		allCategoriesProductRelations.add(productRel2);
		allCategoriesProductRelations.add(productRel3);
	}

	@Override
	public ArrayList<Category> getTopCategories() {
		ArrayList<Category> topCategories = new ArrayList<Category>();
		for (Category category : allCategories) {
			for (CategoryRel categoryRel : allCategoriesRelations) {
				if (category.getId() == categoryRel.getChildCatId() && categoryRel.getParentCatId() == -1) {
					topCategories.add(category);
				}
			}
		}
		return topCategories;
	}

	@Override
	public ArrayList<Category> getCategoryHierarchy(int depth) {
		ArrayList<Category> categoryHierarchy = new ArrayList<>();
		ArrayList<Category> topCategories = getTopCategories();
		if (depth == 1) {
			categoryHierarchy = topCategories;
		}

		return categoryHierarchy;
	}

	@Override
	public Category getCategoryDetails(int id) {
		for (Category category : allCategories) {
			if (category.getId() == id) {
				return category;
			}
		}
		return null;
	}

	@Override
	public Category getProducts(int categoryId) {
		
		ArrayList<Integer> productIds = new ArrayList<>();
		ArrayList<Product> products = new ArrayList<>();

//		Product product = proxy.getProducts(categoryId);

		for (CategoryProductRel catProRel : allCategoriesProductRelations) {
			if (catProRel.getCategoryId() == categoryId) {
				productIds.add(catProRel.getProductId());
			}
		}
		for (int productId : productIds) {
			for (Product pro : allProducts) {
				if (pro.getProductId() == productId) {
					products.add(pro);
				}
			}
		}
		Category category = getCategoryDetails(categoryId);
		category.setProducts(products);
		return category;
	}

	@Override
	public Product getProductDetails(int productId) {
		for (Product pro : allProducts) {
			if (pro.getProductId() == productId) {
				return pro;
			}
		}
		return null;
	}

}
