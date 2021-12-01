package com.tip.form;

import java.util.List;

import com.tip.model.CategoryMaster;
import com.tip.model.SubCategory;

public class TipInfo3Level {
	private CategoryMaster categoryMaster;
	private List<SubCategory> subCategory;
	
	public CategoryMaster getCategoryMaster() {
		return categoryMaster;
	}
	public void setCategoryMaster(CategoryMaster categoryMaster) {
		this.categoryMaster = categoryMaster;
	}
	public List<SubCategory> getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(List<SubCategory> subCategory) {
		this.subCategory = subCategory;
	}

}
