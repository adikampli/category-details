package com.sapient.category.entity;

public class CategoryRel {

	private int parentCatId;
	private int childCatId;

	public int getParentCatId() {
		return parentCatId;
	}

	public void setParentCatId(int parentCatId) {
		this.parentCatId = parentCatId;
	}

	public int getChildCatId() {
		return childCatId;
	}

	public void setChildCatId(int childCatId) {
		this.childCatId = childCatId;
	}

	@Override
	public String toString() {
		return "CategoryRel [parentCatId=" + parentCatId + ", childCatId=" + childCatId + "]";
	}

	public CategoryRel(int parentCatId, int childCatId) {
		super();
		this.parentCatId = parentCatId;
		this.childCatId = childCatId;
	}

	public CategoryRel() {
	}
}
