package com.tip.model;

public class Tip {
	private Integer id;
	private String name;
	private String contents;
	private Integer idType;
	private String deleteDate;
	private String updateDate;
	
	public Tip(Integer id, String name, String contents, Integer idType, String deleteDate, String updateDate) {
		super();
		this.id = id;
		this.name = name;
		this.contents = contents;
		this.idType = idType;
		this.deleteDate = deleteDate;
		this.updateDate = updateDate;
	}
	public Tip() {
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
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Integer getIdType() {
		return idType;
	}
	public void setIdType(Integer idType) {
		this.idType = idType;
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
