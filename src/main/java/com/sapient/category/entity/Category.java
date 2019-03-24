package com.sapient.category.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;

@Entity
public class Category {

	@Column(name = "category_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryId;

	@Column(name = "catgroup_id")
	private String catGroupId;

	@Column(name = "name")
	private String name;

	@Column(name = "top_group")
	@Type(type="true_false")
	private Boolean topGroup;

	@Column(name = "image")
	private String image;

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "category_product_rel", joinColumns = {
			@JoinColumn(name = "category_id", referencedColumnName = "category_id") }, inverseJoinColumns = {
					@JoinColumn(name = "product_id", referencedColumnName = "product_id") })
	private List<Product> products;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinTable(name = "category_rel", joinColumns = {
			@JoinColumn(name = "child_category_id", referencedColumnName = "category_id") }, inverseJoinColumns = {
					@JoinColumn(name = "parent_category_id", referencedColumnName = "category_id") })
	private Category parent_category;

	@OneToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "category_rel", joinColumns = {
			@JoinColumn(name = "parent_category_id", referencedColumnName = "category_id") }, inverseJoinColumns = {
					@JoinColumn(name = "child_category_id", referencedColumnName = "category_id") })
	private List<Category> child_category;

	public Boolean getTopGroup() {
		return topGroup;
	}

	public void setTopGroup(Boolean topGroup) {
		this.topGroup = topGroup;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCatGroupId() {
		return catGroupId;
	}

	public void setCatGroupId(String catGroupId) {
		this.catGroupId = catGroupId;
	}

	public boolean isTopGroup() {
		return topGroup;
	}

	public void setTopGroup(boolean topGroup) {
		this.topGroup = topGroup;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Category getParent_category() {
		return parent_category;
	}

	public void setParent_category(Category parent_category) {
		this.parent_category = parent_category;
	}

	public List<Category> getChild_category() {
		return child_category;
	}

	public void setChild_category(List<Category> child_category) {
		this.child_category = child_category;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return products;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", catGroupId=" + catGroupId + ", name=" + name + ", topGroup="
				+ topGroup + ", image=" + image + ", products=" + products + ", parent_category=" + parent_category
				+ ", child_category=" + child_category + "]";
	}

	public Category(int categoryId, String catGroupId, String name, boolean topGroup, String image,
			List<Product> products, Category parent_category, List<Category> child_category) {
		super();
		this.categoryId = categoryId;
		this.catGroupId = catGroupId;
		this.name = name;
		this.topGroup = topGroup;
		this.image = image;
		this.products = products;
		this.parent_category = parent_category;
		this.child_category = child_category;
	}

	public Category() {
	}
}
