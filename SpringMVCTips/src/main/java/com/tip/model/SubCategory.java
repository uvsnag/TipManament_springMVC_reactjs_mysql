package com.tip.model;

import java.util.List;

public class SubCategory {
	private Integer id;
	private String name;
	private String description;
	private Integer idMaster;
	private String deleteDate;
	private String updateDate;
	private List<Tip> tips;
	
	public SubCategory() {
		super();
	}
	public SubCategory(Integer id, String name, String description, Integer idMaster, String deleteDate,
			String updateDate) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.idMaster = idMaster;
		this.deleteDate = deleteDate;
		this.updateDate = updateDate;
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
	public Integer getIdMaster() {
		return idMaster;
	}
	public void setIdMaster(Integer idMaster) {
		this.idMaster = idMaster;
	}
	public List<Tip> getTips() {
		return tips;
	}
	public void setTips(List<Tip> tips) {
		this.tips = tips;
	}
	public String getDeleteDate() {
		return deleteDate;
	}
	public void setDeleteDate(String deleteDate) {
		this.deleteDate = deleteDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	
}
