package com.sapient.category.entity;

public class CategoryProductRel {

	private int productId;
	private int categoryId;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public CategoryProductRel(int productId, int categoryId) {
		super();
		this.productId = productId;
		this.categoryId = categoryId;
	}

	public CategoryProductRel() {
	}

	@Override
	public String toString() {
		return "CategoryProductRel [productId=" + productId + ", categoryId=" + categoryId + "]";
	}
}
