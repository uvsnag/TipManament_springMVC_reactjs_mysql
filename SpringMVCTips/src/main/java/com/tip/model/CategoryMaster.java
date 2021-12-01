package com.tip.model;

public class CategoryMaster {
	private  Integer id;
	private String name;
	private String description;
	private String DeleteDate;
	private String UpdateDate;
	
	public CategoryMaster(Integer id, String name, String description, String deleteDate, String updateDate) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		DeleteDate = deleteDate;
		UpdateDate = updateDate;
	}
	public CategoryMaster() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDeleteDate() {
		return DeleteDate;
	}
	public void setDeleteDate(String deleteDate) {
		DeleteDate = deleteDate;
	}
	public String getUpdateDate() {
		return UpdateDate;
	}
	public void setUpdateDate(String updateDate) {
		UpdateDate = updateDate;
	}
	
	
}
