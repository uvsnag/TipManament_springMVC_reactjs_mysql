package com.tip.form;

public class CategoryForm {
	private Integer id;
	private String name;
	private String description;
	private Integer idParent;
	private String typeCategory;
	private String typeUpdate;
	
	public Integer getIdParent() {
		return idParent;
	}
	public void setIdParent(Integer idParent) {
		this.idParent = idParent;
	}
	public String getTypeCategory() {
		return typeCategory;
	}
	public void setTypeCategory(String typeCategory) {
		this.typeCategory = typeCategory;
	}
	public String getTypeUpdate() {
		return typeUpdate;
	}
	public void setTypeUpdate(String typeUpdate) {
		this.typeUpdate = typeUpdate;
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
	public CategoryForm(Integer id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	public CategoryForm() {
		super();
	}
	
}
