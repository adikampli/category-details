package com.sapient.category.entity;

public class Product {

	private int productId;
	private String name;
	private float listPrice;
	private float offerPrice;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getListPrice() {
		return listPrice;
	}

	public void setListPrice(float listPrice) {
		this.listPrice = listPrice;
	}

	public float getOfferPrice() {
		return offerPrice;
	}

	public void setOfferPrice(float offerPrice) {
		this.offerPrice = offerPrice;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", listPrice=" + listPrice + ", offerPrice="
				+ offerPrice + "]";
	}

	public Product(int productId, String name, float listPrice, float offerPrice) {
		super();
		this.productId = productId;
		this.name = name;
		this.listPrice = listPrice;
		this.offerPrice = offerPrice;
	}

	public Product() {
	}
}
