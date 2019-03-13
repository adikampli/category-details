package com.sapient.category.entity;

import java.util.ArrayList;

public class Category {

	private int id;
	private String name;
	private ArrayList<Product> products;

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", products=" + products + "]";
	}

	public Category(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Category() {
	}
}