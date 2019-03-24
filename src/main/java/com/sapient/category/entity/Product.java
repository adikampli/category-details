package com.sapient.category.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Product {

	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;

	@Column(name = "name")
	private String name;

	@Column(name = "list_price")
	private float listPrice;

	@Column(name = "offer_price")
	private float offerPrice;
	
	@Column(name = "partnumber")
	private String partnumber;
	
	
	@Column(name = "short_desc", columnDefinition="TEXT")
	private String shortDesc;
	
	@Column(name = "long_desc", columnDefinition="TEXT")
	private String longDesc;
	
	@Column(name = "image")
	private String image;

	@ManyToMany
	@JoinTable(name = "category_product_rel", joinColumns = {
			@JoinColumn(name = "product_id", referencedColumnName = "product_id") }, inverseJoinColumns = {
					@JoinColumn(name = "category_id", referencedColumnName = "category_id") })
	private List<Category> category;

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
	
	public String getPartnumber() {
		return partnumber;
	}

	public void setPartnumber(String partnumber) {
		this.partnumber = partnumber;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public String getLongDesc() {
		return longDesc;
	}

	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
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
